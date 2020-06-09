package com.tzx.rpc.transport;

import lombok.extern.slf4j.Slf4j;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * @author 田泽鑫
 * @date 2020/4/13
 * @description
 */
@Slf4j
public class HttpTransportServer implements TransportServer {
    private RequestHandler handler;
    private Server server;

    @Override
    public void init(int port, RequestHandler handler) {
        this.handler = handler;
        this.server = new Server(port);

        //servlet接受请求
        ServletContextHandler ctx = new ServletContextHandler();
        server.setHandler(ctx);

        //ServletHolder是jetty处理网络请求时的一个抽象
        ServletHolder holder = new ServletHolder(new RequestServlet());
        //处理所有路径
        ctx.addServlet(holder,"/*");
    }

    @Override
    public void start() {
        //jetty 的Server有线程在监听端口,监听到数据之后立马返回，为了不让立即返回，
        try {
            server.start();
            server.join();
        } catch (Exception e) {
            log.error(e.getMessage(),e);
        }
    }

    @Override
    public void stop() {
        try {
            server.stop();
        } catch (Exception e) {
            log.error(e.getMessage(),e);
        }
    }

    class RequestServlet extends HttpServlet{

        @Override
        protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            log.info("client connect");
            InputStream inputStream = req.getInputStream();
            OutputStream outputStream = resp.getOutputStream();

            if (handler != null){
                handler.onRequest(inputStream,outputStream);
            }
            outputStream.flush();
        }
    }
}

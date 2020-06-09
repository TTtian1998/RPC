package com.tzx.rpc.server;

import com.tzx.rpc.Request;
import com.tzx.rpc.Response;
import com.tzx.rpc.codec.Dencoder;
import com.tzx.rpc.codec.Encoder;
import com.tzx.rpc.common.utils.ReflectUtils;
import com.tzx.rpc.transport.RequestHandler;
import com.tzx.rpc.transport.TransportServer;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * @author ÃÔ‘ÛˆŒ
 * @date 2020/4/13
 * @description
 */
@Slf4j
public class RpcServer {
    private RpcServerConfig config;
    private TransportServer net;
    private Encoder encoder;
    private Dencoder dencoder;
    private ServiceManager serviceManager;
    private ServiceInvoker serviceInvoker;

    public RpcServer(RpcServerConfig config) {
        this.config = config;

        //net
        this.net = ReflectUtils.newInstance(config.getTransportClass());
        this.net.init(config.getPort(),this.handler);
        this.encoder = ReflectUtils.newInstance(config.getEncoderClass());
        this.dencoder = ReflectUtils.newInstance(config.getDencoderClass());

        this.serviceManager = new ServiceManager();
        this.serviceInvoker = new ServiceInvoker();
    }

    public <T> void register(Class<T> interfaceClass,T bean){
        serviceManager.register(interfaceClass,bean);
    }

    public void start(){
        this.net.start();
    }

    public void stop(){
        this.net.stop();
    }

    private RequestHandler handler = new RequestHandler() {
        @Override
        public void onRequest(InputStream receive, OutputStream toResp) {
            Response response = new Response();
            try {
                byte[] inBytes = IOUtils.readFully(receive,receive.available());
                Request request = dencoder.decode(inBytes,Request.class);
                log.info("get request: {}",request);

                ServiceInstance sis = serviceManager.lookup(request);
                Object ret = serviceInvoker.invoke(sis,request);
                response.setData(ret) ;
            } catch (Exception e) {
                log.error(e.getMessage(),e);
                // ß∞‹
                response.setCode(1);
                response.setMessage("RpcServer got error: " + e.getClass().getName() +" : " + e.getMessage());
            }finally {
                try {
                    byte[] outBytes = encoder.encode(response);
                    toResp.write(outBytes);

                    log.info("response client");
                } catch (IOException e) {
                    log.warn(e.getMessage(),e);
                }
            }
        }
    };
}

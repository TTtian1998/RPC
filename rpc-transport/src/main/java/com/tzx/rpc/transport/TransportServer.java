package com.tzx.rpc.transport;

/**
 * @author 田泽鑫
 * @date 2020/4/13
 * @description 1 启动 监听端口  2 接受请求  3 关闭监听
 */
public interface TransportServer {
    void init(int port,RequestHandler handler);

    void start();

    void stop();
}

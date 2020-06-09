package com.tzx.rpc.example;

import com.tzx.rpc.server.RpcServer;
import com.tzx.rpc.server.RpcServerConfig;

/**
 * @author ÃÔ‘ÛˆŒ
 * @date 2020/4/13
 * @description
 */
public class Server {
    public static void main(String[] args) {
        RpcServer server = new RpcServer(new RpcServerConfig());
        server.register(CalcService.class,new CalcServiceImpl());
        server.start();
    }
}

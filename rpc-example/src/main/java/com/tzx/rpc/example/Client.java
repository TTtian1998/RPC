package com.tzx.rpc.example;

import com.tzx.rpc.client.RpcClient;

/**
 * @author ÃÔ‘ÛˆŒ
 * @date 2020/4/13
 * @description
 */
public class Client {
    public static void main(String[] args) {
        RpcClient client = new RpcClient();
        CalcService service = client.getProxy(CalcService.class);
        int r1 = service.add(1,2);
        int r2 = service.minus(10,6);
        System.out.println(r1);
        System.out.println(r2);
    }
}

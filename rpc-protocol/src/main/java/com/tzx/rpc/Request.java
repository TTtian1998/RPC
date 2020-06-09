package com.tzx.rpc;

import lombok.Data;

/**
 * @author 田泽鑫
 * @date 2020/4/7
 * @description RPC的一个请求
 */
@Data
public class Request {
    private ServiceDescriptor service;
    //调用服务时传入的参数
    private Object[] parameters;
}

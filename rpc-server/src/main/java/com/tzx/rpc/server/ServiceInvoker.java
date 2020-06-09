package com.tzx.rpc.server;

import com.tzx.rpc.Request;
import com.tzx.rpc.common.utils.ReflectUtils;

/**
 * @author 田泽鑫
 * @date 2020/4/13
 * @description 调用具体服务
 */
public class ServiceInvoker {
    public Object invoke(ServiceInstance serviceInstance, Request request){
        return ReflectUtils.invoke(serviceInstance.getTarget(),serviceInstance.getMethod(),request.getParameters());
    }
}

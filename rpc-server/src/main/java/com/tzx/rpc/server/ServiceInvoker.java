package com.tzx.rpc.server;

import com.tzx.rpc.Request;
import com.tzx.rpc.common.utils.ReflectUtils;

/**
 * @author ������
 * @date 2020/4/13
 * @description ���þ������
 */
public class ServiceInvoker {
    public Object invoke(ServiceInstance serviceInstance, Request request){
        return ReflectUtils.invoke(serviceInstance.getTarget(),serviceInstance.getMethod(),request.getParameters());
    }
}

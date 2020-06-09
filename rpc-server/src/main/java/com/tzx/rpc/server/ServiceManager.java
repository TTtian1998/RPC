package com.tzx.rpc.server;

import com.tzx.rpc.Request;
import com.tzx.rpc.ServiceDescriptor;
import com.tzx.rpc.common.utils.ReflectUtils;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author 田泽鑫
 * @date 2020/4/13
 * @description 管理RPC暴露的服务 注册服务 查找服务
 */
@Slf4j
public class ServiceManager {
    private Map<ServiceDescriptor,ServiceInstance> services;

    public ServiceManager(){
        this.services = new ConcurrentHashMap<>();
    }
    /**
     * @Author: tzx
     * @Description: 扫描所有方法
     * @param interfaceClass
     * @param bean
     * @Date: 2020/4/13 2:13
     * @return: void
     **/
    public <T> void register(Class<T> interfaceClass,T bean){
        Method[] methods = ReflectUtils.getPublicMethods(interfaceClass);
        for (Method method : methods) {
            ServiceInstance sis = new ServiceInstance(bean,method);
            ServiceDescriptor sdp = ServiceDescriptor.from(interfaceClass,method);

            services.put(sdp,sis);
            log.info("register service:{} {}",sdp.getClazz(),sdp.getMethod());
        }
    }

    public ServiceInstance lookup(Request request){
        ServiceDescriptor sdp =request.getService();
        return services.get(sdp);
    }

}

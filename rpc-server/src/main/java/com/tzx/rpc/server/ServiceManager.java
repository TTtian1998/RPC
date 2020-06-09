package com.tzx.rpc.server;

import com.tzx.rpc.Request;
import com.tzx.rpc.ServiceDescriptor;
import com.tzx.rpc.common.utils.ReflectUtils;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author ������
 * @date 2020/4/13
 * @description ����RPC��¶�ķ��� ע����� ���ҷ���
 */
@Slf4j
public class ServiceManager {
    private Map<ServiceDescriptor,ServiceInstance> services;

    public ServiceManager(){
        this.services = new ConcurrentHashMap<>();
    }
    /**
     * @Author: tzx
     * @Description: ɨ�����з���
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

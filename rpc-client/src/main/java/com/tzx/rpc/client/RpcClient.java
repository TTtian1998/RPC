package com.tzx.rpc.client;

import com.tzx.rpc.codec.Dencoder;
import com.tzx.rpc.codec.Encoder;
import com.tzx.rpc.common.utils.ReflectUtils;

import java.lang.reflect.Proxy;

/**
 * @author 田泽鑫
 * @date 2020/4/13
 * @description
 */
public class RpcClient {
    private RpcClientConfig config;
    private Encoder encoder;
    private Dencoder dencoder;
    private TransportSelector selector;

    public RpcClient() {
        this(new RpcClientConfig());
    }

    public RpcClient(RpcClientConfig config) {
        this.config = config;
        this.encoder = ReflectUtils.newInstance(this.config.getEncoderClass());
        this.dencoder = ReflectUtils.newInstance(this.config.getDencoderClass());
        this.selector = ReflectUtils.newInstance(this.config.getSelectorClass());
        this.selector.init(this.config.getServers(),this.config.getConnectCount(),this.config.getTransportClass());
    }
    /**
     * @Author: tzx
     * @Description: 使用JDK自带的动态代理
     * @param clazz
     * @Date: 2020/4/13 16:52
     * @return: T
     **/
    public <T> T getProxy(Class<T> clazz){
        return (T) Proxy.newProxyInstance(
                getClass().getClassLoader(),
                new Class[]{clazz},
                new RemoteInvoker(clazz,encoder,dencoder,selector)
        );
    }
}

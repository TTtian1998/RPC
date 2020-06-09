package com.tzx.rpc.client;

import com.tzx.rpc.Peer;
import com.tzx.rpc.transport.TransportClient;

import java.util.List;

/**
 * @author 田泽鑫
 * @date 2020/4/13
 * @description 表示选在哪个server去连接
 */
public interface TransportSelector {
    /**
     * @Author: tzx
     * @Description: 初始化selector
     * @param peers 可以连接的server端点信息
     * @param count client与server建立多少个连接
     * @param clazz client实现类
     * @Date: 2020/4/13 15:31
     * @return: void
     **/
    void init(List<Peer> peers,int count,Class<? extends TransportClient> clazz);
    /**
     * @Author: tzx
     * @Description: 选择一个transport与server做交互
     * @param
     * @Date: 2020/4/13 15:28
     * @return: com.tzx.rpc.transport.TransportClient
     **/
    TransportClient select();
    /**
     * @Author: tzx
     * @Description: 释放使用完的client
     * @param
     * @Date: 2020/4/13 15:29
     * @return: void
     **/
    void release(TransportClient client);

    void close();
}

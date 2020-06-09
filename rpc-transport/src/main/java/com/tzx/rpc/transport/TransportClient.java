package com.tzx.rpc.transport;

import com.tzx.rpc.Peer;

import java.io.InputStream;

/**
 * @author 田泽鑫
 * @date 2020/4/13
 * @description 1 创建连接  2 发送数据，等待响应 3 关闭连接
 */
public interface TransportClient {
    /**
     * @Author: tzx
     * @Description: 建立连接
     * @param peer
     * @Date: 2020/4/13 0:17
     * @return: void
     **/
    void connect(Peer peer);
    /**
     * @Author: tzx
     * @Description: 发送数据
     * @param data
     * @Date: 2020/4/13 0:17
     * @return: java.io.InputStream
     **/
    InputStream write(InputStream data);
    /**
     * @Author: tzx
     * @Description: 关闭连接
     * @param
     * @Date: 2020/4/13 0:17
     * @return: void
     **/
    void close();
}

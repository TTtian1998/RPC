package com.tzx.rpc.transport;

import com.tzx.rpc.Peer;

import java.io.InputStream;

/**
 * @author ������
 * @date 2020/4/13
 * @description 1 ��������  2 �������ݣ��ȴ���Ӧ 3 �ر�����
 */
public interface TransportClient {
    /**
     * @Author: tzx
     * @Description: ��������
     * @param peer
     * @Date: 2020/4/13 0:17
     * @return: void
     **/
    void connect(Peer peer);
    /**
     * @Author: tzx
     * @Description: ��������
     * @param data
     * @Date: 2020/4/13 0:17
     * @return: java.io.InputStream
     **/
    InputStream write(InputStream data);
    /**
     * @Author: tzx
     * @Description: �ر�����
     * @param
     * @Date: 2020/4/13 0:17
     * @return: void
     **/
    void close();
}

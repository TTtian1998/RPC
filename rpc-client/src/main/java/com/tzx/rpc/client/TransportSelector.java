package com.tzx.rpc.client;

import com.tzx.rpc.Peer;
import com.tzx.rpc.transport.TransportClient;

import java.util.List;

/**
 * @author ������
 * @date 2020/4/13
 * @description ��ʾѡ���ĸ�serverȥ����
 */
public interface TransportSelector {
    /**
     * @Author: tzx
     * @Description: ��ʼ��selector
     * @param peers �������ӵ�server�˵���Ϣ
     * @param count client��server�������ٸ�����
     * @param clazz clientʵ����
     * @Date: 2020/4/13 15:31
     * @return: void
     **/
    void init(List<Peer> peers,int count,Class<? extends TransportClient> clazz);
    /**
     * @Author: tzx
     * @Description: ѡ��һ��transport��server������
     * @param
     * @Date: 2020/4/13 15:28
     * @return: com.tzx.rpc.transport.TransportClient
     **/
    TransportClient select();
    /**
     * @Author: tzx
     * @Description: �ͷ�ʹ�����client
     * @param
     * @Date: 2020/4/13 15:29
     * @return: void
     **/
    void release(TransportClient client);

    void close();
}

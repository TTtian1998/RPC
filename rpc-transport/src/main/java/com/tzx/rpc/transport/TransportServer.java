package com.tzx.rpc.transport;

/**
 * @author ������
 * @date 2020/4/13
 * @description 1 ���� �����˿�  2 ��������  3 �رռ���
 */
public interface TransportServer {
    void init(int port,RequestHandler handler);

    void start();

    void stop();
}

package com.tzx.rpc.codec;

/**
 * @author ������
 * @date 2020/4/12
 * @description �����л����Ѷ�����byte����ת���ɶ���
 */
public interface Dencoder {
    /**
     * @Author: tzx
     * @Description: ʹ�÷��ͣ�ʡȥǿ��ת���Ĳ���
     * @param bytes
     * @param clazz
     * @Date: 2020/4/12 19:20
     * @return: T
     **/
    <T> T decode(byte[] bytes,Class<T> clazz);
}

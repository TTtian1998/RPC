package com.tzx.rpc.codec;

/**
 * @author ������
 * @date 2020/4/12
 * @description ���л����Ѷ���ת����byte����
 */
public interface Encoder {
    byte[] encode(Object object);
}

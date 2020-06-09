package com.tzx.rpc.codec;

/**
 * @author 田泽鑫
 * @date 2020/4/12
 * @description 序列化，把对象转换成byte数组
 */
public interface Encoder {
    byte[] encode(Object object);
}

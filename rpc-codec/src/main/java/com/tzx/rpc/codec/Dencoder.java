package com.tzx.rpc.codec;

/**
 * @author 田泽鑫
 * @date 2020/4/12
 * @description 反序列化，把二进制byte数组转换成对象
 */
public interface Dencoder {
    /**
     * @Author: tzx
     * @Description: 使用泛型，省去强制转换的步骤
     * @param bytes
     * @param clazz
     * @Date: 2020/4/12 19:20
     * @return: T
     **/
    <T> T decode(byte[] bytes,Class<T> clazz);
}

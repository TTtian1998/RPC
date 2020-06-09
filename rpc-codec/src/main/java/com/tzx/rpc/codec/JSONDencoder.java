package com.tzx.rpc.codec;

import com.alibaba.fastjson.JSON;

/**
 * @author 田泽鑫
 * @date 2020/4/12
 * @description 基于JSON的反序列化实现
 */
public class JSONDencoder implements Dencoder {
    @Override
    public <T> T decode(byte[] bytes, Class<T> clazz) {
        return JSON.parseObject(bytes,clazz);
    }

}

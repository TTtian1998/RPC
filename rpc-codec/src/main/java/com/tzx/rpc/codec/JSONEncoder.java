package com.tzx.rpc.codec;

import com.alibaba.fastjson.JSON;

/**
 * @author 田泽鑫
 * @date 2020/4/12
 * @description 基于JSON的序列化实现
 */
public class JSONEncoder implements Encoder {
    @Override
    public byte[] encode(Object object) {
        return JSON.toJSONBytes(object);
    }
}

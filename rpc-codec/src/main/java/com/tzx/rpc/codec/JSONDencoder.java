package com.tzx.rpc.codec;

import com.alibaba.fastjson.JSON;

/**
 * @author ������
 * @date 2020/4/12
 * @description ����JSON�ķ����л�ʵ��
 */
public class JSONDencoder implements Dencoder {
    @Override
    public <T> T decode(byte[] bytes, Class<T> clazz) {
        return JSON.parseObject(bytes,clazz);
    }

}

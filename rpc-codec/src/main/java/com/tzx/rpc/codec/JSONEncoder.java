package com.tzx.rpc.codec;

import com.alibaba.fastjson.JSON;

/**
 * @author ������
 * @date 2020/4/12
 * @description ����JSON�����л�ʵ��
 */
public class JSONEncoder implements Encoder {
    @Override
    public byte[] encode(Object object) {
        return JSON.toJSONBytes(object);
    }
}

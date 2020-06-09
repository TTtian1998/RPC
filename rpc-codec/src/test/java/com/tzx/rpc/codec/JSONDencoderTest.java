package com.tzx.rpc.codec;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author ÃÔ‘ÛˆŒ
 * @date 2020/4/12
 * @description
 */
public class JSONDencoderTest {

    @Test
    public void decode() {
        Encoder encoder = new JSONEncoder();
        TestBean bean = new TestBean();
        bean.setName("tzx");
        bean.setAge(21);
        byte[] bytes = encoder.encode(bean);

        Dencoder dencoder = new JSONDencoder();

        TestBean testBean = dencoder.decode(bytes,TestBean.class);
        assertEquals(bean.getName(),testBean.getName());
        assertEquals(bean.getAge(),testBean.getAge());
    }
}
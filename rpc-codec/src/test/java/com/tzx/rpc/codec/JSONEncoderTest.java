package com.tzx.rpc.codec;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author ÌïÔóöÎ
 * @date 2020/4/12
 * @description
 */
public class JSONEncoderTest {

    @Test
    public void encode() {
        Encoder encoder = new JSONEncoder();
        TestBean bean = new TestBean();
        bean.setName("tzx");
        bean.setAge(21);
        byte[] bytes = encoder.encode(bean);
        assertNotNull(bytes);
    }
}
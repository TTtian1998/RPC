package com.tzx.rpc.server;

import com.tzx.rpc.Request;
import com.tzx.rpc.ServiceDescriptor;
import com.tzx.rpc.common.utils.ReflectUtils;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Method;

import static org.junit.Assert.*;

/**
 * @author ������
 * @date 2020/4/13
 * @description
 */
public class ServiceManagerTest {
    ServiceManager sm;
    @Before
    public void init(){
        sm = new ServiceManager();

        TestInterface bean = new TestImpl();
        sm.register(TestInterface.class,bean);
    }

    @Test
    public void register() {
        TestInterface bean = new TestImpl();
        sm.register(TestInterface.class,bean);
    }

    @Test
    public void lookup() {
        Method method = ReflectUtils.getPublicMethods(TestInterface.class)[0];
        ServiceDescriptor sdp = ServiceDescriptor.from(TestInterface.class,method);
        Request request =new Request();
        request.setService(sdp);
        ServiceInstance sis = sm.lookup(request);
        assertNotNull(sis);
    }
}
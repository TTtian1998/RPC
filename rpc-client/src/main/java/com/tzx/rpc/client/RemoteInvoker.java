package com.tzx.rpc.client;

import com.tzx.rpc.Request;
import com.tzx.rpc.Response;
import com.tzx.rpc.ServiceDescriptor;
import com.tzx.rpc.codec.Dencoder;
import com.tzx.rpc.codec.Encoder;
import com.tzx.rpc.transport.TransportClient;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author 田泽鑫
 * @date 2020/4/13
 * @description 调用远程服务的代理类
 */
@Slf4j
public class RemoteInvoker implements InvocationHandler {
    private Class clazz;
    private Encoder encoder;
    private Dencoder dencoder;
    private TransportSelector selector;

    public RemoteInvoker(Class clazz, Encoder encoder, Dencoder dencoder,TransportSelector selector){
        this.clazz = clazz;
        this.encoder = encoder;
        this.dencoder = dencoder;
        this.selector = selector;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Request request = new Request();
        request.setService(ServiceDescriptor.from(clazz,method));
        request.setParameters(args);
        Response resp = invokeRemote(request);
        if (resp.getCode()!=0 || resp == null){
            throw new IllegalStateException("fail to invoke remote: " + resp);
        }
        return resp.getData();
    }

    private Response invokeRemote(Request request) {
        Response resp = null;
        TransportClient client = null;
        try {
            client = selector.select();
            byte[] outBytes = encoder.encode(request);
            InputStream receive = client.write(new ByteArrayInputStream(outBytes));
            //拿到Server返回的数据
            byte[] inBytes = IOUtils.readFully(receive,receive.available());
            //反序列化
            resp = dencoder.decode(inBytes,Response.class);
        } catch (IOException e) {
            log.warn(e.getMessage(),e);
            resp = new Response();
            resp.setCode(1);
            resp.setMessage("RpcClient got error: "+e.getClass() + " : " +e.getMessage());
            e.printStackTrace();
        } finally {
            if (client!=null){
                selector.release(client);
            }
        }
        return resp;
    }
}

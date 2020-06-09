package com.tzx.rpc.server;

import com.tzx.rpc.codec.Dencoder;
import com.tzx.rpc.codec.Encoder;
import com.tzx.rpc.codec.JSONDencoder;
import com.tzx.rpc.codec.JSONEncoder;
import com.tzx.rpc.transport.HttpTransportServer;
import com.tzx.rpc.transport.TransportServer;
import lombok.Data;

/**
 * @author ������
 * @date 2020/4/13
 * @description server���� ʹ���ĸ�����ģ�� ʹ���ĸ����л�ʵ�� ����֮������ĸ��˿�
 */
@Data
public class RpcServerConfig {
    private Class<? extends TransportServer> transportClass = HttpTransportServer.class;
    private Class<? extends Encoder> encoderClass = JSONEncoder.class;
    private Class<? extends Dencoder> dencoderClass = JSONDencoder.class;
    private int port = 3003;
}

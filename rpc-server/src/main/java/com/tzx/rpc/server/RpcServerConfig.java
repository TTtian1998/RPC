package com.tzx.rpc.server;

import com.tzx.rpc.codec.Dencoder;
import com.tzx.rpc.codec.Encoder;
import com.tzx.rpc.codec.JSONDencoder;
import com.tzx.rpc.codec.JSONEncoder;
import com.tzx.rpc.transport.HttpTransportServer;
import com.tzx.rpc.transport.TransportServer;
import lombok.Data;

/**
 * @author 田泽鑫
 * @date 2020/4/13
 * @description server配置 使用哪个网络模块 使用哪个序列化实现 启动之后监听哪个端口
 */
@Data
public class RpcServerConfig {
    private Class<? extends TransportServer> transportClass = HttpTransportServer.class;
    private Class<? extends Encoder> encoderClass = JSONEncoder.class;
    private Class<? extends Dencoder> dencoderClass = JSONDencoder.class;
    private int port = 3003;
}

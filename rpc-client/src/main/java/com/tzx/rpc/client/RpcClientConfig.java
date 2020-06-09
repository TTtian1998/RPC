package com.tzx.rpc.client;

import com.tzx.rpc.Peer;
import com.tzx.rpc.codec.Dencoder;
import com.tzx.rpc.codec.Encoder;
import com.tzx.rpc.codec.JSONDencoder;
import com.tzx.rpc.codec.JSONEncoder;
import com.tzx.rpc.transport.HttpTransportClient;
import com.tzx.rpc.transport.TransportClient;
import lombok.Data;

import java.util.Arrays;
import java.util.List;

/**
 * @author ÃÔ‘ÛˆŒ
 * @date 2020/4/13
 * @description
 */
@Data
public class RpcClientConfig {
    private Class<? extends TransportClient> transportClass = HttpTransportClient.class;
    private Class<? extends Encoder> encoderClass = JSONEncoder.class;
    private Class<? extends Dencoder> dencoderClass = JSONDencoder.class;
    private Class<? extends TransportSelector> selectorClass = RandomTransoprtSelector.class;
    private int connectCount = 1;
    private List<Peer> servers = Arrays.asList(new Peer("127.0.0.1",3003));
}

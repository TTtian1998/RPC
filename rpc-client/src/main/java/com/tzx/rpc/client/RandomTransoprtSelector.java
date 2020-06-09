package com.tzx.rpc.client;

import com.tzx.rpc.Peer;
import com.tzx.rpc.common.utils.ReflectUtils;
import com.tzx.rpc.transport.TransportClient;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author 田泽鑫
 * @date 2020/4/13
 * @description
 */
@Slf4j
public class RandomTransoprtSelector implements TransportSelector {
    //已经连接好的client
    private List<TransportClient> clients;

    public RandomTransoprtSelector() {
        //ArrayList不是线程安全的
        clients = new ArrayList<>();
    }

    @Override
    public synchronized void init(List<Peer> peers, int count, Class<? extends TransportClient> clazz) {
        count = Math.max(count,1);
        for (Peer peer : peers) {
            for (int i = 0; i < count; i++) {
                TransportClient client = ReflectUtils.newInstance(clazz);
                client.connect(peer);
                clients.add(client);
            }
            log.info("connect server: {}",peer);
        }
    }

    @Override
    public synchronized TransportClient select() {
        int i = new Random().nextInt(clients.size());
        //从clients池里面随机取一个返回
        return clients.remove(i);
    }

    @Override
    public synchronized void release(TransportClient client) {
        clients.add(client);
    }

    @Override
    public synchronized void close() {
        for (TransportClient client:
             clients) {
            client.close();
        }
        clients.clear();
    }
}

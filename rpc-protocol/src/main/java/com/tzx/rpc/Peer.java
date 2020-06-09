package com.tzx.rpc;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author 田泽鑫
 * @date 2020/4/7
 * @description 表示网络传输的一个端点
 */
@Data
@AllArgsConstructor
public class Peer {
    private String host;
    private int port;
}

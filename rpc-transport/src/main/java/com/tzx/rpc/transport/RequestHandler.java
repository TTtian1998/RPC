package com.tzx.rpc.transport;

import java.io.InputStream;
import java.io.OutputStream;

/**
 * @author 田泽鑫
 * @date 2020/4/13
 * @description 处理网络请求的handler
 */
public interface RequestHandler {
    void onRequest(InputStream receive, OutputStream toResp);
}

package com.tzx.rpc.transport;

import java.io.InputStream;
import java.io.OutputStream;

/**
 * @author ������
 * @date 2020/4/13
 * @description �������������handler
 */
public interface RequestHandler {
    void onRequest(InputStream receive, OutputStream toResp);
}

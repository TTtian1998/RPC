package com.tzx.rpc;

import lombok.Data;

/**
 * @author 田泽鑫
 * @date 2020/4/7
 * @description RPC响应类,类似于HTTP状态码
 */
@Data
public class Response {
    //状态,0表示成功,非0表示失败
    private int code;
    //具体的错误信息
    private String message;
    //返回的数据
    private Object data;
}

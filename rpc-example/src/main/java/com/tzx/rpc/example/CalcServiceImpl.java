package com.tzx.rpc.example;

/**
 * @author ������
 * @date 2020/4/13
 * @description
 */
public class CalcServiceImpl implements CalcService {
    @Override
    public int add(int a, int b) {
        return a+b;
    }

    @Override
    public int minus(int a, int b) {
        return a-b;
    }
}

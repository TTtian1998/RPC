package com.tzx.rpc;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Objects;

/**
 * @author 田泽鑫
 * @date 2020/4/7
 * @description 服务描述类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ServiceDescriptor {
    //类名
    private String clazz;
    //方法名
    private String method;
    //返回类型
    private String returnType;
    //参数类型 可能有多个参数
    private String[] parametersTypes;

    public static ServiceDescriptor from(Class clazz, Method method){
        ServiceDescriptor sdp = new ServiceDescriptor();
        sdp.setClazz(clazz.getName());
        sdp.setMethod(method.getName());
        sdp.setReturnType(method.getReturnType().getName());

        Class[] parameterClasses = method.getParameterTypes();
        String[] parametersTypes = new String[parameterClasses.length];
        for (int i = 0; i < parameterClasses.length; i++) {
            parametersTypes[i] = parameterClasses[i].getName();
        }
        sdp.setParametersTypes(parametersTypes);
        return sdp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ServiceDescriptor that = (ServiceDescriptor) o;
        return clazz.equals(that.clazz) &&
                method.equals(that.method) &&
                returnType.equals(that.returnType) &&
                Arrays.equals(parametersTypes, that.parametersTypes);
    }

    @Override
    public int hashCode() {

        return toString().hashCode();
    }

    @Override
    public String toString() {
        return "ServiceDescriptor{" +
                "clazz='" + clazz + '\'' +
                ", method='" + method + '\'' +
                ", returnType='" + returnType + '\'' +
                ", parametersTypes=" + Arrays.toString(parametersTypes) +
                '}';
    }
}

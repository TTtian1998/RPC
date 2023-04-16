## RPC-Learning

​	RPC是远程过程调用（Remote Procedure Call）的缩写形式，可以让我们像调用本地服务一样调用远程服务。假设有两台服务器A，B，一个应用部署在A服务器上，想要调用B服务器上应用提供的函数/方法，由于不在一个内存空间，不能直接调用，需要通过网络来表达调用的语义和传达调用的数据。在微服务、分布式盛行的时代，RPC在其中扮演者非常重要的角色。

​	了解基本概念后，决定基于Java开发一个简单的rpc框架，使用maven构建工程，使用HTTP协议进行网络通，传输时的序列化与序列化采用Json格式，IDE使用的IDEA ，用到了lombok插件帮助开发，日志选用的logback。系统结构如下图所示：

![](D:\大三下期\rpc.png)

附上一个简单的demo实现调用计算加减服务的效果图，

CalcService

```
package com.tzx.rpc.example;


public interface CalcService {
    int add(int a, int b);
    int minus(int a,int b);
}

```

CalServiceImpl

```
package com.tzx.rpc.example;

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

```

Server，先启动Server服务，注册CalcService计算服务

```
package com.tzx.rpc.example;

import com.tzx.rpc.server.RpcServer;
import com.tzx.rpc.server.RpcServerConfig;


public class Server {
    public static void main(String[] args) {
        RpcServer server = new RpcServer(new RpcServerConfig());
        server.register(CalcService.class,new CalcServiceImpl());
        server.start();
    }
}

```

Client，启动客户端，通过代理（JDK自带的动态代理）远程调用另一个端口的服务

```
package com.tzx.rpc.example;

import com.tzx.rpc.client.RpcClient;


public class Client {
    public static void main(String[] args) {
        RpcClient client = new RpcClient();
        CalcService service = client.getProxy(CalcService.class);
        int r1 = service.add(1,2);
        int r2 = service.minus(10,6);
        System.out.println(r1);
        System.out.println(r2);
    }
}

```

运行结果：

![image-20200621184916150](D:\大三下期\rpc测试结果.png)
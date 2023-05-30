package com.itheima.service;

import com.itheima.api.OrderService;
import org.apache.dubbo.config.annotation.DubboService;
import org.apache.dubbo.config.annotation.Method;
import org.apache.dubbo.rpc.RpcException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * @description
 * @author: ts
 * @create:2021-05-25 14:01
 */
@DubboService(
        timeout = 5000
        ,methods = {
                @Method(name = "getOrder",timeout = 4000,executes = 5)
        }
        ,group = "mybatis"
        ,executes = 10
)
public class OrderServiceImpl implements OrderService {


    /*@Value("${server.port}")
    private String serverPort;*/

    @Value("${dubbo.protocol.port}")
    private String rpcServerPort;

    //@Value("${dubbo.provider.version}")
    private String serviceVersion;

    @Override
    public String getOrder(Long orderId) {
        String result = "get order detail ,orderId="+orderId +",rpcServerPort="+rpcServerPort +",serviceVersion="+serviceVersion;
        System.out.println(result);
        /*try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        if (orderId == 0L) {
            throw new RpcException("请降级");
        }
        return result;
    }
}

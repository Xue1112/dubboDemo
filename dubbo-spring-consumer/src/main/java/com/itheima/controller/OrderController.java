package com.itheima.controller;

import com.itheima.api.OrderService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.apache.dubbo.config.annotation.Method;
import org.apache.dubbo.config.annotation.Reference;
import org.apache.dubbo.registry.NotifyListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description
 * @author: ts
 * @create:2021-05-25 14:25
 */
@RestController
@RequestMapping("/order")
public class OrderController {

    @DubboReference(
            timeout = 2000
            ,check = false
            ,methods = {
                    @Method(name = "getOrder",timeout = 1000)
           }
           ,retries = 3
            ,cluster = "failsafe"
            ,loadbalance = "roundrobin"
            ,group = "mybatis"
            ,version = "v1.0"
            ,stub = "com.itheima.api.stub.x"
            ,mock = "return null"
    )
    private OrderService orderService;

    @GetMapping("/getOrder")
    public String getOrder(Long orderId) {
        System.out.println(orderService);
        return orderService.getOrder(orderId);
    }


    /*public void onreturn(String result,Long orderId) {
        System.out.println("返回之后的结果="+result+"-"+orderId);
    }*/

}

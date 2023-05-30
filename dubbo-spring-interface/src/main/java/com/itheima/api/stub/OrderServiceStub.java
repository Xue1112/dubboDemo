package com.itheima.api.stub;

import com.itheima.api.OrderService;

public class OrderServiceStub implements OrderService {

    private OrderService orderService;

    public OrderServiceStub(OrderService orderService) {
        this.orderService = orderService;
    }

    @Override
    public String getOrder(Long orderId) {
        // 在客户端执行, 预先验证参数是否合法，等等
        try {
            if(null != orderId) {
                String s = orderService.getOrder(orderId);
                System.out.println("调用结果为:"+s);
                return s;
            }
            return "参数校验错误！";
        } catch (Exception e) {
            //容错处理
            return "出现错误：" + e.getMessage();
        }
    }
}

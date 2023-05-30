package com.itheima.api.mock;

import com.itheima.api.OrderService;

public class OrderServiceMock implements OrderService {
    @Override
    public String getOrder(Long orderId) {
        return "降级数据";
    }
}

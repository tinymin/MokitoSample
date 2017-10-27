package com.net.org.service;

import com.net.org.dao.OrderDao;
import com.net.org.model.OrderInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderDao orderDao;

    @Override
    public OrderInfo getOrderInfo(Integer orderNo) {
        return orderDao.getOrderInfo(orderNo);
    }
}

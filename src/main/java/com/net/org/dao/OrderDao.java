package com.net.org.dao;

import com.net.org.model.OrderInfo;

public interface OrderDao {

    OrderInfo getOrderInfo(Integer orderNo);
}

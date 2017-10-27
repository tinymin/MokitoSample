package com.net.org.dao;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.net.org.model.OrderInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class OrderDaoImpl implements OrderDao {
    @Autowired
    private DynamoDBMapper mapper;

    @Override
    public OrderInfo getOrderInfo(Integer orderNo) {
        return mapper.load(OrderInfo.class, orderNo);
    }
}

package com.net.org.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class OrderInfo {
    private Integer orderNo;
    private String goodsName;
    private Integer price;
    private String orderer;
    private String phone;
    private String address;
}

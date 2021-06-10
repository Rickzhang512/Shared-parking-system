package com.park.service;

import com.park.pojo.Order;

import java.util.List;
import java.util.Map;

public interface OrderService {
    List<Order>findAllOrder();
    List<Order>findAllOrderByPage(int satrt,int end);
    int insertOrder(Map map);
    int deleteOrders(int id);
    Order findOrderById(int id);
    List<Order> findOrderByUid(String uid);
    List<Order> getRentOrderByUid(String uid);


}

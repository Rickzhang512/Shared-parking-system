package com.park.service.impl;

import com.park.mapper.OrderMapper;
import com.park.pojo.Order;
import com.park.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderMapper orderMapper;


    @Override
    public List<Order> findAllOrder() {
        return orderMapper.findAllOrder();
    }

    @Override
    public List<Order> findAllOrderByPage(int satrt, int end) {
        return orderMapper.findAllOrderByPage(satrt, end);
    }

    @Override
    public int insertOrder(Map map) {
        return orderMapper.insertOrder(map);
    }

    @Override
    public int deleteOrders(int id) {
        return orderMapper.deleteOrders(id);
    }

    @Override
    public Order findOrderById(int id) {
        return orderMapper.findOrderById(id);
    }

    @Override
    public List<Order> findOrderByUid(String uid) {
        return orderMapper.findOrderByUid(uid);
    }

    @Override
    public List<Order> getRentOrderByUid(String uid) {
        return orderMapper.getRentOrderByUid(uid);
    }
}

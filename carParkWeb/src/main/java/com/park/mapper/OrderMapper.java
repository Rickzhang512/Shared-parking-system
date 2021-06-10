package com.park.mapper;

import com.park.pojo.Order;
import com.park.pojo.Rent;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface OrderMapper {
    List<Order>findAllOrder();
    List<Order>findAllOrderByPage(int satrt,int end);
    int insertOrder(Map map);
    int deleteOrders(int id);
    Order findOrderById(int id);
    List<Order> findOrderByUid(String uid);
    List<Order> getRentOrderByUid(String uid);
}

package com.park.mapper;


import com.park.pojo.Rent;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface RentMapper {
    List<Rent>findAllRent();
    List<Rent>findAllRentByPage(int satrt,int end);
    int insertRent(Map map);
    int deleteRents(int id);
    Rent findRentById(int id);
    List<Rent> findRentByUid(String uid);
    public List<Rent> queryAll();
}

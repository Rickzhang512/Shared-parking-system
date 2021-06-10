package com.park.service;

import com.park.pojo.Rent;

import java.util.List;
import java.util.Map;

public interface RentService {
    List<Rent>findAllRent();
    List<Rent>findAllRentByPage(int satrt,int end);
    int insertRent(Map map);
    public List<Rent> queryAll();
    public int deleteRents(int id);
    Rent findRentById(int id);
    List<Rent> findRentByUid(String uid);

}

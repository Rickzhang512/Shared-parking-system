package com.park.service.impl;

import com.park.mapper.RentMapper;

import com.park.pojo.Rent;
import com.park.service.RentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class RentServiceImpl implements RentService {
    @Autowired
    RentMapper rentMapper;


    @Override
    public List<Rent> findAllRent() {
        return rentMapper.findAllRent();
    }

    @Override
    public List<Rent> findAllRentByPage(int satrt, int end) {
        return rentMapper.findAllRentByPage(satrt, end);
    }

    @Override
    public int insertRent(Map map) {
        return rentMapper.insertRent(map);
    }

    @Override
    public int deleteRents(int id) {
        return rentMapper.deleteRents(id);
    }
    @Override
    public List<Rent> queryAll() {
        // TODO Auto-generated method stub
        return rentMapper.queryAll();
    }


    @Override
    public Rent findRentById(int id) {
        return rentMapper.findRentById(id);
    }

    @Override
    public List<Rent> findRentByUid(String uid) {
        return rentMapper.findRentByUid(uid);
    }
}

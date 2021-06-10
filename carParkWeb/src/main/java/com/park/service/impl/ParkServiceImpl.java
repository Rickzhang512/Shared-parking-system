package com.park.service.impl;

import com.park.mapper.MessageMapper;
import com.park.mapper.ParkMapper;
import com.park.pojo.Message;
import com.park.pojo.Park;
import com.park.service.ParkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ParkServiceImpl implements ParkService {
    @Autowired
    ParkMapper parkMapper;
    @Override
    public List<Park> findAllPark() {
        return parkMapper.findAllPark();
    }

    @Override
    public List<Park> findAllParkByPage(int satrt, int end) {
        return parkMapper.findAllParkByPage(satrt,end);
    }

    @Override
    public int insertPark(Map map) {
        return parkMapper.insertPark(map);
    }

    @Override
    public int deleteParks(int id) {
        return parkMapper.deleteParks(id);
    }

    @Override
    public int updatePark(Map map) {
        return parkMapper.updatePark(map);
    }

    @Override
    public Park findParkById(int id) {
        return parkMapper.findParkById(id);
    }

    @Override
    public Park findParkByParkName(String parkName) {
        return parkMapper.findParkByParkName(parkName);
    }


}

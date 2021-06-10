package com.park.service.impl;

import com.park.mapper.SpotMapper;

import com.park.pojo.Spot;
import com.park.service.SpotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
@Service
public class SpotServiceImpl implements SpotService {
    @Autowired
    SpotMapper spotMapper;


    @Override
    public int insertSpot(Map map) {
        return spotMapper.insertSpot(map);
    }

    @Override
    public int deleteSpot(int id) {
        return spotMapper.deleteSpot(id);
    }

    @Override
    public int updateSpot(Map map) {
        return spotMapper.updateSpot(map);
    }


}

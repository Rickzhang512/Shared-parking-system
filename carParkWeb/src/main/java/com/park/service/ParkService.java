package com.park.service;

import com.park.pojo.Park;

import java.util.List;
import java.util.Map;

public interface ParkService {
    List<Park> findAllPark();
    List<Park>findAllParkByPage(int satrt,int end);
    int insertPark(Map map);
    int deleteParks(int id);
    int updatePark(Map map);
    Park findParkById(int id);
    Park findParkByParkName(String parkName);
}

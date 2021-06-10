package com.park.mapper;

import com.park.pojo.Park;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface ParkMapper {
    List<Park>findAllPark();
    List<Park>findAllParkByPage(int satrt,int end);
    int insertPark(Map map);
    int deleteParks(int id);
    int updatePark(Map map);
    Park findParkById(int id);
    Park findParkByParkName(String parkName);
}

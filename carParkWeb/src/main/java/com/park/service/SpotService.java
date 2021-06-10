package com.park.service;
import com.park.pojo.Spot;

import java.util.List;
import java.util.Map;
public interface SpotService {

    public int insertSpot(Map map);
    public int deleteSpot(int id);
    public int updateSpot(Map map);

}

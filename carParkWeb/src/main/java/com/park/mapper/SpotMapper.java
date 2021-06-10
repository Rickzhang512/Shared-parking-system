package com.park.mapper;
import com.park.pojo.Spot;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;
@Mapper
public interface SpotMapper {
    int insertSpot(Map map);
    int deleteSpot(int id);
    int updateSpot(Map map);
}

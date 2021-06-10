package com.park.mapper;

import com.park.pojo.Record;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RecordMapper {
   public int addRecord(Record record);
   public int updateRecord(Record record);
   public List<Record> queryAll();
   public int deleteRecord(int id);
   public Record queryRecordById(int id);
   public List<Record> queryRecordByUserName(String userName,String isCharge);
   List<Record> findAllRecordByPage(int satrt, int end);
}

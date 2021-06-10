package com.park.service;

import java.util.List;
import java.util.Map;

import com.park.pojo.Record;

public interface RecordService {
	public int addRecord(Record record);
	public int updateRecord(Record record);
	public List<Record> queryAll();
	public int deleteRecord(int id);
	public Record queryRecordById(int id);
	public List<Record> queryRecordByUserName(String userName,String isCharge);
	List<Record> findAllRecordByPage(int satrt, int end);
}

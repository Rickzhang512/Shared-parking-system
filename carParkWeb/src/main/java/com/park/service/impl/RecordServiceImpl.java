package com.park.service.impl;

import com.park.mapper.RecordMapper;
import com.park.pojo.Record;
import com.park.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecordServiceImpl implements RecordService {
    @Autowired
    RecordMapper recordMapper;
    @Override
    public int addRecord(Record record) {
        // TODO Auto-generated method stub
        return recordMapper.addRecord(record);
    }

    @Override
    public int updateRecord(Record record) {
        // TODO Auto-generated method stub
        return recordMapper.updateRecord(record);
    }

    @Override
    public List<Record> queryAll() {
        // TODO Auto-generated method stub
        return recordMapper.queryAll();
    }


    @Override
    public int deleteRecord(int id) {
        // TODO Auto-generated method stub
        return recordMapper.deleteRecord(id);
    }

    @Override
    public Record queryRecordById(int id) {
        // TODO Auto-generated method stub
        return recordMapper.queryRecordById(id);
    }


    @Override
    public List<Record> queryRecordByUserName(String userName,String isCharge) {
        // TODO Auto-generated method stub
        return recordMapper.queryRecordByUserName(userName,isCharge);
    }

    @Override
    public List<Record> findAllRecordByPage(int satrt, int end) {
        return recordMapper.findAllRecordByPage(satrt, end);
    }
}

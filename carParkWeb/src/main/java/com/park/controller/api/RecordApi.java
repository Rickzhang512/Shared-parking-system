package com.park.controller.api;

import com.alibaba.fastjson.JSON;
import com.park.pojo.Park;
import com.park.pojo.Record;
import com.park.service.ParkService;
import com.park.service.RecordService;

import com.park.util.DateUtils;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@Controller
public class RecordApi {
    @Autowired
    RecordService recordService;
    @Autowired
    ParkService parkService;

    @ResponseBody
    @RequestMapping(value = "/getAllRecordByUid",produces="application/json;charset=UTF-8")
    public String findAllRecord(@Param("userName") String userName, @Param("isCharge") String isCharge){
        List<Record> messages = recordService.queryRecordByUserName(userName,isCharge);
        String result = JSON.toJSONString(messages);
        return result;
    }


    @ResponseBody
    @RequestMapping(value = "/updateRecordInfoById",produces="application/json;charset=UTF-8")
    public String updatePayByUid(@RequestParam("id") Integer id){
        Record record = recordService.queryRecordById(id);
        record.setIsCharge("已结算");
        record.setOutTime(DateUtils.dateToString());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd hh:mm");
        long start=0;
        long end = 0;
        try {
            start = sdf.parse(record.getInTime()).getTime();
            end = sdf.parse(record.getOutTime()).getTime();//毫秒
        } catch (ParseException e) {
            e.printStackTrace();
        }//毫秒
        Park park =  parkService.findParkByParkName(record.getParkName());
        int hour =  (int)((end - start)/3600000 == 0 ? (end - start)/3600000 : (end - start)/3600000+1);
        hour= hour==0?1:hour;//不满一个小时算一个小时
        int xf = (int) (hour*Double.parseDouble(park.getFeeScale()));
        record.setCharge(String.valueOf(xf));
        int count = recordService.updateRecord(record);
        if (count>0) {
            String result = JSON.toJSONString("ok");
            System.out.println(result);
            return result;
        } else {
            String result = JSON.toJSONString("false");
            System.out.println(result);
            return result;
        }

    }
    //插入record
    @ResponseBody
    @RequestMapping(value = "/addRecord",produces="application/json;charset=UTF-8")
    public String addRecord(@Param("record") Record record){
        int messages = recordService.addRecord(record);
        String result = JSON.toJSONString(messages);
        return result;
    }



}

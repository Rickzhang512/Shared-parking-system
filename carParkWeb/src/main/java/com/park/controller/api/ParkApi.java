package com.park.controller.api;

import com.alibaba.fastjson.JSON;
import com.park.pojo.Admin;
import com.park.pojo.Park;
import com.park.pojo.Record;
import com.park.service.ParkService;
import com.park.service.RecordService;
import com.park.service.UserService;
import com.park.util.DateUtils;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
public class ParkApi {
    @Autowired
    ParkService parkService;
    @Autowired
    UserService userService;
    @Autowired
    RecordService recordService;

    /**
     * 查询公告信息
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/getAllPark",method = RequestMethod.GET, produces="application/json;charset=UTF-8")
    public String getAllPark(){
        List<Park> parks = parkService.findAllPark();
        String result = JSON.toJSONString(parks);
        return result;
    }

    @ResponseBody
    @RequestMapping(value = "/getParkById", method = RequestMethod.GET,produces="application/json;charset=UTF-8")
    public String getParkById(@Param("id") Integer id){
        Park park = parkService.findParkById(id);
        String result = JSON.toJSONString(park);
        System.out.println(result);
        return result;
    }



    @ResponseBody
    @RequestMapping(value = "/getParkByParkName", method = RequestMethod.GET,produces="application/json;charset=UTF-8")
    public String getParkByParkName(@Param("parkName") String parkName){
        Park park = parkService.findParkByParkName(parkName);
        String result = JSON.toJSONString(park);
        System.out.println(result);
        return result;
    }

    @ResponseBody
    @RequestMapping(value = "/updateParkInfoById", method = RequestMethod.POST,produces="application/json;charset=UTF-8")
    public String updatePayByUid(@RequestParam("id") Integer id,@RequestParam("uid") String uid, @RequestParam("loca") String loca){
        if (null == loca) {
            loca="";
        }
        //String[] locationArry = loca.split(",");
        //User user = userService.findUserByUid(uid);
        Park p = parkService.findParkById(id);
        Map<String,Object> mapQue = new HashMap<String,Object>();
        if (null == p.getUserInfo()) {
            mapQue.put("userInfo",loca);
        } else {
            mapQue.put("userInfo",p.getUserInfo()+","+loca);
        }
        mapQue.put("id",id);
        int count = parkService.updatePark(mapQue);
       if (count>0) {
           Record record = new Record();
           record.setUserName(uid);
           record.setParkName(p.getParkName());
           record.setLocation(p.getParkLocation());
           record.setIsCharge("未结算");
           record.setInTime(DateUtils.dateToString());
           recordService.addRecord(record);
           String result = JSON.toJSONString("ok");
           System.out.println(result);
           return result;
       } else {
           String result = JSON.toJSONString("false");
           System.out.println(result);
           return result;
       }

    }


}

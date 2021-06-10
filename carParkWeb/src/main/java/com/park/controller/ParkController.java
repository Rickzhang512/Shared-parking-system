package com.park.controller;

import com.alibaba.fastjson.JSON;
import com.park.pojo.Admin;
import com.park.pojo.Message;
import com.park.pojo.Park;
import com.park.service.MessageService;
import com.park.service.ParkService;
import com.park.util.Layui;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
public class ParkController {
    @Autowired
    ParkService parkService;


    @ResponseBody
    @RequestMapping(value = "/findAllParkByPage",produces="application/json;charset=UTF-8")
    public String findAllMessageByPage(@RequestParam("limit") String limit, @RequestParam("page") String page){
        int start = (Integer.parseInt(page) - 1)*Integer.parseInt(limit);
        int pageSize = Integer.parseInt(limit);
        List<Park> parks = parkService.findAllParkByPage(start,Integer.parseInt(page)*pageSize);
        List<Park> parksAll = parkService.findAllPark();
        Layui l = Layui.data(parksAll.size(), parks);
        String result = JSON.toJSONString(l);
        return result;
    }

    @ResponseBody
    @RequestMapping(value = "/insertPark")
    public String insertPark(@RequestBody Map map ,HttpServletRequest request){
    	Admin admin = (Admin) request.getSession().getAttribute("admin");  //将对应数据存入session中
        int n = parkService.insertPark(map);
        if(n>0){
            return "success";
        }
        return "failure";
    }

    @ResponseBody
    @RequestMapping(value = "/deleteParks")
    public String deleteParks(@RequestParam("id") int id){
        int n = parkService.deleteParks(id);
        if(n>0){
            return "success";
        }
        return "failure";
    }

    @ResponseBody
    @RequestMapping(value = "/updatePark")
    public String updatePark(@RequestBody Map map,HttpServletRequest request){
    	Admin admin = (Admin) request.getSession().getAttribute("admin");  //将对应数据存入session中
        System.out.println("map:"+map.toString());
        int n = parkService.updatePark(map);
        if(n>0){
            return "success";
        }
        return "failure";
    }
}

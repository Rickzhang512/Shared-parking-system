package com.park.controller;
import com.alibaba.fastjson.JSON;
import com.park.pojo.Admin;

import com.park.service.SpotService;
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
public class SpotController {
    @Autowired
    SpotService spotService;


    @ResponseBody
    @RequestMapping(value = "/insertSpot")
    public String insertSpot(@RequestBody Map map ,HttpServletRequest request){
        int n = spotService.insertSpot(map);
        if(n>0){
            return "success";
        }
        return "failure";
    }

    @ResponseBody
    @RequestMapping(value = "/deleteSpot")
    public String deleteSpots(@RequestParam("id") int id){
        int n = spotService.deleteSpot(id);
        if(n>0){
            return "success";
        }
        return "failure";
    }

    @ResponseBody
    @RequestMapping(value = "/updateSpot")
    public String updateSpot(@RequestBody Map map,HttpServletRequest request){
        System.out.println("map:"+map.toString());
        int n = spotService.updateSpot(map);
        if(n>0){
            return "success";
        }
        return "failure";
    }
}

package com.park.controller;

import com.alibaba.fastjson.JSON;
import com.park.pojo.Record;
import com.park.service.RecordService;
import com.park.util.Layui;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class RecordController {
    @Autowired
    RecordService recordService;

    @ResponseBody
    @RequestMapping(value = "/findAllRecordByPage",produces="application/json;charset=UTF-8")
    public String findAllRecordByPage(@RequestParam("limit") String limit, @RequestParam("page") String page) {
        int start = (Integer.parseInt(page) - 1)*Integer.parseInt(limit);
        int pageSize = Integer.parseInt(limit);
        List<Record> pays = recordService.findAllRecordByPage(start,pageSize);
        List<Record> payAll = recordService.queryAll();
        Layui l = Layui.data(payAll.size(), pays);
        String result = JSON.toJSONString(l);
        return result;
    }
    @RequestMapping(value = "/queryAllRecord")
    public ModelAndView queryAllRecord(ModelAndView modelAndView) {
        List<Record> records = recordService.queryAll();
        modelAndView.setViewName("record");
        modelAndView.addObject("records", records);
        return modelAndView;
    }

    
    @ResponseBody
    @RequestMapping(value = "/deleteRecord", method = RequestMethod.POST)
    public String deleteRecord(@RequestParam("id") int id){
    	int n = recordService.deleteRecord(id);
        if(n>0){
            return "success";
        }
        return "failure";
    }
    
    
}

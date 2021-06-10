package com.park.controller;

import com.alibaba.fastjson.JSON;
import com.park.pojo.Rent;
import com.park.service.RentService;
import com.park.util.Layui;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
@Controller
public class RentController {
    @Autowired
    RentService rentService;

    @ResponseBody
    @RequestMapping(value = "/findAllRentByPage", method = RequestMethod.POST)
    public String findAllRentByPage(@RequestParam("limit") String limit, @RequestParam("page") String page) {
        int start = (Integer.parseInt(page) - 1)*Integer.parseInt(limit);
        int pageSize = Integer.parseInt(limit);
        List<Rent> rents = rentService.findAllRentByPage(start,pageSize);
        List<Rent> rentAll = rentService.queryAll();
        Layui l = Layui.data(rentAll.size(), rents);
        String result = JSON.toJSONString(l);
        return result;

    }
    @ResponseBody
    @RequestMapping(value = "/queryAllRent")
    public ModelAndView queryAllRecord(ModelAndView modelAndView) {
        List<Rent> rents = rentService.queryAll();
        modelAndView.setViewName("rent");
        modelAndView.addObject("rents", rents);
        return modelAndView;
    }
    @ResponseBody
    @RequestMapping(value = "/deleteRents", method = RequestMethod.POST)
    public String deleteRent(@RequestParam("id") int id){
        int n = rentService.deleteRents(id);
        if(n>0){
            return "success";
        }
        return "failure";
    }


}

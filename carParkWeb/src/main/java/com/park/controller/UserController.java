package com.park.controller;

import com.alibaba.fastjson.JSON;
import com.park.pojo.User;
import com.park.service.UserService;
import com.park.util.Layui;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    UserService userService;


    @ResponseBody
    @RequestMapping(value = "/findAllUserByPage",produces="application/json;charset=UTF-8")
    public String findAllUserByPage(@RequestParam("limit") String limit, @RequestParam("page") String page){
        int start = (Integer.parseInt(page) - 1)*Integer.parseInt(limit);
        int pageSize = Integer.parseInt(limit);
        List<User> message = userService.findAllUserByPage(start,Integer.parseInt(page)*pageSize);
        List<User> messageAll = userService.findAllUser();
        Layui l = Layui.data(messageAll.size(), message);
        String result = JSON.toJSONString(l);
        return result;
    }

    @RequestMapping(value = "/toUser")
    public ModelAndView toLogin(ModelAndView modelAndView){
        modelAndView.setViewName("user");
        return modelAndView;
    }

    @ResponseBody
    @RequestMapping(value = "/deleteUsers")
    public String deleteUsers(@RequestParam("uid") String uid){
        int n = userService.deleteUsers(uid);
        if(n>0){
            return "success";
        }
        return "failure";
    }



}

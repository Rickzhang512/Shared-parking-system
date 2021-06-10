package com.park.controller.api;

import com.alibaba.fastjson.JSON;
import com.park.pojo.User;
import com.park.service.UserService;
import com.park.util.RandNum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;


@Controller
public class UserApi {
    @Autowired
    UserService userService;
    /*
    微信小程序端提供json接口,显示数据
     */
    @ResponseBody
    @RequestMapping(value = "/registerUser",method = RequestMethod.POST)
    public String RegisterUser(@RequestBody Map map){
        System.out.println(map.toString());
        map.put("uid", RandNum.getGUID());
        int n = userService.insertUser(map);
        if(n>0){
            return "success";
        }
        return "failure";
    }

    @ResponseBody
    @RequestMapping(value = "/userLogin",method = RequestMethod.POST)
    public String userLogin(@RequestBody Map map){
        System.out.println(map.toString());
        String uid = userService.findUidByPNumAndPwd(map);
        if(uid!=null){
            return uid;
        }
        return "failure";
    }
    @ResponseBody
    @RequestMapping(value = "/findUserByUid",method = RequestMethod.POST)
    public String findUserByUid(@RequestBody Map<String,String> map){
        System.out.println(map);
        User user = userService.findUserByUid(map.get("uid"));
//        System.out.println(user.getName());
        String result = JSON.toJSONString(user);
        System.out.println(result);
        return result;
    }

}

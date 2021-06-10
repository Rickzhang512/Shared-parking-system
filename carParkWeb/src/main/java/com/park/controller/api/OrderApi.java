package com.park.controller.api;

import com.alibaba.fastjson.JSON;
import com.park.pojo.Order;
import com.park.pojo.Rent;
import com.park.service.OrderService;
import com.park.service.RentService;
import com.park.util.DateUtils;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


@Controller
public class OrderApi {
    @Autowired
    OrderService orderService;
    @Autowired
    RentService rentService;

    /**
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/getAllOrder",method = RequestMethod.GET, produces="application/json;charset=UTF-8")
    public String getAllRent(){
        List<Order> orders = orderService.findAllOrder();
        String result = JSON.toJSONString(orders);
        return result;
    }

    @ResponseBody
    @RequestMapping(value = "/getOrderById", method = RequestMethod.GET,produces="application/json;charset=UTF-8")
    public String getRentById(@Param("id") Integer id){
        Order order = orderService.findOrderById(id);
        String result = JSON.toJSONString(order);
        System.out.println(result);
        return result;
    }


    @ResponseBody
    @RequestMapping(value = "/getOrderByUid", method = RequestMethod.POST,produces="application/json;charset=UTF-8")
    public String getOrderByUid(@Param("uid") String uid){
        List<Order> orders = orderService.findOrderByUid(uid);
        String result = JSON.toJSONString(orders);
        System.out.println(result);
        return result;
    }

    @ResponseBody
    @RequestMapping(value = "/getRentOrderByUid", method = RequestMethod.POST,produces="application/json;charset=UTF-8")
    public String getRentOrderByUid(@Param("uid") String uid){
        List<Order> orders = orderService.getRentOrderByUid(uid);
        String result = JSON.toJSONString(orders);
        System.out.println(result);
        return result;
    }



    @ResponseBody
    @RequestMapping(value = "/insertOrder", method = RequestMethod.POST)
    public String insertOrder(@RequestBody Map map){
        System.out.println("reparjson:"+map.toString());
        Rent r = rentService.findRentById(Integer.parseInt(map.get("rentId").toString()));
        long day = DateUtils.getDayTime(r.getParkEndTime(),r.getParkStartTime());
        System.out.println(map.toString());
        map.put("charge",day*Integer.parseInt(r.getParkRentMoney()));
        map.put("createTime",DateUtils.dateToString());
        int n = orderService.insertOrder(map);
        if(n>0){
            return "success";
        }
        return "failure";
    }


}

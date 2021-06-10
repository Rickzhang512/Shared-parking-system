package com.park.controller.api;

import com.alibaba.fastjson.JSON;
import com.park.pojo.Admin;
import com.park.pojo.Park;
import com.park.pojo.Record;
import com.park.service.ParkService;
import com.park.service.RecordService;
import com.park.service.SpotService;
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

import org.springframework.stereotype.Controller;

@Controller
public class SpotApi {
    @Autowired
    SpotService spotService;
    /**
     * 查询车位信息
     * @return
     */




}

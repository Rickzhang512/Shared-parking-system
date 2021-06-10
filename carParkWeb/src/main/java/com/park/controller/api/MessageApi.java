package com.park.controller.api;

import com.alibaba.fastjson.JSON;
import com.park.pojo.Message;
import com.park.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
public class MessageApi {
    @Autowired
    MessageService messageService;

    /**
     * 查询公告信息
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/getAllMessage",produces="application/json;charset=UTF-8")
    public String findAllMessage(){
        List<Message> messages = messageService.findAllMessage();
        String result = JSON.toJSONString(messages);
        return result;
    }
    
    /**
     * 根据内容查询公告详情
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/word",produces="application/json;charset=UTF-8")
    public String getContentMessageInfo(String content){
    	Message message = messageService.getContentMessageInfo(content);
        String result = JSON.toJSONString(message);
        return result;
    }

}

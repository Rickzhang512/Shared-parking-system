package com.park.service;

import com.park.pojo.Message;

import java.util.List;
import java.util.Map;

public interface MessageService {
    List<Message> findAllMessage();
    List<Message>findAllMessageByPage(int start,int end);
    int insertMessage(Map map);
    int deleteNotices(int id);
    int updateMessage(Map map);
    Message getContentMessageInfo(String content);
}

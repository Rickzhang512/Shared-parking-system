package com.park.service.impl;

import com.park.mapper.MessageMapper;
import com.park.pojo.Message;
import com.park.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class MessageServiceImpl implements MessageService {
    @Autowired
    MessageMapper messageMapper;
    @Override
    public List<Message> findAllMessage() {
        return messageMapper.findAllMessage();
    }

    @Override
    public List<Message> findAllMessageByPage(int satrt, int end) {
        return messageMapper.findAllMessageByPage(satrt,end);
    }

    @Override
    public int insertMessage(Map map) {
        return messageMapper.insertMessage(map);
    }

    @Override
    public int deleteNotices(int id) {
        return messageMapper.deleteNotices(id);
    }

    @Override
    public int updateMessage(Map map) {
        return messageMapper.updateMessage(map);
    }

	@Override
	public Message getContentMessageInfo(String content) {
		// TODO Auto-generated method stub
		return messageMapper.getContentMessageInfo(content);
	}

    
}

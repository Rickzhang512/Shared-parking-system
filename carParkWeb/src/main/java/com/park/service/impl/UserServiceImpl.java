package com.park.service.impl;

import com.park.mapper.UserMapper;
import com.park.pojo.User;
import com.park.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;
    @Override
    public int insertUser(Map map) {
        return userMapper.insertUser(map);
    }

    @Override
    public String findUidByPNumAndPwd(Map map) {
        return userMapper.findUidByPNumAndPwd(map);
    }

	@Override
	public List<User> findAllUser() {
		// TODO Auto-generated method stub
		return userMapper.findAllUser();
	}

    @Override
    public List<User> findAllUserByPage(int satrt, int end) {
        return userMapper.findAllUserByPage(satrt,end);
    }

    @Override
	public User findUserByUid(String uid) {
		// TODO Auto-generated method stub
		return userMapper.findUserByUid(uid);
	}

    @Override
    public int deleteUsers(String uid) {
        return userMapper.deleteUsers(uid);
    }


}

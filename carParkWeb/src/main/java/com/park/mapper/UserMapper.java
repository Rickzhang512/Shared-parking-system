package com.park.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.park.pojo.User;

import java.util.List;
import java.util.Map;

@Mapper
public interface UserMapper {
   int insertUser(Map map);
   String findUidByPNumAndPwd(Map map);
   List<User> findAllUser();
   User findUserByUid(String uid);
   List<User>findAllUserByPage(int satrt, int end);
   int deleteUsers(String uid);
}

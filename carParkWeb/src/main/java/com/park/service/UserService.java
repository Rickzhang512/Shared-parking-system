package com.park.service;

import java.util.List;
import java.util.Map;
import com.park.pojo.User;

public interface UserService {
    int insertUser(Map map);
    String findUidByPNumAndPwd(Map map);
    List<User> findAllUser();
    List<User>findAllUserByPage(int satrt, int end);
    User findUserByUid(String uid);
    int deleteUsers(String uid);
}

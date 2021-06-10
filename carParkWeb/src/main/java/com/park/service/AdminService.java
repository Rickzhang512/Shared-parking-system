package com.park.service;

import com.park.pojo.Admin;

import java.util.List;

public interface AdminService {
    public Admin findOneAdmin(String account, String pwd);
    List<Admin>  findAllAccount();
    int updateAdminPwd(String pwd,String account);
}

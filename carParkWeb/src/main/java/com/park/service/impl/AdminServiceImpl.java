package com.park.service.impl;

import com.park.mapper.AdminMapper;
import com.park.pojo.Admin;
import com.park.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    AdminMapper adminMapper;
    @Override
    public Admin findOneAdmin(String account, String pwd) {
        return adminMapper.findOneAdmin(account,pwd);
    }

    @Override
    public List<Admin>  findAllAccount() {
        return adminMapper.findAllAccount();
    }

    @Override
    public int updateAdminPwd(String pwd, String account) {
        return adminMapper.updateAdminPwd(pwd,account);
    }

}

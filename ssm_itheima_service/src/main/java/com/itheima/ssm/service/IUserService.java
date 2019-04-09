package com.itheima.ssm.service;

import com.itheima.UserInfo;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface IUserService extends UserDetailsService {

    //查询所有用户信息
        List<UserInfo> findAll() throws Exception;





    void save(UserInfo userInfo);

    UserInfo findByID(String id);
}



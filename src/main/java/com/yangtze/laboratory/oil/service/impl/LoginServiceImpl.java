package com.yangtze.laboratory.oil.service.impl;

import com.yangtze.laboratory.oil.dao.LoginDao;
import com.yangtze.laboratory.oil.pojo.User;
import com.yangtze.laboratory.oil.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program: oil
 * @Author 陈欣
 * @description
 * @Date 2022/11/24 16:36
 * @Version 1.0
 **/
@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private LoginDao loginDao;
    @Override
    public User loginValidate(String username, String password) {
        System.out.println("loginserviceImp=>"+username+","+password);
         return loginDao.loginValidate(username,password);
    }

}

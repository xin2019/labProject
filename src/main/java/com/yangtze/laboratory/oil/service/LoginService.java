package com.yangtze.laboratory.oil.service;

import org.apache.ibatis.annotations.Param;

/**
 * @program: oil
 * @Author 陈欣
 * @description
 * @Date 2022/11/24 16:35
 * @Version 1.0
 **/
public interface LoginService {
    /*
  验证登录用户
   */
    public boolean loginValidate(String username, String password);
}

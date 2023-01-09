package com.yangtze.laboratory.oil.service;

import com.yangtze.laboratory.oil.pojo.User;
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
    public User loginValidate(String username, String password);
}

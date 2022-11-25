package com.yangtze.laboratory.oil.dao;

import com.yangtze.laboratory.oil.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @program: oil
 * @Author 陈欣
 * @description
 * @Date 2022/11/24 16:34
 * @Version 1.0
 **/
@Mapper
@Repository
public interface LoginDao {
    /*
   验证登录用户
    */
    public User loginValidate(@Param("username") String username, @Param("password") String password);

}

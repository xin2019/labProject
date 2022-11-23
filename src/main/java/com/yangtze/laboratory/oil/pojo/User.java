package com.yangtze.laboratory.oil.pojo;

import lombok.Data;

import java.io.Serializable;

/**
 * @program: oil
 * @Author 陈欣
 * @description
 * @Date 2022/10/20 19:48
 * @Version 1.0
 **/
@Data
public class User implements Serializable {
    private String username;
    private String password;
    public User(String username,String password){
        this.username=username;
        this.password=password;
    }
}

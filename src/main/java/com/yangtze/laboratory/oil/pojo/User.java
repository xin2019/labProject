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
    private char permission_type;
    private String user_id;
//    public User(String username,String password){
//        this.username=username;
//        this.password=password;
//    }
//    public User(String username,String password,char permission_type,String user_id){
//        this.username=username;
//        this.password=password;
//        this.permission_type=permission_type;
//        this.user_id=user_id;
//    }
}

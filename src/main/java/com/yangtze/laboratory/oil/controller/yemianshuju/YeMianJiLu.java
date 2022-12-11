package com.yangtze.laboratory.oil.controller.yemianshuju;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @program: oil
 * @Author 陈欣
 * @description
 * @Date 2022/11/26 11:40
 * @Version 1.0
 **/
@Controller
public class YeMianJiLu {
    @RequestMapping("/yemianjilu")
    public String yemianjiluPage(){
        return "yemianjilu";
    }
}

package com.yangtze.laboratory.oil.controller.xitongshezhi;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @program: oil
 * @Author 陈欣
 * @description
 * @Date 2022/12/14 11:55
 * @Version 1.0
 **/
@Controller
@RequestMapping("/xitongshezhi")
public class JieGouZuCheng {
    @RequestMapping("/jiegouzucheng")
    public String jiegouzucheng(){
        return "jiegouzucheng";
    }
}

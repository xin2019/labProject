package com.yangtze.laboratory.oil.controller.xitongshezhi;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @program: oil
 * @Author 陈欣
 * @description
 * @Date 2022/12/13 15:07
 * @Version 1.0
 **/
@Controller
@RequestMapping("/xitongshezhi")
public class JingHaoSheZhi {
    @RequestMapping("/jinghaoshezhi")
    public String jinghaoshezhi(){
        return "jinghaoshezhi";
    }
}

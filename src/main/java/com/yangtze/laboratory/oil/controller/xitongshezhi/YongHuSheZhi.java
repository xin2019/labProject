package com.yangtze.laboratory.oil.controller.xitongshezhi;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @program: oil
 * @Author 陈欣
 * @description
 * @Date 2022/12/13 23:26
 * @Version 1.0
 **/
@Controller
@RequestMapping("/xitongshezhi")
public class YongHuSheZhi {
    @RequestMapping("/yonghushezhi")
    public String yonghushezhi(){
        return "yonghushezhi";
    }
}

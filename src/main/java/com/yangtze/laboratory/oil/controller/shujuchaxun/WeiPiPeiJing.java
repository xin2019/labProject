package com.yangtze.laboratory.oil.controller.shujuchaxun;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @program: oil
 * @Author 陈欣
 * @description 液面数据部分
 * @Date 2022/12/12 21:05
 * @Version 1.0
 **/
@Controller
@RequestMapping("/yemianshuju")
public class WeiPiPeiJing {
    //未匹配井
    @RequestMapping("/weipipeijing")
    public String weipipeijing(){
        return "weipipeijing";
    }

    //校验历史
    @RequestMapping("/jiaoyanlishi")
    public String jiaoyanlishi(){
        return "jiaoyanlishi";
    }
}

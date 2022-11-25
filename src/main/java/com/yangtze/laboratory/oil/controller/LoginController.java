package com.yangtze.laboratory.oil.controller;

import com.alibaba.fastjson.JSONObject;
import com.yangtze.laboratory.oil.pojo.User;
import com.yangtze.laboratory.oil.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @program: oil
 * @Author 陈欣
 * @description
 * @Date 2022/10/20 19:23
 * @Version 1.0
 **/
@Controller
public class LoginController {

    @Autowired
    private LoginService loginService;
@ResponseBody
    @RequestMapping(value = {"/login1"})
    public String testLogin(HttpServletRequest request, @RequestParam("username")String username,@RequestParam("password")String password){
        System.out.println("进入login1");
        Boolean res= loginService.loginValidate(username,password);
        if(res==true){
            User user=new User(username,password);
            request.getSession().setAttribute("user",user);
            return "success";
//            return "redirect:/index";
        }else{
            return "failed";
        }
    }

    @RequestMapping(value = {"/login"})
    public String loginIndex(HttpServletRequest request) {
        //如果已登录过，直接跳转到index界面
        System.out.println("进入login2");
        Object user = request.getSession().getAttribute("user");
        if(user!=null){
            System.out.println("user=>"+user);
            return "index";
        }
        System.out.println("user为空");
        return "login";
    }

    @RequestMapping("/index")
    public String indexPage(Model model, HttpServletRequest request){
        System.out.println("jinlail");
        User user = (User) request.getSession().getAttribute("user");
        model.addAttribute("user", user);
        return "index";
    }

    @RequestMapping("/welcome")
    public String edd(Model model, HttpServletRequest request){
        System.out.println("welcome");

        return "welcome";
    }

    @RequestMapping("/logout")
    public String logout(HttpServletRequest request){
        HttpSession session = request.getSession();
        session.removeAttribute("user");
        session.invalidate();
        return "login";
    }

    @ResponseBody
//    @RequestMapping(value = {"/loginValidate"}, method = RequestMethod.POST)
    @RequestMapping(value = {"/loginValidate"})
    public String loginValidate(@RequestParam(name = "username")String username, @RequestParam(name = "password")String password,
                        Model model, HttpServletRequest request) {
        System.out.println("validate=>username=>"+username+";paddw=>"+password);
        JSONObject jsonObject=new JSONObject();
        if(!StringUtils.isEmpty(username)&&!StringUtils.isEmpty(password)&&username.equals("admin")&&password.equals("admin")){
            User user = new User(username,password);
            model.addAttribute("user", user);

            request.getSession().setAttribute("user", user);
            System.out.println("准备return true");
           jsonObject.put("result","success");
        }
        else {
            System.out.println("准备return false");
            jsonObject.put("result","false");
        }
        return JSONObject.toJSONString(jsonObject);
    }
}

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
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
        User res= loginService.loginValidate(username,password);
        if(res!=null){
//            User user=new User(username,password);
            request.getSession().setAttribute("user",res);
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
            return "/index";
        }
        System.out.println("user为空");
        this.getIpAddress(request);
        return "login";
    }

    @RequestMapping("/index")
    public String indexPage( HttpServletRequest request){
        System.out.println("jinlail");
        User user = (User) request.getSession().getAttribute("user");
       request.getSession().setAttribute("user",user);
       request.setAttribute("user",user);

        this.getIpAddress(request);
        return "index";
    }

    @RequestMapping("/welcome")
    public String edd(Model model, HttpServletRequest request){
        System.out.println("welcome");
        return "yemianjilu";
//        return "welcome";
    }

    @RequestMapping("/logout")
    public String logout(HttpServletRequest request){
        HttpSession session = request.getSession();
        session.removeAttribute("user");
        session.invalidate();
        return "login";
    }

//    @ResponseBody
//    @RequestMapping(value = {"/loginValidate"}, method = RequestMethod.POST)
//    @RequestMapping(value = {"/loginValidate"})
//    public String loginValidate(@RequestParam(name = "username")String username, @RequestParam(name = "password")String password,
//                        Model model, HttpServletRequest request) {
//        System.out.println("validate=>username=>"+username+";paddw=>"+password);
//        JSONObject jsonObject=new JSONObject();
//        if(!StringUtils.isEmpty(username)&&!StringUtils.isEmpty(password)&&username.equals("admin")&&password.equals("admin")){
//            User user = new User(username,password);
//            model.addAttribute("user", user);
//
//            request.getSession().setAttribute("user", user);
//            System.out.println("准备return true");
//           jsonObject.put("result","success");
//        }
//        else {
//            System.out.println("准备return false");
//            jsonObject.put("result","false");
//        }
//        return JSONObject.toJSONString(jsonObject);
//    }


    /*
    获取登录时间和ip
     */
    public  void getIpAddress(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        System.out.println("x-forwarded-for ip: " + ip);
        if (ip != null && ip.length() != 0 && !"unknown".equalsIgnoreCase(ip)) {
            // 多次反向代理后会有多个ip值，第一个ip才是真实ip
            if( ip.indexOf(",")!=-1 ){
                ip = ip.split(",")[0];
            }
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
            System.out.println("Proxy-Client-IP ip: " + ip);
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
            System.out.println("WL-Proxy-Client-IP ip: " + ip);
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_CLIENT_IP");
            System.out.println("HTTP_CLIENT_IP ip: " + ip);
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
            System.out.println("HTTP_X_FORWARDED_FOR ip: " + ip);
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("X-Real-IP");
            System.out.println("X-Real-IP ip: " + ip);
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
            System.out.println("getRemoteAddr ip: " + ip);
        }
        //获取本地ip
        if("0:0:0:0:0:0:0:1".equals(ip)){
            try {
                ip =  InetAddress.getLocalHost().getHostAddress();
            } catch (UnknownHostException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            System.out.println("getLocal ip: " + ip);
        }
        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateNowStr = sdf.format(d);
        System.out.println("登录IP: " + ip+"登录时间:"+dateNowStr);
    }
}

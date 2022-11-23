package com.yangtze.laboratory.oil.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @program: oil
 * @Author 陈欣
 * @description 集成python算法
 * @Date 2022/10/27 15:37
 * @Version 1.0
 **/
@Controller
public class LineChartController {
    @RequestMapping("/zhexiantu")
    public String zhexiantuPage(){
        return "zhexiantu";
    }

    @RequestMapping("/getDepth")
    @ResponseBody
    public String getDepth(@RequestParam(name = "depth")String depth) {
        int a = 111;
        int b = 23;
        System.out.println("前端收到的深度depth=》"+depth);
        String res="";
//        int depth=1600;
        JSONObject jsonObject=new JSONObject();
        try {
            String[] args1 = new String[] { "python", "D:\\postStudy\\python\\某风\\lab\\depthAlgorithm.py", String.valueOf(depth)};
            Process proc = Runtime.getRuntime().exec(args1);// 执行py文件
            BufferedReader in = new BufferedReader(new InputStreamReader(proc.getInputStream()));
            String line = null;
            while ((line = in.readLine()) != null) {
                res+=line;
                System.out.println(line);
            }
            jsonObject.put("res",res);
            in.close();
            proc.waitFor();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return JSONObject.toJSONString(jsonObject);
    }

    public static void main1(String[] args) {
        Process proc;
        int a=10,b=33;
        try {
            String[] argsS=new String[]{"python","D:\\STUDY\\python\\testLinux.py",String.valueOf(a),String.valueOf(b)};
            proc=Runtime.getRuntime().exec(argsS);
//            proc=Runtime.getRuntime().exec("python D:\\STUDY\\python\\testLinux.py");
            BufferedReader in=new BufferedReader(new InputStreamReader(proc.getInputStream()));
            String line=null;
            while((line=in.readLine())!=null){
                System.out.println(line);
            }
            in.close();
            proc.waitFor();
        }catch (IOException e){
            e.printStackTrace();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}

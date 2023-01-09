package com.yangtze.laboratory.oil.controller.yemianshuju;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.annotation.JsonAlias;
import com.yangtze.laboratory.oil.pojo.*;
import com.yangtze.laboratory.oil.service.YeMianShuJuService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;

import javax.xml.soap.Node;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @program: oil
 * @Author 陈欣
 * @description
 * @Date 2022/11/26 11:40
 * @Version 1.0
 **/
@Controller
@RequestMapping("/yemianshuju")
public class YeMianJiLuController {
@Autowired
    private YeMianShuJuService service;
    @RequestMapping("/yemianjilu")
    public String yemianjiluPage(){

        return "yemianjilu";
    }
    @ResponseBody
    @RequestMapping("/getData")
    public  String getdata(@Param("oil_area_id")String oil_area_id){
     List<OilArea> res= service.getAreaDatas(oil_area_id);
        System.out.println("getData=>"+res.toString());
    return res.toString();
    }

    @ResponseBody
    @RequestMapping("/getPermissions")
    public String getPermissions(@Param("user_id")String user_id){
        List<UserPermission> permissions = service.getPermissions(user_id);
        System.out.println("-----------------");
        System.out.println("-----------------");
        System.out.println("-----------------");
        Map<String, Nodes> map=new HashMap<String ,Nodes>();
        for(UserPermission permission:permissions){
            System.out.println("循环开始====="+permission.getOil_field_name()+permission.getOil_field_plant_name()+permission.getOil_area_name());
            System.out.println();
            String tempField=permission.getOil_field_name();
            System.out.println("tempField=>"+tempField);
            if(!map.isEmpty()&&map.containsKey(tempField)){
                //存在该油田
                System.out.println("存在该油田"+tempField);
                Nodes node=map.get(tempField);
                System.out.println("获取到的node=》"+node);
                //判断是否存在该油厂
                String tempPlant=permission.getOil_field_plant_name();

                List<NodesOilPlants> plants = node.getPlants();
                System.out.println("准备判断是否存在油厂=》"+tempPlant);
                if(node.getPlants()!=null){
                    int i;
                    for(i=0;i<plants.size();i++){

                        if(plants.get(i).oil_field_plant_name.equals(tempPlant)){
                            //存在该油厂
                            System.out.println("存在该油厂");
                            NodesOilPlants plant = plants.get(i);
                            //增加该区
                            if(plant.areas==null)
                                plant.areas=new LinkedList<NodesOilAreas>();
                            NodesOilAreas nodesOilAreas=new NodesOilAreas();
                            nodesOilAreas.setArea(permission.getOil_area_name());
                            nodesOilAreas.setData(permission.getHref());
                            plant.areas.add(nodesOilAreas);
                            break;
                        }
                    }
                    if(i==plants.size()){
                        //没有该油厂，新增油厂和管理区
                        NodesOilPlants oilPlant1=new NodesOilPlants();
                        oilPlant1.setOil_field_plant_name(permission.getOil_field_plant_name());
                        oilPlant1.areas=new LinkedList<NodesOilAreas>();
                        NodesOilAreas nodesOilAreas=new NodesOilAreas();
                        nodesOilAreas.setArea(permission.getOil_area_name());
                        nodesOilAreas.setData(permission.getHref());
                        oilPlant1.areas.add(nodesOilAreas);
                        plants.add(oilPlant1);
                    }
                }
                else{
                    System.out.println("不存在该油厂，增加采油厂和管理区=>"+tempPlant);
                    //不存在该油厂，增加采油厂和管理区
                    plants=new LinkedList<NodesOilPlants>();
                    NodesOilPlants oilPlant1=new NodesOilPlants();
                    oilPlant1.setOil_field_plant_name(permission.getOil_field_plant_name());
                    oilPlant1.areas=new LinkedList<NodesOilAreas>();
                    NodesOilAreas nodesOilAreas=new NodesOilAreas();
                    nodesOilAreas.setArea(permission.getOil_area_name());
                    nodesOilAreas.setData(permission.getHref());
                    oilPlant1.areas.add(nodesOilAreas);

                }
            }else{
                //不存在该油田,增加油田，油厂和油区
                System.out.println("不存在油田"+permission.getOil_field_name());
                Nodes node1=new Nodes();
                node1.setOil_field_name(permission.getOil_field_name());
                node1.plants=new LinkedList<NodesOilPlants>();
                NodesOilPlants plants2=new NodesOilPlants();
                plants2.setOil_field_plant_name(permission.getOil_field_plant_name());
                plants2.areas=new LinkedList<NodesOilAreas>();
                NodesOilAreas nodesOilAreas=new NodesOilAreas();
                nodesOilAreas.setArea(permission.getOil_area_name());
                nodesOilAreas.setData(permission.getHref());
                plants2.areas.add(nodesOilAreas);
                node1.plants.add(plants2);
                map.put(permission.getOil_field_name(),node1);
            }
            System.out.println("循环结束===");
            System.out.println();
        }
        System.out.println(map.toString());
        //制作前端nodes节点值,缺了data
        return map.toString();
    }
}

package com.yangtze.laboratory.oil.pojo;

import lombok.Data;

import java.util.List;

/**
 * @program: oil
 * @Author 陈欣
 * @description
 * @Date 2023/1/2 21:57
 * @Version 1.0
 **/
@Data
public class Nodes {
    private String oil_field_name;
    public List<NodesOilPlants> plants;


}

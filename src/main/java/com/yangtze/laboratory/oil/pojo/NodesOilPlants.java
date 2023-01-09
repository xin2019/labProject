package com.yangtze.laboratory.oil.pojo;

import lombok.Data;

import java.util.List;

/**
 * @program: oil
 * @Author 陈欣
 * @description
 * @Date 2023/1/2 22:52
 * @Version 1.0
 **/
@Data
public class NodesOilPlants{
    public String oil_field_plant_name;
    public List<NodesOilAreas> areas;

}
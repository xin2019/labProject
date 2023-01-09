package com.yangtze.laboratory.oil.pojo;

import lombok.Data;

import java.util.List;

/**
 * @program: oil
 * @Author 陈欣
 * @description
 * @Date 2023/1/2 15:49
 * @Version 1.0
 **/
@Data
public class OilField {
    private String oil_field_id;
    private String oil_field_name;
    private String oil_field_plant_id;
    private String oil_field_name_eng;
//    private List<OilFieldPlant> children;
}

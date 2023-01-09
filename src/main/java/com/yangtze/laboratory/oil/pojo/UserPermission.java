package com.yangtze.laboratory.oil.pojo;

/**
 * @program: oil
 * @Author 陈欣
 * @description
 * @Date 2023/1/1 16:37
 * @Version 1.0
 **/

import lombok.Data;

@Data
public class UserPermission {
    private String user_id;
    private String href;
    private String oil_field_name;
    private String oil_field_plant_name;
    private String oil_area_name;
}

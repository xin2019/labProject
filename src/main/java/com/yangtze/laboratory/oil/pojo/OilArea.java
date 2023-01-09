package com.yangtze.laboratory.oil.pojo;

import lombok.Data;

/**
 * @program: oil
 * @Author 陈欣
 * @description
 * @Date 2022/12/31 12:01
 * @Version 1.0
 **/
@Data
public class OilArea {
    private String oil_area_id;
    private String oil_equipment_id;
    private String oil_name;
    private int level_records;
    private int instrument_status;
}

package com.yangtze.laboratory.oil.service;

import com.yangtze.laboratory.oil.pojo.OilArea;
import com.yangtze.laboratory.oil.pojo.UserPermission;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @program: oil
 * @Author 陈欣
 * @description
 * @Date 2022/12/31 12:17
 * @Version 1.0
 **/
public interface YeMianShuJuService {
    public List<OilArea> getAreaDatas(@Param("oil_area_id")String oil_area_id);
    /*
    从权限表获取user_id对应可以跳转的路径
     */
    public List<UserPermission> getPermissions(@Param("user_id")String user_id);
}

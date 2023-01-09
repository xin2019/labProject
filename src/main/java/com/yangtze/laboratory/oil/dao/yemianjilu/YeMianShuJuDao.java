package com.yangtze.laboratory.oil.dao.yemianjilu;

import com.yangtze.laboratory.oil.pojo.OilArea;
import com.yangtze.laboratory.oil.pojo.UserPermission;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @program: oil
 * @Author 陈欣
 * @description
 * @Date 2022/12/31 11:58
 * @Version 1.0
 **/
@Mapper
@Repository
public interface YeMianShuJuDao {
    /*
    获取管理区记录
     */
    public List<OilArea> getAreaDatas(@Param("oil_area_id")String oil_area_id);
    /*
    从权限表获取user_id对应可以跳转的路径
     */
    public List<UserPermission> getPermissions(@Param("user_id")String user_id);
}

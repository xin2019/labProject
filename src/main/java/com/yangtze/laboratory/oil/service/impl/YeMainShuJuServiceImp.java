package com.yangtze.laboratory.oil.service.impl;

import com.yangtze.laboratory.oil.dao.yemianjilu.YeMianShuJuDao;
import com.yangtze.laboratory.oil.pojo.OilArea;
import com.yangtze.laboratory.oil.pojo.UserPermission;
import com.yangtze.laboratory.oil.service.YeMianShuJuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: oil
 * @Author 陈欣
 * @description
 * @Date 2022/12/31 12:18
 * @Version 1.0
 **/
@Service
public class YeMainShuJuServiceImp implements YeMianShuJuService {
    @Autowired
    private YeMianShuJuDao dao;

    @Override
    public List<OilArea> getAreaDatas(String oil_area_id) {
        return dao.getAreaDatas(oil_area_id);
    }

    @Override
    public List<UserPermission> getPermissions(String user_id) {
        return dao.getPermissions(user_id);
    }
}

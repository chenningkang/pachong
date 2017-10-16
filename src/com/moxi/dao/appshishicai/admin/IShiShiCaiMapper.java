package com.moxi.dao.appshishicai.admin;

import com.moxi.model.ShiShiCai;

public interface IShiShiCaiMapper {
    int deleteByPrimaryKey(Integer typeId);

    int savepachong(ShiShiCai record);

    int insertSelective(ShiShiCai record);

    ShiShiCai selectByPrimaryKey(Integer id);
    
    int selectTypeId(Integer typeId);
    
    ShiShiCai selectType(Integer typeId);
}
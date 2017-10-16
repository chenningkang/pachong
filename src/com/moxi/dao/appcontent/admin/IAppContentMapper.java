package com.moxi.dao.appcontent.admin;

import com.moxi.model.AppContent;

public interface IAppContentMapper {
    int deleteByPrimaryKey(Integer typeId);

    int savepachong(AppContent record);

    int insertSelective(AppContent record);

    AppContent selectByPrimaryKey(Integer id);
    
    int selectTypeId(Integer typeId);
    
    AppContent selectType(Integer typeId);
}
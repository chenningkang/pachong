package com.moxi.dao.user;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.moxi.model.WcbUser;


public interface WcbUserMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(WcbUser record);

    int insertSelective(WcbUser record);

    WcbUser selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(WcbUser record);

    int updateByPrimaryKey(WcbUser record);
    
    WcbUser checkUserPhone(@Param("phone") String phone);
    
    WcbUser getLogin(@Param("phone") String phone, @Param("password")String password);
    
    int updateUserPassword(WcbUser record);  //修改密码
    
    List<WcbUser> allUser();
}
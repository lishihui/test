package com.module.dao.pub;

import com.module.domain.pub.ItemFormUser;
 
public interface ItemFormUserMapper {
    int deleteByPrimaryKey(String id);

    int insert(ItemFormUser record);

    int insertSelective(ItemFormUser record);

    ItemFormUser selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(ItemFormUser record);

    int updateByPrimaryKey(ItemFormUser record);
}
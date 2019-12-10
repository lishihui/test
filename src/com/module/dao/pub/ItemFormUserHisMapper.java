package com.module.dao.pub;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.module.domain.pub.ItemFormUserHis;
 
 
public interface ItemFormUserHisMapper {
    int insert(ItemFormUserHis record);

    int insertSelective(ItemFormUserHis record);

   List<ItemFormUserHis> selectByPrimaryKey(String params);
}
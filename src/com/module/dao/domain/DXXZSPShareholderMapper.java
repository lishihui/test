package com.module.dao.domain;

import com.module.domain.domain.DXXZSPShareholderWithBLOBs;

public interface DXXZSPShareholderMapper {
    int insert(DXXZSPShareholderWithBLOBs record);

    int insertSelective(DXXZSPShareholderWithBLOBs record);
   
    DXXZSPShareholderWithBLOBs selectByPrimaryKey(String id);
}
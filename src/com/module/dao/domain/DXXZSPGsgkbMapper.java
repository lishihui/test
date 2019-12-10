package com.module.dao.domain;

import com.module.domain.domain.DXXZSPGsgkbWithBLOBs;

public interface DXXZSPGsgkbMapper {
    int insert(DXXZSPGsgkbWithBLOBs record);

    int insertSelective(DXXZSPGsgkbWithBLOBs record);
    
    DXXZSPGsgkbWithBLOBs selectByPrimaryKey(String id);
}
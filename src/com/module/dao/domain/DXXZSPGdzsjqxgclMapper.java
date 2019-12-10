package com.module.dao.domain;

import com.module.domain.domain.DXXZSPGdzsjqxgclWithBLOBs;

public interface DXXZSPGdzsjqxgclMapper {
    int insert(DXXZSPGdzsjqxgclWithBLOBs record);

    int insertSelective(DXXZSPGdzsjqxgclWithBLOBs record);

    DXXZSPGdzsjqxgclWithBLOBs selectByPrimaryKey(String id);
}                             
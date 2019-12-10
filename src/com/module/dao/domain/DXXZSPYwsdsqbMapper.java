package com.module.dao.domain;

import com.module.domain.domain.DXXZSPYwsdsqbWithBLOBs;
import com.module.domain.domain.DxxzspYfjykdjrwyeWithBLOBs;

public interface DXXZSPYwsdsqbMapper {
    int insert(DXXZSPYwsdsqbWithBLOBs record);

    int insertSelective(DXXZSPYwsdsqbWithBLOBs record);
    
    DXXZSPYwsdsqbWithBLOBs selectByPrimaryKey(String id);
}
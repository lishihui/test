package com.module.dao.domain;

import com.module.domain.domain.DxxzspYwfzhssjhZybgWithBLOBs;

public interface DxxzspYwfzhssjhZybgMapper {
    int insert(DxxzspYwfzhssjhZybgWithBLOBs record);

    int insertSelective(DxxzspYwfzhssjhZybgWithBLOBs record);
    
    DxxzspYwfzhssjhZybgWithBLOBs selectByPrimaryKey(String id);
}
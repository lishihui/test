package com.module.dao.registrationManagement.change.change;

import com.module.domain.registrationManagement.change.change.DxxzspZzjyTermBusinessWithBLOBs;

public interface DxxzspZzjyTermBusinessMapper {
    int insert(DxxzspZzjyTermBusinessWithBLOBs record);

    int insertSelective(DxxzspZzjyTermBusinessWithBLOBs record);
    
    DxxzspZzjyTermBusinessWithBLOBs selectByPrimaryKey(String id);
}
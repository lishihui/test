package com.module.dao.registrationManagement.change.change;

import com.module.domain.registrationManagement.change.change.DxxzspSafePlanWithBLOBs;

public interface DxxzspSafePlanMapper {
    int insert(DxxzspSafePlanWithBLOBs record);

    int insertSelective(DxxzspSafePlanWithBLOBs record);
    
    DxxzspSafePlanWithBLOBs selectByPrimaryKey(String id);
}
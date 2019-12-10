package com.module.dao.registrationManagement.apply.apply;

import com.module.domain.registrationManagement.apply.apply.DxxzspInfoSafetyWithBLOBs;

public interface DxxzspInfoSafetyMapper {
    int insert(DxxzspInfoSafetyWithBLOBs record);

    int insertSelective(DxxzspInfoSafetyWithBLOBs record);
    
    DxxzspInfoSafetyWithBLOBs selectByPrimaryKey(String id);
}
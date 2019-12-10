package com.module.dao.registrationManagement.change.change;

import com.module.domain.registrationManagement.change.change.DxxzspTechplanChangedWithBLOBs;

public interface DxxzspTechplanChangedMapper {
    int insert(DxxzspTechplanChangedWithBLOBs record);

    int insertSelective(DxxzspTechplanChangedWithBLOBs record);
    
    DxxzspTechplanChangedWithBLOBs selectByPrimaryKey(String id);
}
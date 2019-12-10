package com.module.dao.registrationManagement.change.change;

import com.module.domain.registrationManagement.change.change.DxxzspInfoproChangedWithBLOBs;

public interface DxxzspInfoproChangedMapper {
    int insert(DxxzspInfoproChangedWithBLOBs record);

    int insertSelective(DxxzspInfoproChangedWithBLOBs record);
    
    DxxzspInfoproChangedWithBLOBs selectByPrimaryKey(String id);

}
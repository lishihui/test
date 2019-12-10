package com.module.dao.registrationManagement.change.change;

import com.module.domain.registrationManagement.change.change.BeforeChangedHolderWithBLOBs;

public interface BeforeChangedHolderMapper {
    int insert(BeforeChangedHolderWithBLOBs record);

    int insertSelective(BeforeChangedHolderWithBLOBs record);
    
    BeforeChangedHolderWithBLOBs selectByPrimaryKey(String id);
}
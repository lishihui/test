package com.module.dao.registrationManagement.change.change;

import com.module.domain.registrationManagement.change.change.DxxzspBoardResolutionWithBLOBs;

public interface DxxzspBoardResolutionMapper {
    int insert(DxxzspBoardResolutionWithBLOBs record);

    int insertSelective(DxxzspBoardResolutionWithBLOBs record);
    
    DxxzspBoardResolutionWithBLOBs selectByPrimaryKey(String id);
}
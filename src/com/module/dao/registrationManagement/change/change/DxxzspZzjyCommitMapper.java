package com.module.dao.registrationManagement.change.change;

import com.module.domain.registrationManagement.change.change.DxxzspZzjyCommitWithBLOBs;

public interface DxxzspZzjyCommitMapper {
    int insert(DxxzspZzjyCommitWithBLOBs record);

    int insertSelective(DxxzspZzjyCommitWithBLOBs record);
    
    DxxzspZzjyCommitWithBLOBs selectByPrimaryKey(String id);

}
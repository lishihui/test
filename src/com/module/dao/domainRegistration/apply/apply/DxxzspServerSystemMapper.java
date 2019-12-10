package com.module.dao.domainRegistration.apply.apply;

import com.module.domain.domainRegistration.apply.apply.DxxzspServerSystemWithBLOBs;

public interface DxxzspServerSystemMapper {
    int insert(DxxzspServerSystemWithBLOBs record);

    int insertSelective(DxxzspServerSystemWithBLOBs record);
    
    DxxzspServerSystemWithBLOBs selectByPrimaryKey(String id);
}
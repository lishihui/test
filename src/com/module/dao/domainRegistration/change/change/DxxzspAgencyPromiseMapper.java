package com.module.dao.domainRegistration.change.change;

import com.module.domain.domainRegistration.change.change.DxxzspAgencyPromiseWithBLOBs;

public interface DxxzspAgencyPromiseMapper {
    int insert(DxxzspAgencyPromiseWithBLOBs record);

    int insertSelective(DxxzspAgencyPromiseWithBLOBs record);
    
    DxxzspAgencyPromiseWithBLOBs selectByPrimaryKey(String id);
}
package com.module.dao.domainRegistration.apply.apply;

import com.module.domain.domainRegistration.apply.apply.DxxzspRegAgencyWithBLOBs;

public interface DxxzspRegAgencyMapper {
    int insert(DxxzspRegAgencyWithBLOBs record);

    int insertSelective(DxxzspRegAgencyWithBLOBs record);
    
    DxxzspRegAgencyWithBLOBs selectByPrimaryKey(String id);

}
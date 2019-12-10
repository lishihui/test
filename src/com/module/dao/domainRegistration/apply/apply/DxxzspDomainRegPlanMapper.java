package com.module.dao.domainRegistration.apply.apply;

import com.module.domain.domainRegistration.apply.apply.DxxzspDomainRegPlanWithBLOBs;

public interface DxxzspDomainRegPlanMapper {
    int insert(DxxzspDomainRegPlanWithBLOBs record);

    int insertSelective(DxxzspDomainRegPlanWithBLOBs record);
    
    DxxzspDomainRegPlanWithBLOBs selectByPrimaryKey(String id);

}
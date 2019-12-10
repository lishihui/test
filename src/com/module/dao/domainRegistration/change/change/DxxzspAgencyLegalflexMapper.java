package com.module.dao.domainRegistration.change.change;

import com.module.domain.domainRegistration.change.change.DxxzspAgencyLegalflexWithBLOBs;

public interface DxxzspAgencyLegalflexMapper {
    int insert(DxxzspAgencyLegalflexWithBLOBs record);

    int insertSelective(DxxzspAgencyLegalflexWithBLOBs record);
    
    DxxzspAgencyLegalflexWithBLOBs selectByPrimaryKey(String id);
}
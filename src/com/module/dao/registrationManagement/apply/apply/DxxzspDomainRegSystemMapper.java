package com.module.dao.registrationManagement.apply.apply;

import com.module.domain.registrationManagement.apply.apply.DxxzspDomainRegSystemWithBLOBs;

public interface DxxzspDomainRegSystemMapper {
    int insert(DxxzspDomainRegSystemWithBLOBs record);

    int insertSelective(DxxzspDomainRegSystemWithBLOBs record);
    
    DxxzspDomainRegSystemWithBLOBs selectByPrimaryKey(String id);
}
package com.module.dao.registrationManagement.apply.apply;

import com.module.domain.registrationManagement.apply.apply.DxxzspDomainRegisterWithBLOBs;

public interface DxxzspDomainRegisterMapper {
    int insert(DxxzspDomainRegisterWithBLOBs record);

    int insertSelective(DxxzspDomainRegisterWithBLOBs record);
    DxxzspDomainRegisterWithBLOBs selectByPrimaryKey(String id);
}
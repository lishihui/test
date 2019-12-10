package com.module.dao.domain;

import com.module.domain.domain.DxxzspDomainRegister;
import com.module.domain.domain.DxxzspDomainRegisterWithBLOBs;

public interface DxxzspDomainRegisterOldMapper {
    int deleteByPrimaryKey(String id);

    int insert(DxxzspDomainRegisterWithBLOBs record);

    int insertSelective(DxxzspDomainRegisterWithBLOBs record);

    DxxzspDomainRegisterWithBLOBs selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(DxxzspDomainRegisterWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(DxxzspDomainRegisterWithBLOBs record);

    int updateByPrimaryKey(DxxzspDomainRegister record);
}
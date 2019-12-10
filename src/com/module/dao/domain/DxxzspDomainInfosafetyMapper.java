package com.module.dao.domain;

import com.module.domain.domain.DxxzspDomainInfosafety;
import com.module.domain.domain.DxxzspDomainInfosafetyWithBLOBs;

public interface DxxzspDomainInfosafetyMapper {
    int deleteByPrimaryKey(String id);

    int insert(DxxzspDomainInfosafetyWithBLOBs record);

    int insertSelective(DxxzspDomainInfosafetyWithBLOBs record);

    DxxzspDomainInfosafetyWithBLOBs selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(DxxzspDomainInfosafetyWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(DxxzspDomainInfosafetyWithBLOBs record);

    int updateByPrimaryKey(DxxzspDomainInfosafety record);
}
package com.module.dao.domain;

import com.module.domain.domain.DxxzspDomainNetworksafety;
import com.module.domain.domain.DxxzspDomainNetworksafetyWithBLOBs;

public interface DxxzspDomainNetworksafetyMapper {
    int deleteByPrimaryKey(String id);

    int insert(DxxzspDomainNetworksafetyWithBLOBs record);

    int insertSelective(DxxzspDomainNetworksafetyWithBLOBs record);

    DxxzspDomainNetworksafetyWithBLOBs selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(DxxzspDomainNetworksafetyWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(DxxzspDomainNetworksafetyWithBLOBs record);

    int updateByPrimaryKey(DxxzspDomainNetworksafety record);
}
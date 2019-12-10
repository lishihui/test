package com.module.dao.domain;

import com.module.domain.domain.DxxzspDomainTechplan;
import com.module.domain.domain.DxxzspDomainTechplanWithBLOBs;

public interface DxxzspDomainTechplanMapper {
    int deleteByPrimaryKey(String id);

    int insert(DxxzspDomainTechplanWithBLOBs record);

    int insertSelective(DxxzspDomainTechplanWithBLOBs record);

    DxxzspDomainTechplanWithBLOBs selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(DxxzspDomainTechplanWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(DxxzspDomainTechplanWithBLOBs record);

    int updateByPrimaryKey(DxxzspDomainTechplan record);
}
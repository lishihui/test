package com.module.dao.domain;

import com.module.domain.domain.DxxzspDomainBase;
import com.module.domain.domain.DxxzspDomainBaseWithBLOBs;

public interface DxxzspDomainBaseMapper {
    int deleteByPrimaryKey(String id);

    int insert(DxxzspDomainBaseWithBLOBs record);

    int insertSelective(DxxzspDomainBaseWithBLOBs record);

    DxxzspDomainBaseWithBLOBs selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(DxxzspDomainBaseWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(DxxzspDomainBaseWithBLOBs record);

    int updateByPrimaryKey(DxxzspDomainBase record);
}
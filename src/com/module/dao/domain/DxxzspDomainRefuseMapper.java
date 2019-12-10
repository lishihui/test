package com.module.dao.domain;

import com.module.domain.domain.DxxzspDomainRefuse;

public interface DxxzspDomainRefuseMapper {
    int deleteByPrimaryKey(String id);

    int insert(DxxzspDomainRefuse record);

    int insertSelective(DxxzspDomainRefuse record);

    DxxzspDomainRefuse selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(DxxzspDomainRefuse record);

    int updateByPrimaryKeyWithBLOBs(DxxzspDomainRefuse record);

    int updateByPrimaryKey(DxxzspDomainRefuse record);
}
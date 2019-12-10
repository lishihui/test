package com.module.dao.domain;

import com.module.domain.domain.DxxzspDomainPlace;

public interface DxxzspDomainPlaceMapper {
    int deleteByPrimaryKey(String id);

    int insert(DxxzspDomainPlace record);

    int insertSelective(DxxzspDomainPlace record);

    DxxzspDomainPlace selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(DxxzspDomainPlace record);

    int updateByPrimaryKey(DxxzspDomainPlace record);
}
package com.module.dao.domain;

import com.module.domain.domain.DxxzspDomainFieldreview;

public interface DxxzspDomainFieldreviewMapper {
    int deleteByPrimaryKey(String id);

    int insert(DxxzspDomainFieldreview record);

    int insertSelective(DxxzspDomainFieldreview record);

    DxxzspDomainFieldreview selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(DxxzspDomainFieldreview record);

    int updateByPrimaryKey(DxxzspDomainFieldreview record);
}
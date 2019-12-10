package com.module.dao.domain;

import com.module.domain.domain.DxxzspDomainPlaceAddr;

public interface DxxzspDomainPlaceAddrMapper {
    int deleteByPrimaryKey(String id);

    int insert(DxxzspDomainPlaceAddr record);

    int insertSelective(DxxzspDomainPlaceAddr record);

    DxxzspDomainPlaceAddr selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(DxxzspDomainPlaceAddr record);

    int updateByPrimaryKey(DxxzspDomainPlaceAddr record);
}
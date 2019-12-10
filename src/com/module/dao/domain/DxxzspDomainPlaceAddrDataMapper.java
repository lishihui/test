package com.module.dao.domain;

import com.module.domain.domain.DxxzspDomainPlaceAddrData;

public interface DxxzspDomainPlaceAddrDataMapper {
    int deleteByPrimaryKey(String id);

    int insert(DxxzspDomainPlaceAddrData record);

    int insertSelective(DxxzspDomainPlaceAddrData record);

    DxxzspDomainPlaceAddrData selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(DxxzspDomainPlaceAddrData record);

    int updateByPrimaryKey(DxxzspDomainPlaceAddrData record);
}
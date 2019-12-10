package com.module.dao.domain;

import com.module.domain.domain.DxxzspDomainPlaceAddrParsing;

public interface DxxzspDomainPlaceAddrParsingMapper {
    int deleteByPrimaryKey(String id);

    int insert(DxxzspDomainPlaceAddrParsing record);

    int insertSelective(DxxzspDomainPlaceAddrParsing record);

    DxxzspDomainPlaceAddrParsing selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(DxxzspDomainPlaceAddrParsing record);

    int updateByPrimaryKey(DxxzspDomainPlaceAddrParsing record);
}
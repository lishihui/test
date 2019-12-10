package com.module.dao.domain;

import com.module.domain.domain.DxxzspDomainPlaceAddrDnsback;

public interface DxxzspDomainPlaceAddrDnsbackMapper {
    int deleteByPrimaryKey(String id);

    int insert(DxxzspDomainPlaceAddrDnsback record);

    int insertSelective(DxxzspDomainPlaceAddrDnsback record);

    DxxzspDomainPlaceAddrDnsback selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(DxxzspDomainPlaceAddrDnsback record);

    int updateByPrimaryKey(DxxzspDomainPlaceAddrDnsback record);
}
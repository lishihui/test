package com.module.dao.domain;

import com.module.domain.domain.DxxzspDomainPlaceAddrDns;

public interface DxxzspDomainPlaceAddrDnsMapper {
    int deleteByPrimaryKey(String id);

    int insert(DxxzspDomainPlaceAddrDns record);

    int insertSelective(DxxzspDomainPlaceAddrDns record);

    DxxzspDomainPlaceAddrDns selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(DxxzspDomainPlaceAddrDns record);

    int updateByPrimaryKey(DxxzspDomainPlaceAddrDns record);
}
package com.module.dao.domain;

import com.module.domain.domain.DxxzspDomainPlaceAddrDataback;

public interface DxxzspDomainPlaceAddrDatabackMapper {
    int deleteByPrimaryKey(String id);

    int insert(DxxzspDomainPlaceAddrDataback record);

    int insertSelective(DxxzspDomainPlaceAddrDataback record);

    DxxzspDomainPlaceAddrDataback selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(DxxzspDomainPlaceAddrDataback record);

    int updateByPrimaryKey(DxxzspDomainPlaceAddrDataback record);
}
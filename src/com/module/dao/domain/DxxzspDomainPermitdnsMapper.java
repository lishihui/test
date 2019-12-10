package com.module.dao.domain;

import com.module.domain.domain.DxxzspDomainPermitdns;

public interface DxxzspDomainPermitdnsMapper {
    int deleteByPrimaryKey(String id);

    int insert(DxxzspDomainPermitdns record);

    int insertSelective(DxxzspDomainPermitdns record);

    DxxzspDomainPermitdns selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(DxxzspDomainPermitdns record);

    int updateByPrimaryKey(DxxzspDomainPermitdns record);
}
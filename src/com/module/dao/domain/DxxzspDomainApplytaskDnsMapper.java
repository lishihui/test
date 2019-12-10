package com.module.dao.domain;

import com.module.domain.domain.DxxzspDomainApplytaskDns;

public interface DxxzspDomainApplytaskDnsMapper {
    int deleteByPrimaryKey(String id);

    int insert(DxxzspDomainApplytaskDns record);

    int insertSelective(DxxzspDomainApplytaskDns record);

    DxxzspDomainApplytaskDns selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(DxxzspDomainApplytaskDns record);

    int updateByPrimaryKey(DxxzspDomainApplytaskDns record);
}
package com.module.dao.domain;

import com.module.domain.domain.DxxzspDomainApplytaskOrg;

public interface DxxzspDomainApplytaskOrgMapper {
    int deleteByPrimaryKey(String id);

    int insert(DxxzspDomainApplytaskOrg record);

    int insertSelective(DxxzspDomainApplytaskOrg record);

    DxxzspDomainApplytaskOrg selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(DxxzspDomainApplytaskOrg record);

    int updateByPrimaryKey(DxxzspDomainApplytaskOrg record);
}
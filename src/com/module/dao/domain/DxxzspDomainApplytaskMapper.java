package com.module.dao.domain;

import com.module.domain.domain.DxxzspDomainApplytask;

public interface DxxzspDomainApplytaskMapper {
    int deleteByPrimaryKey(String id);

    int insert(DxxzspDomainApplytask record);

    int insertSelective(DxxzspDomainApplytask record);

    DxxzspDomainApplytask selectByPrimaryKey(String id);

    DxxzspDomainApplytask selectByFlowrunid(String flowrunid);

    int updateByPrimaryKeySelective(DxxzspDomainApplytask record);

    int updateByPrimaryKey(DxxzspDomainApplytask record);
}
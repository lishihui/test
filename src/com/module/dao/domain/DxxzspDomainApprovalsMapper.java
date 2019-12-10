package com.module.dao.domain;

import com.module.domain.domain.DxxzspDomainApprovals;

public interface DxxzspDomainApprovalsMapper {
    int deleteByPrimaryKey(String id);

    int insert(DxxzspDomainApprovals record);

    int insertSelective(DxxzspDomainApprovals record);

    DxxzspDomainApprovals selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(DxxzspDomainApprovals record);

    int updateByPrimaryKey(DxxzspDomainApprovals record);
}
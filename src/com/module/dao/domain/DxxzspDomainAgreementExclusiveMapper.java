package com.module.dao.domain;

import com.module.domain.domain.DxxzspDomainAgreementExclusive;

public interface DxxzspDomainAgreementExclusiveMapper {
    int deleteByPrimaryKey(String id);

    int insert(DxxzspDomainAgreementExclusive record);

    int insertSelective(DxxzspDomainAgreementExclusive record);

    DxxzspDomainAgreementExclusive selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(DxxzspDomainAgreementExclusive record);

    int updateByPrimaryKey(DxxzspDomainAgreementExclusive record);
}
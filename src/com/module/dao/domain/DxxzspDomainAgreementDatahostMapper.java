package com.module.dao.domain;

import com.module.domain.domain.DxxzspDomainAgreementDatahost;

public interface DxxzspDomainAgreementDatahostMapper {
    int deleteByPrimaryKey(String id);

    int insert(DxxzspDomainAgreementDatahost record);

    int insertSelective(DxxzspDomainAgreementDatahost record);

    DxxzspDomainAgreementDatahost selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(DxxzspDomainAgreementDatahost record);

    int updateByPrimaryKey(DxxzspDomainAgreementDatahost record);
}
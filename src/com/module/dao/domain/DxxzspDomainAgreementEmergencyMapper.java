package com.module.dao.domain;

import com.module.domain.domain.DxxzspDomainAgreementEmergency;

public interface DxxzspDomainAgreementEmergencyMapper {
    int deleteByPrimaryKey(String id);

    int insert(DxxzspDomainAgreementEmergency record);

    int insertSelective(DxxzspDomainAgreementEmergency record);

    DxxzspDomainAgreementEmergency selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(DxxzspDomainAgreementEmergency record);

    int updateByPrimaryKey(DxxzspDomainAgreementEmergency record);
}
package com.module.dao.domain;

import com.module.domain.domain.DxxzspDomainAgreementConstruction;

public interface DxxzspDomainAgreementConstructionMapper {
    int deleteByPrimaryKey(String id);

    int insert(DxxzspDomainAgreementConstruction record);

    int insertSelective(DxxzspDomainAgreementConstruction record);

    DxxzspDomainAgreementConstruction selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(DxxzspDomainAgreementConstruction record);

    int updateByPrimaryKey(DxxzspDomainAgreementConstruction record);
}
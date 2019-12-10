package com.module.dao.domain;

import com.module.domain.domain.DxxzspDomainAgreementBuild;

public interface DxxzspDomainAgreementBuildMapper {
    int deleteByPrimaryKey(String id);

    int insert(DxxzspDomainAgreementBuild record);

    int insertSelective(DxxzspDomainAgreementBuild record);

    DxxzspDomainAgreementBuild selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(DxxzspDomainAgreementBuild record);

    int updateByPrimaryKey(DxxzspDomainAgreementBuild record);
}
package com.module.dao.domain;

import com.module.domain.domain.DxxzspDomainAgreementRealname;

public interface DxxzspDomainAgreementRealnameMapper {
    int deleteByPrimaryKey(String id);

    int insert(DxxzspDomainAgreementRealname record);

    int insertSelective(DxxzspDomainAgreementRealname record);

    DxxzspDomainAgreementRealname selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(DxxzspDomainAgreementRealname record);

    int updateByPrimaryKey(DxxzspDomainAgreementRealname record);
}
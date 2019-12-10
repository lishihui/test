package com.module.dao.domain;

import com.module.domain.domain.DxxzspDomainAgreementOffice;

public interface DxxzspDomainAgreementOfficeMapper {
    int deleteByPrimaryKey(String id);

    int insert(DxxzspDomainAgreementOffice record);

    int insertSelective(DxxzspDomainAgreementOffice record);

    DxxzspDomainAgreementOffice selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(DxxzspDomainAgreementOffice record);

    int updateByPrimaryKey(DxxzspDomainAgreementOffice record);
}
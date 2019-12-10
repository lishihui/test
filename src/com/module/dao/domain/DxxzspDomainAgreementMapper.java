package com.module.dao.domain;

import com.module.domain.domain.DxxzspDomainAgreement;
import com.module.domain.domain.DxxzspDomainAgreementWithBLOBs;

public interface DxxzspDomainAgreementMapper {
    int deleteByPrimaryKey(String id);

    int insert(DxxzspDomainAgreementWithBLOBs record);

    int insertSelective(DxxzspDomainAgreementWithBLOBs record);

    DxxzspDomainAgreementWithBLOBs selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(DxxzspDomainAgreementWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(DxxzspDomainAgreementWithBLOBs record);

    int updateByPrimaryKey(DxxzspDomainAgreement record);
}
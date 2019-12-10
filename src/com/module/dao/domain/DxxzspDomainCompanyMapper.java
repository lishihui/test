package com.module.dao.domain;

import com.module.domain.domain.DxxzspDomainCompany;
import com.module.domain.domain.DxxzspDomainCompanyWithBLOBs;

public interface DxxzspDomainCompanyMapper {
    int deleteByPrimaryKey(String id);

    int insert(DxxzspDomainCompanyWithBLOBs record);

    int insertSelective(DxxzspDomainCompanyWithBLOBs record);

    DxxzspDomainCompanyWithBLOBs selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(DxxzspDomainCompanyWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(DxxzspDomainCompanyWithBLOBs record);

    int updateByPrimaryKey(DxxzspDomainCompany record);
}
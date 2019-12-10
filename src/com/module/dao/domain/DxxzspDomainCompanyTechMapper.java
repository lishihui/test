package com.module.dao.domain;

import com.module.domain.domain.DxxzspDomainCompanyTech;

public interface DxxzspDomainCompanyTechMapper {
    int deleteByPrimaryKey(String id);

    int insert(DxxzspDomainCompanyTech record);

    int insertSelective(DxxzspDomainCompanyTech record);

    DxxzspDomainCompanyTech selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(DxxzspDomainCompanyTech record);

    int updateByPrimaryKeyWithBLOBs(DxxzspDomainCompanyTech record);

    int updateByPrimaryKey(DxxzspDomainCompanyTech record);
}
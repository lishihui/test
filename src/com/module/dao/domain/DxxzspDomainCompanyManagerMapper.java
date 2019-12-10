package com.module.dao.domain;

import com.module.domain.domain.DxxzspDomainCompanyManager;

public interface DxxzspDomainCompanyManagerMapper {
    int deleteByPrimaryKey(String id);

    int insert(DxxzspDomainCompanyManager record);

    int insertSelective(DxxzspDomainCompanyManager record);

    DxxzspDomainCompanyManager selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(DxxzspDomainCompanyManager record);

    int updateByPrimaryKeyWithBLOBs(DxxzspDomainCompanyManager record);

    int updateByPrimaryKey(DxxzspDomainCompanyManager record);
}
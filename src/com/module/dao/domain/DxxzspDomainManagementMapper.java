package com.module.dao.domain;

import com.module.domain.domain.DxxzspDomainManagement;
import com.module.domain.domain.DxxzspDomainManagementWithBLOBs;

public interface DxxzspDomainManagementMapper {
    int deleteByPrimaryKey(String id);

    int insert(DxxzspDomainManagementWithBLOBs record);

    int insertSelective(DxxzspDomainManagementWithBLOBs record);

    DxxzspDomainManagementWithBLOBs selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(DxxzspDomainManagementWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(DxxzspDomainManagementWithBLOBs record);

    int updateByPrimaryKey(DxxzspDomainManagement record);
}
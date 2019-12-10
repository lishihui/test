package com.module.dao.registrationManagement.apply.apply;

import com.module.domain.registrationManagement.apply.apply.DxxzspCompanyProfileWithBLOBs;

public interface DxxzspCompanyProfileMapper {
    int insert(DxxzspCompanyProfileWithBLOBs record);

    int insertSelective(DxxzspCompanyProfileWithBLOBs record);
    DxxzspCompanyProfileWithBLOBs selectByPrimaryKey(String id);
}
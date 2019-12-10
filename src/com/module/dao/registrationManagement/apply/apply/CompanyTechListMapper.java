package com.module.dao.registrationManagement.apply.apply;

import com.module.domain.registrationManagement.apply.apply.CompanyTechListWithBLOBs;

public interface CompanyTechListMapper {
    int insert(CompanyTechListWithBLOBs record);

    int insertSelective(CompanyTechListWithBLOBs record);
    CompanyTechListWithBLOBs selectByPrimaryKey(String id);
}
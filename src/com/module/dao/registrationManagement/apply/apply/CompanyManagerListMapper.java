package com.module.dao.registrationManagement.apply.apply;

import com.module.domain.registrationManagement.apply.apply.CompanyManagerListWithBLOBs;

public interface CompanyManagerListMapper {
    int insert(CompanyManagerListWithBLOBs record);

    int insertSelective(CompanyManagerListWithBLOBs record);
    CompanyManagerListWithBLOBs selectByPrimaryKey(String id);
}
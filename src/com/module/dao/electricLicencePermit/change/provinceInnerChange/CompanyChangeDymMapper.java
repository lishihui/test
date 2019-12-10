package com.module.dao.electricLicencePermit.change.provinceInnerChange;

import com.module.domain.electricLicencePermit.change.provinceInnerChange.CompanyChangeDymWithBLOBs;

public interface CompanyChangeDymMapper {
    int insert(CompanyChangeDymWithBLOBs record);

    int insertSelective(CompanyChangeDymWithBLOBs record);
    
    CompanyChangeDymWithBLOBs selectByPrimaryKey(String id);
}
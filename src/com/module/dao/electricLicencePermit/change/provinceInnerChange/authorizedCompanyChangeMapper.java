package com.module.dao.electricLicencePermit.change.provinceInnerChange;

import com.module.domain.electricLicencePermit.change.provinceInnerChange.authorizedCompanyChangeWithBLOBs;

public interface authorizedCompanyChangeMapper {
    int insert(authorizedCompanyChangeWithBLOBs record);

    int insertSelective(authorizedCompanyChangeWithBLOBs record);
    
    authorizedCompanyChangeWithBLOBs selectByPrimaryKey(String id);
}
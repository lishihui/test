package com.module.dao.domainRegistration.change.change;

import com.module.domain.domainRegistration.change.change.DxxzspAgencyLicenseWithBLOBs;

public interface DxxzspAgencyLicenseMapper {
    int insert(DxxzspAgencyLicenseWithBLOBs record);

    int insertSelective(DxxzspAgencyLicenseWithBLOBs record);
    
    DxxzspAgencyLicenseWithBLOBs selectByPrimaryKey(String id);
}
package com.module.dao.domainRegistration.change.comm;

import com.module.domain.domainRegistration.change.comm.DxxzspLicenseChangedWithBLOBs;

public interface DxxzspLicenseChangedMapper {
    int insert(DxxzspLicenseChangedWithBLOBs record);

    int insertSelective(DxxzspLicenseChangedWithBLOBs record);
    
    DxxzspLicenseChangedWithBLOBs selectByPrimaryKey(String id);
}
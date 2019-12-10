package com.module.dao.electricLicencePermit.change.commChange;

import com.module.domain.electricLicencePermit.change.commChange.DxxzspLicenseOfLegalPersonWithBLOBs;

public interface DxxzspLicenseOfLegalPersonMapper {
    int insert(DxxzspLicenseOfLegalPersonWithBLOBs record);

    int insertSelective(DxxzspLicenseOfLegalPersonWithBLOBs record);
    DxxzspLicenseOfLegalPersonWithBLOBs selectByPrimaryKey(String id);
}
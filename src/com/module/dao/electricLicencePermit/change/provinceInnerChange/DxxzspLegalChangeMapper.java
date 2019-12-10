package com.module.dao.electricLicencePermit.change.provinceInnerChange;

import com.module.domain.electricLicencePermit.change.provinceInnerChange.DxxzspLegalChangeWithBLOBs;


public interface DxxzspLegalChangeMapper {
    int insert(DxxzspLegalChangeWithBLOBs record);

    int insertSelective(DxxzspLegalChangeWithBLOBs record);
    DxxzspLegalChangeWithBLOBs selectByPrimaryKey(String id);
}
package com.module.dao.electricLicencePermit.change.provinceInnerChange;

import com.module.domain.electricLicencePermit.change.provinceInnerChange.DxxzspAppChildformWithBLOBs;

public interface DxxzspAppChildformMapper {
    int insert(DxxzspAppChildformWithBLOBs record);

    int insertSelective(DxxzspAppChildformWithBLOBs record);
    
    DxxzspAppChildformWithBLOBs selectByPrimaryKey(String id);
}
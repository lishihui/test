package com.module.dao.electricLicencePermit.change.provinceInnerChange;

import com.module.domain.electricLicencePermit.change.provinceInnerChange.DxxzspBusinessChangeWithBLOBs;

public interface DxxzspBusinessChangeMapper {
    int insert(DxxzspBusinessChangeWithBLOBs record);

    int insertSelective(DxxzspBusinessChangeWithBLOBs record);
    DxxzspBusinessChangeWithBLOBs selectByPrimaryKey(String id);
}
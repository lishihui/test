package com.module.dao.electricLicencePermit.change.provinceInnerChange;

import com.module.domain.electricLicencePermit.change.provinceInnerChange.DxxzspReplenishmentOfLostWithBLOBs;

public interface DxxzspReplenishmentOfLostMapper {
    int insert(DxxzspReplenishmentOfLostWithBLOBs record);

    int insertSelective(DxxzspReplenishmentOfLostWithBLOBs record);
    DxxzspReplenishmentOfLostWithBLOBs selectByPrimaryKey(String id);
}
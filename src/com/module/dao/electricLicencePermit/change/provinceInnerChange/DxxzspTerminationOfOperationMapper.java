package com.module.dao.electricLicencePermit.change.provinceInnerChange;

import com.module.domain.electricLicencePermit.change.provinceInnerChange.DxxzspTerminationOfOperationWithBLOBs;

public interface DxxzspTerminationOfOperationMapper {
    int insert(DxxzspTerminationOfOperationWithBLOBs record);

    int insertSelective(DxxzspTerminationOfOperationWithBLOBs record);
    DxxzspTerminationOfOperationWithBLOBs selectByPrimaryKey(String id);
}
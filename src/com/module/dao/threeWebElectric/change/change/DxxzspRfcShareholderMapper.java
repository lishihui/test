package com.module.dao.threeWebElectric.change.change;

import com.module.domain.threeWebElectric.change.change.DxxzspRfcShareholderWithBLOBs;

public interface DxxzspRfcShareholderMapper {
    int insert(DxxzspRfcShareholderWithBLOBs record);

    int insertSelective(DxxzspRfcShareholderWithBLOBs record);
    
    DxxzspRfcShareholderWithBLOBs selectByPrimaryKey(String id);
}
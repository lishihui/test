package com.module.dao.threeWebElectric.change.change;

import com.module.domain.threeWebElectric.change.change.DxxzspRfcMergerWithBLOBs;

public interface DxxzspRfcMergerMapper {
    int insert(DxxzspRfcMergerWithBLOBs record);

    int insertSelective(DxxzspRfcMergerWithBLOBs record);
    
    DxxzspRfcMergerWithBLOBs selectByPrimaryKey(String id);
}
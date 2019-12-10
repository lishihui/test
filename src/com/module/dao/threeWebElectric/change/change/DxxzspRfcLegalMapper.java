package com.module.dao.threeWebElectric.change.change;

import com.module.domain.threeWebElectric.change.change.DxxzspRfcLegalWithBLOBs;

public interface DxxzspRfcLegalMapper {
    int insert(DxxzspRfcLegalWithBLOBs record);

    int insertSelective(DxxzspRfcLegalWithBLOBs record);
    
    DxxzspRfcLegalWithBLOBs selectByPrimaryKey(String id);
}
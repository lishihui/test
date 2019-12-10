package com.module.dao.threeWebElectric.change.change;

import com.module.domain.threeWebElectric.change.change.DxxzspRfcComnameWithBLOBs;

public interface DxxzspRfcComnameMapper {
    int insert(DxxzspRfcComnameWithBLOBs record);

    int insertSelective(DxxzspRfcComnameWithBLOBs record);
    
    DxxzspRfcComnameWithBLOBs selectByPrimaryKey(String id);
}
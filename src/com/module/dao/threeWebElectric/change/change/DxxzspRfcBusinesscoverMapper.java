package com.module.dao.threeWebElectric.change.change;

import com.module.domain.threeWebElectric.change.change.DxxzspRfcBusinesscoverWithBLOBs;

public interface DxxzspRfcBusinesscoverMapper {
    int insert(DxxzspRfcBusinesscoverWithBLOBs record);

    int insertSelective(DxxzspRfcBusinesscoverWithBLOBs record);
    
    DxxzspRfcBusinesscoverWithBLOBs selectByPrimaryKey(String id);
}
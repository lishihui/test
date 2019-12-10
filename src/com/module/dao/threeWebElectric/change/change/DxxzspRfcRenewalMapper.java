package com.module.dao.threeWebElectric.change.change;

import com.module.domain.threeWebElectric.change.change.DxxzspRfcRenewalWithBLOBs;

public interface DxxzspRfcRenewalMapper {
    int insert(DxxzspRfcRenewalWithBLOBs record);

    int insertSelective(DxxzspRfcRenewalWithBLOBs record);
    
    DxxzspRfcRenewalWithBLOBs selectByPrimaryKey(String id);
}
package com.module.dao.electricLicencePermit.change.provinceInnerChange;

import com.module.domain.electricLicencePermit.change.provinceInnerChange.DxxzspWebChildformWithBLOBs;

public interface DxxzspWebChildformMapper {
    int insert(DxxzspWebChildformWithBLOBs record);

    int insertSelective(DxxzspWebChildformWithBLOBs record);
    
    DxxzspWebChildformWithBLOBs selectByPrimaryKey(String id);
}
package com.module.dao.electricLicencePermit.apply.provinceInner;

import com.module.domain.electricLicencePermit.apply.provinceInner.DxxzspNetManagedWithBLOBs;

public interface DxxzspNetManagedMapper {
    int insert(DxxzspNetManagedWithBLOBs record);

    int insertSelective(DxxzspNetManagedWithBLOBs record);
    
    DxxzspNetManagedWithBLOBs selectByPrimaryKey(String id);
}
package com.module.dao.electricLicencePermit.change.provinceInnerChange;

import com.module.domain.electricLicencePermit.change.provinceInnerChange.DynamicTableWithBLOBs;

public interface DynamicTableMapper {
	int insert(DynamicTableWithBLOBs record);

    int insertSelective(DynamicTableWithBLOBs record);
    
    DynamicTableWithBLOBs selectByPrimaryKey(String id);
}
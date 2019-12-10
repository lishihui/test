package com.module.dao.electricLicencePermit.change.provinceInnerChange;

import com.module.domain.electricLicencePermit.change.provinceInnerChange.DxxzspServiceProjectChange;
import com.module.domain.electricLicencePermit.change.provinceInnerChange.DxxzspServiceProjectChangeWithBLOBs;

public interface DxxzspServiceProjectChangeMapper {
	
	int deleteByPrimaryKey(String id);
	 
    int insert(DxxzspServiceProjectChangeWithBLOBs record);

    int insertSelective(DxxzspServiceProjectChangeWithBLOBs record);
    
    DxxzspServiceProjectChangeWithBLOBs selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(DxxzspServiceProjectChangeWithBLOBs record);

    int updateByPrimaryKey(DxxzspServiceProjectChangeWithBLOBs record);
    
    int updateByPrimaryKey(DxxzspServiceProjectChange record);
}








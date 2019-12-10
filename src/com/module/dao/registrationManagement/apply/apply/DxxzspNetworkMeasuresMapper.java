package com.module.dao.registrationManagement.apply.apply;

import com.module.domain.registrationManagement.apply.apply.DxxzspNetworkMeasures;
import com.module.domain.registrationManagement.apply.apply.DxxzspNetworkMeasuresWithBLOBs;

public interface DxxzspNetworkMeasuresMapper {
	
	int deleteByPrimaryKey(String id);
	 
    int insert(DxxzspNetworkMeasuresWithBLOBs record);

    int insertSelective(DxxzspNetworkMeasuresWithBLOBs record);
    
    DxxzspNetworkMeasuresWithBLOBs selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(DxxzspNetworkMeasuresWithBLOBs record);

    int updateByPrimaryKey(DxxzspNetworkMeasuresWithBLOBs record);
    
    int updateByPrimaryKey(DxxzspNetworkMeasures record);
}









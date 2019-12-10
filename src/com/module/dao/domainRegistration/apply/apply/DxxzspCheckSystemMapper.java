package com.module.dao.domainRegistration.apply.apply;

import com.module.domain.domainRegistration.apply.apply.DxxzspCheckSystem;
import com.module.domain.domainRegistration.apply.apply.DxxzspCheckSystemWithBLOBs;


public interface DxxzspCheckSystemMapper {
	
	int deleteByPrimaryKey(String id);
	 
    int insert(DxxzspCheckSystemWithBLOBs record);

    int insertSelective(DxxzspCheckSystemWithBLOBs record);
    
    DxxzspCheckSystemWithBLOBs selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(DxxzspCheckSystemWithBLOBs record);

    int updateByPrimaryKey(DxxzspCheckSystemWithBLOBs record);
    
    int updateByPrimaryKey(DxxzspCheckSystem record);
}








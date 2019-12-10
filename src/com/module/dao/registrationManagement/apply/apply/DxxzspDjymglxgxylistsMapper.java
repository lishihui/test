package com.module.dao.registrationManagement.apply.apply;

import com.module.domain.registrationManagement.apply.apply.DxxzspDjymglxgxylists;
import com.module.domain.registrationManagement.apply.apply.DxxzspDjymglxgxylistsWithBLOBs;

public interface DxxzspDjymglxgxylistsMapper {
	int deleteByPrimaryKey(String id);
	 
    int insert(DxxzspDjymglxgxylistsWithBLOBs record);

    int insertSelective(DxxzspDjymglxgxylistsWithBLOBs record);
    
    DxxzspDjymglxgxylistsWithBLOBs selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(DxxzspDjymglxgxylistsWithBLOBs record);

    int updateByPrimaryKey(DxxzspDjymglxgxylistsWithBLOBs record);
    
    int updateByPrimaryKey(DxxzspDjymglxgxylists record);
}



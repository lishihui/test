package com.module.dao.internetDomainRootServices.apply.apply;

import com.module.domain.internetDomainRootServices.apply.apply.DxxzspInfoSecurity;
import com.module.domain.internetDomainRootServices.apply.apply.DxxzspInfoSecurityWithBLOBs;


public interface DxxzspInfoSecurityMapper {
	int deleteByPrimaryKey(String id);
    int insert(DxxzspInfoSecurityWithBLOBs record);

    int insertSelective(DxxzspInfoSecurityWithBLOBs record);
    
    DxxzspInfoSecurityWithBLOBs selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(DxxzspInfoSecurityWithBLOBs record);

    int updateByPrimaryKey(DxxzspInfoSecurityWithBLOBs record);
    
    int updateByPrimaryKey(DxxzspInfoSecurity record);
}




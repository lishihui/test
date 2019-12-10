package com.module.dao.internetDomainRootServices.apply.apply;

import com.module.domain.internetDomainRootServices.apply.apply.DxxzspNetworkSecurity;
import com.module.domain.internetDomainRootServices.apply.apply.DxxzspNetworkSecurityWithBLOBs;


public interface DxxzspNetworkSecurityMapper {
	int deleteByPrimaryKey(String id);
    int insert(DxxzspNetworkSecurityWithBLOBs record);

    int insertSelective(DxxzspNetworkSecurityWithBLOBs record);
    
    DxxzspNetworkSecurityWithBLOBs selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(DxxzspNetworkSecurityWithBLOBs record);

    int updateByPrimaryKey(DxxzspNetworkSecurityWithBLOBs record);
    
    int updateByPrimaryKey(DxxzspNetworkSecurity record);
}



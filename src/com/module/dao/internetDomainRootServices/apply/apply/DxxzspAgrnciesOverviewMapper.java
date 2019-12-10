package com.module.dao.internetDomainRootServices.apply.apply;

import com.module.domain.internetDomainRootServices.apply.apply.DxxzspAgenciesOverview;
import com.module.domain.internetDomainRootServices.apply.apply.DxxzspAgenciesOverviewWithBLOBs;

public interface DxxzspAgrnciesOverviewMapper {
	int deleteByPrimaryKey(String id);
	 
    int insert(DxxzspAgenciesOverviewWithBLOBs record);

    int insertSelective(DxxzspAgenciesOverviewWithBLOBs record);
    
    DxxzspAgenciesOverviewWithBLOBs selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(DxxzspAgenciesOverviewWithBLOBs record);

    int updateByPrimaryKey(DxxzspAgenciesOverviewWithBLOBs record);
    
    int updateByPrimaryKey(DxxzspAgenciesOverview record);
}




package com.module.dao.internetDomainRootServices.apply.apply;

import com.module.domain.internetDomainRootServices.apply.apply.DxxzspManagementListWithBLOBs;

public interface DxxzspManagementListMapper {
    int insert(DxxzspManagementListWithBLOBs record);

    int insertSelective(DxxzspManagementListWithBLOBs record);
    
    DxxzspManagementListWithBLOBs selectByPrimaryKey(String id);
}
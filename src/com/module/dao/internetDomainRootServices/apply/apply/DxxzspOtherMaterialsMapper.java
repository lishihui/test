package com.module.dao.internetDomainRootServices.apply.apply;

import com.module.domain.internetDomainRootServices.apply.apply.DxxzspOtherMaterialsWithBLOBs;

public interface DxxzspOtherMaterialsMapper {
    int insert(DxxzspOtherMaterialsWithBLOBs record);

    int insertSelective(DxxzspOtherMaterialsWithBLOBs record);
    
    DxxzspOtherMaterialsWithBLOBs selectByPrimaryKey(String id);
}
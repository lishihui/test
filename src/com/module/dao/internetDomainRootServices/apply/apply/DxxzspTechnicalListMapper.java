package com.module.dao.internetDomainRootServices.apply.apply;


import com.module.domain.internetDomainRootServices.apply.apply.DxxzspTechnicalListWithBLOBs;

public interface DxxzspTechnicalListMapper {
    int insert(DxxzspTechnicalListWithBLOBs record);

    int insertSelective(DxxzspTechnicalListWithBLOBs record);
    
    DxxzspTechnicalListWithBLOBs selectByPrimaryKey(String id);
}
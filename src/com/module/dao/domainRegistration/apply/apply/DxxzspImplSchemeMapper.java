package com.module.dao.domainRegistration.apply.apply;

import com.module.domain.domainRegistration.apply.apply.DxxzspImplSchemeWithBLOBs;

public interface DxxzspImplSchemeMapper {
    int insert(DxxzspImplSchemeWithBLOBs record);

    int insertSelective(DxxzspImplSchemeWithBLOBs record);
    
    DxxzspImplSchemeWithBLOBs selectByPrimaryKey(String id);

}
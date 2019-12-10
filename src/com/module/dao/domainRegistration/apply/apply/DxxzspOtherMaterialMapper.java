package com.module.dao.domainRegistration.apply.apply;

import com.module.domain.domainRegistration.apply.apply.DxxzspOtherMaterialWithBLOBs;

public interface DxxzspOtherMaterialMapper {
    int insert(DxxzspOtherMaterialWithBLOBs record);

    int insertSelective(DxxzspOtherMaterialWithBLOBs record);
    
    DxxzspOtherMaterialWithBLOBs selectByPrimaryKey(String id);

}
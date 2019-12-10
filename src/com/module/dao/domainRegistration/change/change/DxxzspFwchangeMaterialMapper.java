package com.module.dao.domainRegistration.change.change;

import com.module.domain.domainRegistration.change.change.DxxzspFwchangeMaterialWithBLOBs;

public interface DxxzspFwchangeMaterialMapper {
    int insert(DxxzspFwchangeMaterialWithBLOBs record);

    int insertSelective(DxxzspFwchangeMaterialWithBLOBs record);
    
    DxxzspFwchangeMaterialWithBLOBs selectByPrimaryKey(String id);

}
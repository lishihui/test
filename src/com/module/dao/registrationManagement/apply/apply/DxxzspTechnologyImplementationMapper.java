package com.module.dao.registrationManagement.apply.apply;

import com.module.domain.registrationManagement.apply.apply.DxxzspTechnologyImplementationWithBLOBs;

public interface DxxzspTechnologyImplementationMapper {
    int insert(DxxzspTechnologyImplementationWithBLOBs record);

    int insertSelective(DxxzspTechnologyImplementationWithBLOBs record);
    DxxzspTechnologyImplementationWithBLOBs selectByPrimaryKey(String id);

}
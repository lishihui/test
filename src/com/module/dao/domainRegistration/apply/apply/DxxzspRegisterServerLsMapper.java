package com.module.dao.domainRegistration.apply.apply;

import com.module.domain.domainRegistration.apply.apply.DxxzspRegisterServerLsWithBLOBs;

public interface DxxzspRegisterServerLsMapper {
    int insert(DxxzspRegisterServerLsWithBLOBs record);

    int insertSelective(DxxzspRegisterServerLsWithBLOBs record);
    
    DxxzspRegisterServerLsWithBLOBs selectByPrimaryKey(String id);

}
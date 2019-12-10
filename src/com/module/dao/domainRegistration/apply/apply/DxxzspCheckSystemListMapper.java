package com.module.dao.domainRegistration.apply.apply;

import com.module.domain.domainRegistration.apply.apply.DxxzspCheckSystemListWithBLOBs;

public interface DxxzspCheckSystemListMapper {
    int insert(DxxzspCheckSystemListWithBLOBs record);

    int insertSelective(DxxzspCheckSystemListWithBLOBs record);
    
    DxxzspCheckSystemListWithBLOBs selectByPrimaryKey(String id);

}
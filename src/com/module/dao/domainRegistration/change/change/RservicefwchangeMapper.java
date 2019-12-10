package com.module.dao.domainRegistration.change.change;

import com.module.domain.domainRegistration.change.change.RservicefwchangeWithBLOBs;

public interface RservicefwchangeMapper {
    int insert(RservicefwchangeWithBLOBs record);

    int insertSelective(RservicefwchangeWithBLOBs record);
    
    RservicefwchangeWithBLOBs selectByPrimaryKey(String id);

}
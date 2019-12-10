package com.module.dao.internetDomainRootServices.apply.apply;

import com.module.domain.internetDomainRootServices.apply.apply.DxxzspRootdnsPromiseWithBLOBs;

public interface DxxzspRootdnsPromiseMapper {
    int insert(DxxzspRootdnsPromiseWithBLOBs record);

    int insertSelective(DxxzspRootdnsPromiseWithBLOBs record);
    
    DxxzspRootdnsPromiseWithBLOBs selectByPrimaryKey(String id);
}
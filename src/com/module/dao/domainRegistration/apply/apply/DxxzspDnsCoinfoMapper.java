package com.module.dao.domainRegistration.apply.apply;

import com.module.domain.domainRegistration.apply.apply.DxxzspDnsCoinfoWithBLOBs;

public interface DxxzspDnsCoinfoMapper {
    int insert(DxxzspDnsCoinfoWithBLOBs record);

    int insertSelective(DxxzspDnsCoinfoWithBLOBs record);
    
    DxxzspDnsCoinfoWithBLOBs selectByPrimaryKey(String id);

}
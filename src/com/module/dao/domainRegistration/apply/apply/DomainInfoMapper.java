package com.module.dao.domainRegistration.apply.apply;

import com.module.domain.domainRegistration.apply.apply.DomainInfoWithBLOBs;

public interface DomainInfoMapper {
    int insert(DomainInfoWithBLOBs record);

    int insertSelective(DomainInfoWithBLOBs record);
    
    DomainInfoWithBLOBs selectByPrimaryKey(String id);

}
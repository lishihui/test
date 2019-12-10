package com.module.dao.registrationManagement.apply.apply;

import com.module.domain.registrationManagement.apply.apply.DxxzspTopDomainInfoWithBLOBs;

public interface DxxzspTopDomainInfoMapper {
    int insert(DxxzspTopDomainInfoWithBLOBs record);

    int insertSelective(DxxzspTopDomainInfoWithBLOBs record);
    DxxzspTopDomainInfoWithBLOBs selectByPrimaryKey(String id);
}
package com.module.dao.internetDomainRootServices.apply.apply;

import com.module.domain.internetDomainRootServices.apply.apply.DxxzspDnsOrganizationWithBLOBs;

public interface DxxzspDnsOrganizationMapper {
    int insert(DxxzspDnsOrganizationWithBLOBs record);

    int insertSelective(DxxzspDnsOrganizationWithBLOBs record);
    
    DxxzspDnsOrganizationWithBLOBs selectByPrimaryKey(String id);
}
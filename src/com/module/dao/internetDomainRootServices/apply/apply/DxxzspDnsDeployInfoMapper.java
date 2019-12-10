package com.module.dao.internetDomainRootServices.apply.apply;

import com.module.domain.internetDomainRootServices.apply.apply.DxxzspDnsDeployInfo;
import com.module.domain.internetDomainRootServices.apply.apply.DxxzspDnsDeployInfoWithBLOBs;

public interface DxxzspDnsDeployInfoMapper {
	int deleteByPrimaryKey(String id);
	 
    int insert(DxxzspDnsDeployInfoWithBLOBs record);

    int insertSelective(DxxzspDnsDeployInfoWithBLOBs record);
    
    DxxzspDnsDeployInfoWithBLOBs selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(DxxzspDnsDeployInfoWithBLOBs record);

    int updateByPrimaryKey(DxxzspDnsDeployInfoWithBLOBs record);
    
    int updateByPrimaryKey(DxxzspDnsDeployInfo record);
}


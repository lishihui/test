package com.module.dao.domainRegistration.apply.apply;

import com.module.domain.domainRegistration.apply.apply.WlxxaqWithBLOBs;

public interface WlxxaqMapper {
    int insert(WlxxaqWithBLOBs record);

    int insertSelective(WlxxaqWithBLOBs record);
    
    WlxxaqWithBLOBs selectByPrimaryKey(String id);

}
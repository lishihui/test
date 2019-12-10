package com.module.dao.registrationManagement.apply.apply;

import com.module.domain.registrationManagement.apply.apply.DxxzspTelecommManaReq;
import com.module.domain.registrationManagement.apply.apply.DxxzspTelecommManaReqWithBLOBs;

public interface DxxzspTelecommManaReqMapper {
    int insert(DxxzspTelecommManaReq record);

    int insertSelective(DxxzspTelecommManaReq record);
    DxxzspTelecommManaReqWithBLOBs selectByPrimaryKey(String id);
}
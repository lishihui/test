package com.module.dao.registrationManagement.change.comm;

import com.module.domain.registrationManagement.change.comm.DxxzspTechLegalWithBLOBs;

public interface DxxzspTechLegalMapper {
    int insert(DxxzspTechLegalWithBLOBs record);

    int insertSelective(DxxzspTechLegalWithBLOBs record);
    
    DxxzspTechLegalWithBLOBs selectByPrimaryKey(String id);

}
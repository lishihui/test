package com.module.dao.registrationManagement.change.change;

import com.module.domain.registrationManagement.change.change.DxxzspTechQtclbWithBLOBs;

public interface DxxzspTechQtclbMapper {
    int insert(DxxzspTechQtclbWithBLOBs record);

    int insertSelective(DxxzspTechQtclbWithBLOBs record);
    
    DxxzspTechQtclbWithBLOBs selectByPrimaryKey(String id);

}
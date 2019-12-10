package com.module.dao.ftaTradeApplication.change.change;

import com.module.domain.ftaTradeApplication.change.change.DxxzspDynamicTableWithBLOBs;

public interface DxxzspDynamicTableMapper {
    int insert(DxxzspDynamicTableWithBLOBs record);

    int insertSelective(DxxzspDynamicTableWithBLOBs record);
    
    DxxzspDynamicTableWithBLOBs selectByPrimaryKey(String id);

}
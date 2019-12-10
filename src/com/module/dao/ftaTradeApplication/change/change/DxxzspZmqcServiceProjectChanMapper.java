package com.module.dao.ftaTradeApplication.change.change;

import com.module.domain.ftaTradeApplication.change.change.DxxzspZmqcServiceProjectChanWithBLOBs;

public interface DxxzspZmqcServiceProjectChanMapper {
	 
    int insert(DxxzspZmqcServiceProjectChanWithBLOBs record);

    int insertSelective(DxxzspZmqcServiceProjectChanWithBLOBs record);
    
    DxxzspZmqcServiceProjectChanWithBLOBs selectByPrimaryKey(String id);

}

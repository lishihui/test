package com.module.dao.ftaTradeApplication.change.change;

import com.module.domain.ftaTradeApplication.change.change.ZmqcBusinessChangeWithBLOBs;

public interface ZmqcBusinessChangeMapper {
    int insert(ZmqcBusinessChangeWithBLOBs record);

    int insertSelective(ZmqcBusinessChangeWithBLOBs record);
    
    ZmqcBusinessChangeWithBLOBs selectByPrimaryKey(String id);

}
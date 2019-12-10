package com.module.dao.ftaTradeApplication.change.change;

import com.module.domain.ftaTradeApplication.change.change.ZmqcLegalChangeWithBLOBs;

public interface ZmqcLegalChangeMapper {
    int insert(ZmqcLegalChangeWithBLOBs record);

    int insertSelective(ZmqcLegalChangeWithBLOBs record);
    
    ZmqcLegalChangeWithBLOBs selectByPrimaryKey(String id);

}
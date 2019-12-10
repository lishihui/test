package com.module.dao.ftaTradeApplication.change.change;

import com.module.domain.ftaTradeApplication.change.change.ZmqcContinueApplicationWithBLOBs;

public interface ZmqcContinueApplicationMapper {
    int insert(ZmqcContinueApplicationWithBLOBs record);

    int insertSelective(ZmqcContinueApplicationWithBLOBs record);
    
    ZmqcContinueApplicationWithBLOBs selectByPrimaryKey(String id);

}
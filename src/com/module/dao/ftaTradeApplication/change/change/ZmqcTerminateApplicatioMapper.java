package com.module.dao.ftaTradeApplication.change.change;

import com.module.domain.ftaTradeApplication.change.change.ZmqcTerminateApplicatioWithBLOBs;

public interface ZmqcTerminateApplicatioMapper {
    int insert(ZmqcTerminateApplicatioWithBLOBs record);

    int insertSelective(ZmqcTerminateApplicatioWithBLOBs record);
    
    ZmqcTerminateApplicatioWithBLOBs selectByPrimaryKey(String id);

}
package com.module.dao.ftaTradeApplication.change.comm;

import com.module.domain.ftaTradeApplication.change.comm.ZmqcChangePublicFormsWithBLOBs;

public interface ZmqcChangePublicFormsMapper {
    int insert(ZmqcChangePublicFormsWithBLOBs record);

    int insertSelective(ZmqcChangePublicFormsWithBLOBs record);
    
    ZmqcChangePublicFormsWithBLOBs selectByPrimaryKey(String id);

}
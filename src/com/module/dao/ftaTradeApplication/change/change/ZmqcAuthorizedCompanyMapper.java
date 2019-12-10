package com.module.dao.ftaTradeApplication.change.change;

import com.module.domain.ftaTradeApplication.change.change.ZmqcAuthorizedCompanyWithBLOBs;

public interface ZmqcAuthorizedCompanyMapper {
    int insert(ZmqcAuthorizedCompanyWithBLOBs record);

    int insertSelective(ZmqcAuthorizedCompanyWithBLOBs record);
    
    ZmqcAuthorizedCompanyWithBLOBs selectByPrimaryKey(String id);

}
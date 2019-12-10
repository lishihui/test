package com.module.dao.system;

import com.module.domain.system.SysLog;

public interface SysLogMapper {
    int deleteByPrimaryKey(String logid);

    int insert(SysLog record);

    int insertSelective(SysLog record);

    SysLog selectByPrimaryKey(String logid);

    int updateByPrimaryKeySelective(SysLog record);

    int updateByPrimaryKeyWithBLOBs(SysLog record);

    int updateByPrimaryKey(SysLog record);
}
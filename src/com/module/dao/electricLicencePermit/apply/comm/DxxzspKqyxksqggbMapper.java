package com.module.dao.electricLicencePermit.apply.comm;

import com.module.domain.electricLicencePermit.apply.comm.DxxzspKqyxksqggbWithBLOBs;

public interface DxxzspKqyxksqggbMapper {
    int deleteByPrimaryKey(String id);

    int insert(DxxzspKqyxksqggbWithBLOBs record);

    int insertSelective(DxxzspKqyxksqggbWithBLOBs record);

    DxxzspKqyxksqggbWithBLOBs selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(DxxzspKqyxksqggbWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(DxxzspKqyxksqggbWithBLOBs record);

    int updateByPrimaryKey(DxxzspKqyxksqggbWithBLOBs record);
}
package com.module.dao.electricLicencePermit.change.commChange;

import com.module.domain.electricLicencePermit.change.commChange.DxxzspKqyxksqggbChaComWithBLOBs;

public interface DxxzspKqyxksqggbChaComMapper {
    int deleteByPrimaryKey(String id);

    int insert(DxxzspKqyxksqggbChaComWithBLOBs record);

    int insertSelective(DxxzspKqyxksqggbChaComWithBLOBs record);

    DxxzspKqyxksqggbChaComWithBLOBs selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(DxxzspKqyxksqggbChaComWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(DxxzspKqyxksqggbChaComWithBLOBs record);

    int updateByPrimaryKey(DxxzspKqyxksqggbChaComWithBLOBs record);
}
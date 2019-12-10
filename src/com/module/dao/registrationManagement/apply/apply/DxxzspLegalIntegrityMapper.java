package com.module.dao.registrationManagement.apply.apply;

import com.module.domain.registrationManagement.apply.apply.DxxzspLegalIntegrityWithBLOBs;

public interface DxxzspLegalIntegrityMapper {
    int insert(DxxzspLegalIntegrityWithBLOBs record);

    int insertSelective(DxxzspLegalIntegrityWithBLOBs record);
    DxxzspLegalIntegrityWithBLOBs selectByPrimaryKey(String id);
}
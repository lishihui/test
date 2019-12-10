package com.module.dao.electricLicencePermit.change.commChange;

import com.module.domain.electricLicencePermit.change.commChange.ChangePublicFormsWithBLOBs;

public interface ChangePublicFormsMapper {
    int insert(ChangePublicFormsWithBLOBs record);

    int insertSelective(ChangePublicFormsWithBLOBs record);
    
    ChangePublicFormsWithBLOBs selectByPrimaryKey(String id);

}
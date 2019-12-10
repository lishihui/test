package com.module.dao.electricLicencePermit.change.TransRegionalChange;

import com.module.domain.electricLicencePermit.change.TransRegionalChange.TerminateApplicationWithBLOBs;


public interface TerminateApplicationMapper {
    int insert(TerminateApplicationWithBLOBs record);

    int insertSelective(TerminateApplicationWithBLOBs record);
    
    TerminateApplicationWithBLOBs selectByPrimaryKey(String id);
}
package com.module.dao.electricLicencePermit.change.TransRegionalChange;

import com.module.domain.electricLicencePermit.change.TransRegionalChange.ContinueApplicationWithBLOBs;

public interface ContinueApplicationMapper {
    int insert(ContinueApplicationWithBLOBs record);

    int insertSelective(ContinueApplicationWithBLOBs record);
    ContinueApplicationWithBLOBs selectByPrimaryKey(String id);
}
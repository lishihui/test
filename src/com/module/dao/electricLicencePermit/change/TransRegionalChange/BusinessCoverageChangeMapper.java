package com.module.dao.electricLicencePermit.change.TransRegionalChange;

import com.module.domain.electricLicencePermit.change.TransRegionalChange.BusinessCoverageChange;

public interface BusinessCoverageChangeMapper {
    int insert(BusinessCoverageChange record);

    int insertSelective(BusinessCoverageChange record);
}
package com.module.dao.electricLicencePermit.apply.provinceInner;

import com.module.domain.electricLicencePermit.apply.provinceInner.DxxzspFwydyw;
import com.module.domain.electricLicencePermit.apply.provinceInner.DxxzspFwydywWithBLOBs;

public interface DxxzspFwydywMapper {
    int insert(DxxzspFwydyw record);

    int insertSelective(DxxzspFwydyw record);
    DxxzspFwydywWithBLOBs selectByPrimaryKey(String id);
}
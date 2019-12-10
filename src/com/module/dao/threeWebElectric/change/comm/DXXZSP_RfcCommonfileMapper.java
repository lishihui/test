package com.module.dao.threeWebElectric.change.comm;

import com.module.domain.threeWebElectric.change.comm.DXXZSP_RfcCommonfileWithBLOBs;

public interface DXXZSP_RfcCommonfileMapper {
    int insert(DXXZSP_RfcCommonfileWithBLOBs record);

    int insertSelective(DXXZSP_RfcCommonfileWithBLOBs record);
    DXXZSP_RfcCommonfileWithBLOBs selectByPrimaryKey(String id);
}
package com.module.dao.domain;

import com.module.domain.domain.DxxzspDomainRegisterStockright;

public interface DxxzspDomainRegisterStockrightMapper {
    int deleteByPrimaryKey(String id);

    int insert(DxxzspDomainRegisterStockright record);

    int insertSelective(DxxzspDomainRegisterStockright record);

    DxxzspDomainRegisterStockright selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(DxxzspDomainRegisterStockright record);

    int updateByPrimaryKey(DxxzspDomainRegisterStockright record);
}
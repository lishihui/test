package com.module.dao.domain;

import com.module.domain.domain.DxxzspDomainPromise;

public interface DxxzspDomainPromiseMapper {
    int deleteByPrimaryKey(String id);

    int insert(DxxzspDomainPromise record);

    int insertSelective(DxxzspDomainPromise record);

    DxxzspDomainPromise selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(DxxzspDomainPromise record);

    int updateByPrimaryKeyWithBLOBs(DxxzspDomainPromise record);

    int updateByPrimaryKey(DxxzspDomainPromise record);
}
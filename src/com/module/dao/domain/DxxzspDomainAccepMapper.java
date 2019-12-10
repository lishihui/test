package com.module.dao.domain;

import com.module.domain.domain.DxxzspDomainAccep;

public interface DxxzspDomainAccepMapper {
    int deleteByPrimaryKey(String id);

    int insert(DxxzspDomainAccep record);

    int insertSelective(DxxzspDomainAccep record);

    DxxzspDomainAccep selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(DxxzspDomainAccep record);

    int updateByPrimaryKey(DxxzspDomainAccep record);
}
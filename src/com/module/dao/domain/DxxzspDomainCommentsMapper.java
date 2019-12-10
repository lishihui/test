package com.module.dao.domain;

import com.module.domain.domain.DxxzspDomainComments;

public interface DxxzspDomainCommentsMapper {
    int deleteByPrimaryKey(String id);

    int insert(DxxzspDomainComments record);

    int insertSelective(DxxzspDomainComments record);

    DxxzspDomainComments selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(DxxzspDomainComments record);

    int updateByPrimaryKey(DxxzspDomainComments record);
}
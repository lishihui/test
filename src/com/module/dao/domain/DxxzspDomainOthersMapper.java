package com.module.dao.domain;

import com.module.domain.domain.DxxzspDomainOthers;

import java.util.List;

public interface DxxzspDomainOthersMapper {
    int deleteByPrimaryKey(String id);

    int insert(DxxzspDomainOthers record);

    int insertSelective(DxxzspDomainOthers record);

    DxxzspDomainOthers selectByPrimaryKey(String id);

    List<DxxzspDomainOthers> list(String ywid);

    int updateByPrimaryKeySelective(DxxzspDomainOthers record);

    int updateByPrimaryKeyWithBLOBs(DxxzspDomainOthers record);

    int updateByPrimaryKey(DxxzspDomainOthers record);
}
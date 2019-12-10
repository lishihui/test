package com.module.dao.pub;

import com.module.domain.pub.PublicItemHistorical;

public interface PublicItemHistoricalMapper {
    int deleteByPrimaryKey(String id);

    int insert(PublicItemHistorical record);

    int insertSelective(PublicItemHistorical record);

    PublicItemHistorical selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(PublicItemHistorical record);

    int updateByPrimaryKey(PublicItemHistorical record);
}
package com.module.dao.domain;
import com.module.domain.domain.filedUpDownBlobs;
public interface filedUpDownMapper{
    int deleteByPrimaryKey(String id);

    int insert(filedUpDownBlobs record);

    int insertSelective(filedUpDownBlobs record);

    filedUpDownBlobs selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(filedUpDownBlobs record);

    int updateByPrimaryKeyWithBLOBs(filedUpDownBlobs record);

    int updateByPrimaryKey(filedUpDownBlobs record);
}
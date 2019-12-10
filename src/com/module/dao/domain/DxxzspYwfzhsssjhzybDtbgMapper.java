package com.module.dao.domain;

import com.module.domain.domain.DxxzspYwfzhsssjhzybDtbgWithBLOBs;

public interface DxxzspYwfzhsssjhzybDtbgMapper {
    int insert(DxxzspYwfzhsssjhzybDtbgWithBLOBs record);

    int insertSelective(DxxzspYwfzhsssjhzybDtbgWithBLOBs record);
    
    DxxzspYwfzhsssjhzybDtbgWithBLOBs selectByPrimaryKey(String id);
}
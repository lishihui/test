package com.module.dao.domain;

import com.module.domain.domain.DxxzspWLXIAQBZCSWithBLOBs;

public interface DxxzspWLXIAQBZCSMapper {
    int insert(DxxzspWLXIAQBZCSWithBLOBs record);

    int insertSelective(DxxzspWLXIAQBZCSWithBLOBs record);
    
    DxxzspWLXIAQBZCSWithBLOBs selectByPrimaryKey(String id);
}
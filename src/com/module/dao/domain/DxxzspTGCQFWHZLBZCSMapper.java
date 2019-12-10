package com.module.dao.domain;

import com.module.domain.domain.DxxzspTGCQFWHZLBZCS;
import com.module.domain.domain.DxxzspTGCQFWHZLBZCSWithBLOBs;
import com.module.domain.domain.DxxzspWlyjsfaZybWithBLOBs;

public interface DxxzspTGCQFWHZLBZCSMapper {
    int insert(DxxzspTGCQFWHZLBZCS record);

    int insertSelective(DxxzspTGCQFWHZLBZCS record);

    DxxzspTGCQFWHZLBZCSWithBLOBs selectByPrimaryKey(String id);
}
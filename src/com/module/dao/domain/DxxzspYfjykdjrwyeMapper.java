package com.module.dao.domain;

import com.module.domain.domain.DxxzspWlyjsfaZybWithBLOBs;
import com.module.domain.domain.DxxzspYfjykdjrwye;
import com.module.domain.domain.DxxzspYfjykdjrwyeWithBLOBs;

public interface DxxzspYfjykdjrwyeMapper {
    int insert(DxxzspYfjykdjrwye record);

    int insertSelective(DxxzspYfjykdjrwye record);

    DxxzspYfjykdjrwyeWithBLOBs selectByPrimaryKey(String id);
}
package com.module.dao.domain;

import com.module.domain.domain.DxxzspWLXIAQBZCSWithBLOBs;
import com.module.domain.domain.DxxzspWlyjsfaZybWithBLOBs;

public interface DxxzspWlyjsfaZybMapper {
    int insert(DxxzspWlyjsfaZybWithBLOBs record);

    int insertSelective(DxxzspWlyjsfaZybWithBLOBs record);
    
    DxxzspWlyjsfaZybWithBLOBs selectByPrimaryKey(String id);
}
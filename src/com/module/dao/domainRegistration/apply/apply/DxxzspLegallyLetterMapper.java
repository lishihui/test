package com.module.dao.domainRegistration.apply.apply;

import com.module.domain.domainRegistration.apply.apply.DxxzspLegallyLetterWithBLOBs;

public interface DxxzspLegallyLetterMapper {
    int insert(DxxzspLegallyLetterWithBLOBs record);

    int insertSelective(DxxzspLegallyLetterWithBLOBs record);
    
    DxxzspLegallyLetterWithBLOBs selectByPrimaryKey(String id);

}
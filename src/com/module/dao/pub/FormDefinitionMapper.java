package com.module.dao.pub;

import com.module.domain.domain.FormDefinition;
import com.module.domain.domain.FormDefinitionWithBLOBs;

public interface FormDefinitionMapper {

    FormDefinitionWithBLOBs selectByPrimaryKey(String id);
 
}
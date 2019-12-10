package com.module.dao.pub;

import com.module.domain.domain.FormMeta;
import com.module.domain.domain.FormMetaWithBLOBs;

public interface FormMetaMapper {
  

    FormMetaWithBLOBs selectByPrimaryKey(String id);
  
}
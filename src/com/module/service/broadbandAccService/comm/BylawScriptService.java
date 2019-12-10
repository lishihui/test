package com.module.service.broadbandAccService.comm;

import java.util.Map;
import com.util.AppException;

//公司章程(加盖工商局档案查询章原件)(bylawScript)
public interface BylawScriptService {
	
	//根据主键查询业务数据
    public Map<String,Object> getRow(String id,String flowrunid) throws AppException;
}

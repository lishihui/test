package com.module.service.broadbandAccService.comm;

import java.util.Map;
import com.util.AppException;

//企业3年以上运营经验的证明材料
public interface OperationExperienceService {
	
	//根据主键查询业务数据
    public Map<String,Object> getRow(String id,String flowrunid) throws AppException;
}

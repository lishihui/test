package com.module.service.foreignInvestment;

import java.util.Map;
import com.util.AppException;

//外商投资股东追溯及其相关材料证明
public interface BasicSituationEnterpriseService {
	    
	//根据主键查询业务数据
    public Map<String,Object> getRow(String id,String flowrunid) throws AppException;
}

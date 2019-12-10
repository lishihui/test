package com.module.service.foreignInvestment;

import java.util.Map;
import com.util.AppException;

//外商投资申请企业投资者基本情况（enterprisesApplyingInvestment）
public interface EnterprisesApplyingInvestmentService {
	
	//根据主键查询业务数据
    public Map<String,Object> getRow(String id,String flowrunid) throws AppException;
}

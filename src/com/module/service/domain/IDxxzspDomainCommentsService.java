package com.module.service.domain;

import java.util.Map;
import com.util.AppException;

//流程节点表单意见表
public interface IDxxzspDomainCommentsService {
	
	//保存流程节点表单意见
    public Map<String,Object> saveRow(String jsonStr) throws AppException;
    
	//根据条件查询流程节点表单意见  (表单表名  数据id)
    public Map<String,Object> getData(String formname,String itemid) throws AppException;
}

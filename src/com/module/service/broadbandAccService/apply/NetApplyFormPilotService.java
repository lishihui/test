package com.module.service.broadbandAccService.apply;

import java.util.Map;
import com.util.AppException;
//宽带接入网业务
public interface NetApplyFormPilotService {
	//根据主键查询业务数据
    public Map<String,Object> getRow(String id,String flowrunid) throws AppException;
}

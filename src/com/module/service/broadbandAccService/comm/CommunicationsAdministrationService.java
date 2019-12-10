package com.module.service.broadbandAccService.comm;

import java.util.Map;
import com.util.AppException;

//省通信管理局要求提交的其他材料
public interface CommunicationsAdministrationService {
	
	//根据主键查询业务数据
    public Map<String,Object> getRow(String id,String flowrunid) throws AppException;
}

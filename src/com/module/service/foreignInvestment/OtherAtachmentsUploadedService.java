package com.module.service.foreignInvestment;

import java.util.Map;
import com.util.AppException;

//外商投资其他附件上传（otherAtachmentsUploaded）
public interface OtherAtachmentsUploadedService {
	
	//根据主键查询业务数据
    public Map<String,Object> getRow(String id,String flowrunid) throws AppException;
}

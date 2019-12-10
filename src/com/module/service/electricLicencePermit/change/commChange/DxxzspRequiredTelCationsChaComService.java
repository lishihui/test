package com.module.service.electricLicencePermit.change.commChange;

import java.util.Map;
import com.util.AppException;

//电信主管部门要求的其他材料
public interface DxxzspRequiredTelCationsChaComService  {
	//根据主键查询业务数据
	 public Map<String,Object> getRow(String id,String flowrunid) throws AppException;
}

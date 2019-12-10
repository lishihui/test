package com.module.service.electricLicencePermit.change.TransRegionalChange;

import java.util.Map;

import com.util.AppException;

public interface DxxzspChangeOfCompanyChaTraService {
	public Map<String,Object> getRow(String id,String flowrunid) throws AppException;
}

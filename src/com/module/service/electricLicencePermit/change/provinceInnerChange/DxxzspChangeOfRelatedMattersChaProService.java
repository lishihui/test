package com.module.service.electricLicencePermit.change.provinceInnerChange;

import java.util.Map;

import com.util.AppException;

public interface DxxzspChangeOfRelatedMattersChaProService {
	public Map<String,Object> getRow(String id,String flowrunid) throws AppException;
}

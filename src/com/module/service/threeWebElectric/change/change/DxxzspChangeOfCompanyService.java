package com.module.service.threeWebElectric.change.change;

import java.util.Map;

import com.util.AppException;

public interface DxxzspChangeOfCompanyService {
	public Map<String,Object> getRow(String id,String flowrunid) throws AppException;
}

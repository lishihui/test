package com.module.service.threeWebElectric.change.change;

import java.util.Map;

import com.util.AppException;

public interface DxxzspRenewalService {
	public Map<String,Object> getRow(String id,String flowrunid) throws AppException;
}

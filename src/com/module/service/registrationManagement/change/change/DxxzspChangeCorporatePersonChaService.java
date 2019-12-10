package com.module.service.registrationManagement.change.change;

import java.util.Map;

import com.util.AppException;

public interface DxxzspChangeCorporatePersonChaService {
	public Map<String,Object> getRow(String id,String flowrunid) throws AppException;
}

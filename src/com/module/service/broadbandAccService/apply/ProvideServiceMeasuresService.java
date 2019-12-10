package com.module.service.broadbandAccService.apply;

import java.util.Map;

import com.util.AppException;

public interface ProvideServiceMeasuresService {
	 public Map<String,Object> getRow(String id,String flowrunid) throws AppException;
}

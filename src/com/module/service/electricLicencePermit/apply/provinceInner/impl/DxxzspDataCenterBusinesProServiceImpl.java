package com.module.service.electricLicencePermit.apply.provinceInner.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.module.dao.base.CommonMapper;
import com.module.service.common.ItemUserApplyService;
import com.module.service.electricLicencePermit.apply.provinceInner.DxxzspDataCenterBusinesProService;
import com.util.AppException;

@Service("DxxzspDataCenterBusinesService")
public class DxxzspDataCenterBusinesProServiceImpl implements DxxzspDataCenterBusinesProService {
	@Resource
	private CommonMapper commonMapper;
	@Resource
	private ItemUserApplyService itemUserApplyService;
	@Override
	public Map<String, Object> getRow(String id, String flowrunid)throws AppException {
		String itemid= itemUserApplyService.getProcessId(id);
		Map<String,Object> ret = new HashMap<String,Object>();
		List<Map<String,Object>> list_InternetData =  commonMapper.findManyData("select * from INTERNET_DATA where itemid = '"+itemid+"'");	
		List<Map<String,Object>> list_DxxzspIdcCityYwfw =  commonMapper.findManyData("select * from DXXZSP_IDC_CITY_YWFW where itemid = '"+itemid+"'");	
		List<Map<String,Object>> list_DxxzspIdcCityNotYwfw =  commonMapper.findManyData("select * from DXXZSP_IDC_CITY_NOT_YWFW where itemid = '"+itemid+"'");	
		ret.put("list_InternetData", list_InternetData);
		ret.put("list_DxxzspIdcCityYwfw", list_DxxzspIdcCityYwfw);
		ret.put("list_DxxzspIdcCityNotYwfw", list_DxxzspIdcCityNotYwfw);
		return ret;
	}
	
}

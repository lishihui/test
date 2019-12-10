package com.module.service.electricLicencePermit.apply.provinceInner.impl;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.module.dao.base.CommonMapper;
import com.module.service.common.ItemUserApplyService;
import com.module.service.electricLicencePermit.apply.provinceInner.DxxzspFixedDataServiceProService;
import com.util.AppException;

@Service("DxxzspFixedDataServiceProService")
public class DxxzspFixedDataServiceProServiceImpl implements DxxzspFixedDataServiceProService {
	@Resource
	private CommonMapper commonMapper;
	@Resource
	private ItemUserApplyService itemUserApplyService;
	@Override
	public Map<String, Object> getRow(String id, String flowrunid)throws AppException {
		String itemid= itemUserApplyService.getProcessId(id);
		Map<String,Object> ret = new HashMap<String,Object>();
		List<Map<String,Object>> list_FixedDataService =  commonMapper.findManyData("select * from FIXED_NET where itemid = '"+itemid+"'");
		ret.put("FIXED_NET", list_FixedDataService);
		return ret;
	}
	
}

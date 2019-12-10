package com.module.service.electricLicencePermit.apply.transRegional.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.module.dao.base.CommonMapper;
import com.module.service.common.ItemUserApplyService;
import com.module.service.electricLicencePermit.apply.transRegional.DxxzspInternetVirtualPrivateService;
import com.util.AppException;

@Service("DxxzspInternetVirtualPrivateService")
public class DxxzspInternetVirtualPrivateServiceImpl implements DxxzspInternetVirtualPrivateService {
	@Resource
	private CommonMapper commonMapper;
	@Resource
	private ItemUserApplyService itemUserApplyService;
	@Override
	public Map<String, Object> getRow(String id, String flowrunid)throws AppException {
		String itemid= itemUserApplyService.getProcessId(id);
		Map<String,Object> ret = new HashMap<String,Object>();
		List<Map<String,Object>> list_agreement =  commonMapper.findManyData("select * from VIRTUAL_BUSINESS where itemid = '"+itemid+"'");
		ret.put("VIRTUAL_BUSINESS", list_agreement);
		return ret;
	}
	
}

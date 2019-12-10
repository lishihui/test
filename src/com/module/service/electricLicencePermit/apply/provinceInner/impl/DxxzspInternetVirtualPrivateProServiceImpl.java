package com.module.service.electricLicencePermit.apply.provinceInner.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.module.dao.base.CommonMapper;
import com.module.service.common.ItemUserApplyService;
import com.module.service.electricLicencePermit.apply.provinceInner.DxxzspInternetVirtualPrivateProService;
import com.util.AppException;

@Service("DxxzspInternetVirtualPrivateProService")
public class DxxzspInternetVirtualPrivateProServiceImpl implements DxxzspInternetVirtualPrivateProService {
	@Resource
	private CommonMapper commonMapper;
	@Resource
	private ItemUserApplyService itemUserApplyService;
	@Override
	public Map<String, Object> getRow(String id, String flowrunid)throws AppException {
		String itemid= itemUserApplyService.getProcessId(id);
		Map<String,Object> ret = new HashMap<String,Object>();
		Map<String,Object> list_InternetVirtualPrivate =  commonMapper.findOneData("select * from VIRTUAL_BUSINESS where itemid = '"+itemid+"'");
		if(list_InternetVirtualPrivate != null){
			String ywid = (String) list_InternetVirtualPrivate.get("ID");
			List<Map<String,Object>> list_VirtualBusiness =  commonMapper.findManyData("select * from VIRTUAL_BUSINESS where id = '"+ywid+"'");
			
			ret.put("VIRTUAL_BUSINESS", list_VirtualBusiness);
		
		}
		return ret;
	}
}

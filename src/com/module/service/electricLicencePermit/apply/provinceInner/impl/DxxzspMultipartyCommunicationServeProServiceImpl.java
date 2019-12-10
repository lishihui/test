package com.module.service.electricLicencePermit.apply.provinceInner.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.module.dao.base.CommonMapper;
import com.module.service.common.ItemUserApplyService;
import com.module.service.electricLicencePermit.apply.provinceInner.DxxzspMultipartyCommunicationServeProService;
import com.util.AppException;

@Service("DxxzspMultipartyCommunicationServeProService")
public class DxxzspMultipartyCommunicationServeProServiceImpl implements DxxzspMultipartyCommunicationServeProService {
	@Resource
	private CommonMapper commonMapper;
	@Resource
	private ItemUserApplyService itemUserApplyService;
	@Override
	public Map<String, Object> getRow(String id, String flowrunid)throws AppException {
		String itemid= itemUserApplyService.getProcessId(id);
		Map<String,Object> ret = new HashMap<String,Object>();
		List<Map<String,Object>> list_MultipartyCommunicationServe =  commonMapper.findManyData("select * from COMM_BUSINESS where itemid = '"+itemid+"'");
		ret.put("COMM_BUSINESS", list_MultipartyCommunicationServe);
		return ret;
	}
	
}

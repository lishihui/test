package com.module.service.domainRegistration.change.change.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.module.dao.base.CommonMapper;
import com.module.service.common.ItemUserApplyService;
import com.module.service.domainRegistration.change.change.DxxzspLegalPersonRealmChangeService;
import com.util.AppException;

@Service("DxxzspLegalPersonRealmChangeService")
public class DxxzspLegalPersonRealmChangeServiceImpl implements DxxzspLegalPersonRealmChangeService{
	@Resource
	private CommonMapper commonMapper;
	@Resource
	private ItemUserApplyService itemUserApplyService;
	@Override
	public Map<String, Object> getRow(String id, String flowrunid)throws AppException {
		String  itemid=itemUserApplyService.getProcessId(id);
		Map<String,Object> ret = new HashMap<String,Object>();
		List<Map<String,Object>> list_agreement =  commonMapper.findManyData("select * from DXXZSP_LEGAL_CHANGED where itemid = '"+itemid+"'");
		ret.put("DXXZSP_LEGAL_CHANGED", list_agreement);
		return ret;
	}
}

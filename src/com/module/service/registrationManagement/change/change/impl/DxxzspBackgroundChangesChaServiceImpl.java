package com.module.service.registrationManagement.change.change.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.module.dao.base.CommonMapper;
import com.module.service.common.ItemUserApplyService;
import com.module.service.registrationManagement.change.change.DxxzspBackgroundChangesChaService;
import com.util.AppException;

@Service("DxxzspBackgroundChangesChaService")
public class DxxzspBackgroundChangesChaServiceImpl implements DxxzspBackgroundChangesChaService{
	@Resource
	private CommonMapper commonMapper;
	@Resource
	private ItemUserApplyService itemUserApplyService;
	@Override
	public Map<String, Object> getRow(String id, String flowrunid)throws AppException {
		String itemid=itemUserApplyService.getProcessId(id);
		Map<String,Object> ret = new HashMap<String,Object>();
		List<Map<String,Object>> list_agreement1 =  commonMapper.findManyData("select * from DXXZSP_TECH_CHANGED where itemid = '"+itemid+"'");	
		List<Map<String,Object>> list_agreement2 =  commonMapper.findManyData("select * from TECH_DJY where itemid = '"+itemid+"'");
		ret.put("DXXZSP_TECH_CHANGED", list_agreement1);	
		ret.put("TECH_DJY", list_agreement2);	
		return ret;
	}
}

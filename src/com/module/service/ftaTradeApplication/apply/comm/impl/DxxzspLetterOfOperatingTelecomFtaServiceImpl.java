package com.module.service.ftaTradeApplication.apply.comm.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.module.dao.base.CommonMapper;
import com.module.service.common.ItemUserApplyService;
import com.module.service.ftaTradeApplication.apply.comm.DxxzspLetterOfOperatingTelecomFtaService;
import com.util.AppException;

@Service("DxxzspLetterOfOperatingTelecomFtaService")
public class DxxzspLetterOfOperatingTelecomFtaServiceImpl implements DxxzspLetterOfOperatingTelecomFtaService{
	@Resource
	private CommonMapper commonMapper;
	@Resource
	private ItemUserApplyService itemUserApplyService;
	@Override
	public Map<String, Object> getRow(String id, String flowrunid)throws AppException {
		String itemid=itemUserApplyService.getProcessId(id);
		Map<String,Object> ret = new HashMap<String,Object>();
		List<Map<String,Object>> list_agreement1 =  commonMapper.findManyData("select * from DXXZSP_ZMQ_KQYXKSQGGB where itemid = '"+itemid+"'");	
		List<Map<String,Object>> list_agreement2 =  commonMapper.findManyData("select * from DXXZSP_ZYJSRYMD where itemid = '"+itemid+"'");	
		List<Map<String,Object>> list_agreement3 =  commonMapper.findManyData("select * from DXXZSP_ZYGLRYMD where itemid = '"+itemid+"'");	
		List<Map<String,Object>> list_agreement4 =  commonMapper.findManyData("select * from DXXZSP_GGBGQJG where itemid = '"+itemid+"'");	
		ret.put("DXXZSP_ZMQ_KQYXKSQGGB", list_agreement1);	
		ret.put("DXXZSP_ZYJSRYMD", list_agreement2);	
		ret.put("DXXZSP_ZYGLRYMD", list_agreement3);	
		ret.put("DXXZSP_GGBGQJG", list_agreement4);	
	
		return ret;
	}
}

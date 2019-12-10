package com.module.service.registrationManagement.change.change.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.module.dao.base.CommonMapper;
import com.module.service.common.ItemUserApplyService;
import com.module.service.registrationManagement.change.change.DxxzspDxxzspDjyzcglxtcsqkbsChaService;
import com.util.AppException;

@Service("DxxzspDxxzspDjyzcglxtcsqkbsChaService")
public class DxxzspDxxzspDjyzcglxtcsqkbsChaServiceImpl implements DxxzspDxxzspDjyzcglxtcsqkbsChaService{
	@Resource
	private CommonMapper commonMapper;
	@Resource
	private ItemUserApplyService itemUserApplyService;
	@Override
	public Map<String, Object> getRow(String id, String flowrunid)throws AppException {
		String itemid=itemUserApplyService.getProcessId(id);
		Map<String,Object> ret = new HashMap<String,Object>();
		List<Map<String,Object>> list_agreement1 =  commonMapper.findManyData("select * from DXXZSP_DJYZCGLXTCSQKBS where itemid = '"+itemid+"'");	
		List<Map<String,Object>> list_agreement2 =  commonMapper.findManyData("select * from DNS_ADDR_IP_E where itemid = '"+itemid+"'");	
		List<Map<String,Object>> list_agreement3 =  commonMapper.findManyData("select * from DNS_ADDR_IP_D where itemid = '"+itemid+"'");	
		List<Map<String,Object>> list_agreement4 =  commonMapper.findManyData("select * from DNS_ADDR_IP_C where itemid = '"+itemid+"'");	
		List<Map<String,Object>> list_agreement5 =  commonMapper.findManyData("select * from DNS_ADDR_IP_B where itemid = '"+itemid+"'");	
		List<Map<String,Object>> list_agreement6 =  commonMapper.findManyData("select * from DNS_ADDR_IP_A where itemid = '"+itemid+"'");	
		ret.put("DXXZSP_DJYZCGLXTCSQKBS", list_agreement1);		
		ret.put("DNS_ADDR_IP_E", list_agreement2);		
		ret.put("DNS_ADDR_IP_D", list_agreement3);		
		ret.put("DNS_ADDR_IP_C", list_agreement4);		
		ret.put("DNS_ADDR_IP_B", list_agreement5);		
		ret.put("DNS_ADDR_IP_A", list_agreement6);				
		return ret;
	}
}

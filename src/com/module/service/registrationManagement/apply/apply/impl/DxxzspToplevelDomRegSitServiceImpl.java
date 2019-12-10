package com.module.service.registrationManagement.apply.apply.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.module.dao.base.CommonMapper;
import com.module.service.common.ItemUserApplyService;
import com.module.service.registrationManagement.apply.apply.DxxzspToplevelDomRegSitService;
import com.util.AppException;

@Service("DxxzspToplevelDomRegSitService")
public class DxxzspToplevelDomRegSitServiceImpl implements DxxzspToplevelDomRegSitService{
	@Resource
	private CommonMapper commonMapper;
	@Resource
	private ItemUserApplyService itemUserApplyService;
	@Override
	public Map<String, Object> getRow(String id, String flowrunid)throws AppException {
		String itemid=itemUserApplyService.getProcessId(id);
		Map<String,Object> ret = new HashMap<String,Object>();
		Map<String,Object> list_ToplevelDomRegSit =  commonMapper.findOneData("select * from DXXZSP_DJYZCGLXTCSQKBS where itemid = '"+itemid+"'");
		if(list_ToplevelDomRegSit != null){
			String ywid = (String) list_ToplevelDomRegSit.get("ID");
			String parentid = (String) list_ToplevelDomRegSit.get("ID");
			List<Map<String,Object>> list_DxxzspDjyzcglxtcsqkbs =  commonMapper.findManyData("select * from DXXZSP_DJYZCGLXTCSQKBS where id = '"+ywid+"'");
			List<Map<String,Object>> list_DnsAddrIpE =  commonMapper.findManyData("select * from DNS_ADDR_IP_E where PARENTID = '"+parentid+"'");
			List<Map<String,Object>> list_DnsAddrIpD =  commonMapper.findManyData("select * from DNS_ADDR_IP_D where PARENTID = '"+parentid+"'");
			List<Map<String,Object>> list_DnsAddrIpC =  commonMapper.findManyData("select * from DNS_ADDR_IP_C where PARENTID = '"+parentid+"'");
			List<Map<String,Object>> list_DnsAddrIpB =  commonMapper.findManyData("select * from DNS_ADDR_IP_B where PARENTID = '"+parentid+"'");
			List<Map<String,Object>> list_DnsAddrIpA =  commonMapper.findManyData("select * from DNS_ADDR_IP_A where PARENTID = '"+parentid+"'");
		ret.put("DXXZSP_DJYZCGLXTCSQKBS", list_DxxzspDjyzcglxtcsqkbs);
		ret.put("DNS_ADDR_IP_E", list_DnsAddrIpE);
		ret.put("DNS_ADDR_IP_D", list_DnsAddrIpD);
		ret.put("DNS_ADDR_IP_C", list_DnsAddrIpC);
		ret.put("DNS_ADDR_IP_B", list_DnsAddrIpB);
		ret.put("DNS_ADDR_IP_A", list_DnsAddrIpA);
		}	
		return ret;
	}
}

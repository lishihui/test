package com.module.service.domainRegistration.apply.apply.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.module.dao.base.CommonMapper;
import com.module.dao.domainRegistration.apply.apply.DxxzspDnsCoinfoMapper;
import com.module.domain.domainRegistration.apply.apply.DxxzspDnsCoinfoWithBLOBs;
import com.module.service.common.ItemUserApplyService;
import com.module.service.domainRegistration.apply.apply.DxxzspEnBasicInformateDomService;
import com.util.AppException;

@Service("DxxzspEnBasicInformateDomService")
public class DxxzspEnBasicInformateDomServiceImpl implements DxxzspEnBasicInformateDomService{
	@Resource
	private CommonMapper commonMapper;
	@Resource
	private DxxzspDnsCoinfoMapper dxxzspDnsCoinfoMapper;
	@Resource
	private ItemUserApplyService itemUserApplyService;
	@Override
	public Map<String, Object> getRow(String id, String flowrunid) throws AppException {
		String itemid=itemUserApplyService.getProcessId(id);
		Map<String,Object> ret = new HashMap<String,Object>();
		Map<String,Object> listagreement =  commonMapper.findOneData("select * from DXXZSP_DNS_COINFO where itemid = '"+itemid+"'");
		if(listagreement != null){
			String ywid = (String) listagreement.get("ID");
			String parentid = (String) listagreement.get("ID");
			List<DxxzspDnsCoinfoWithBLOBs> list_ret = new ArrayList<DxxzspDnsCoinfoWithBLOBs>();
		List<Map<String,Object>> list_DnsCoinfo =  commonMapper.findManyData("select * from DXXZSP_DNS_COINFO where id = '"+ywid+"'");
		List<Map<String,Object>> list_CoTechList =  commonMapper.findManyData("select * from CO_TECH_LIST where parentid = '"+parentid+"'");
		List<Map<String,Object>> list_CoManagerList =  commonMapper.findManyData("select * from CO_MANAGER_LIST where parentid = '"+parentid+"'");
		List<Map<String,Object>> list_ShareholderStru =  commonMapper.findManyData("select * from SHAREHOLDER_STRU where parentid = '"+parentid+"'");
		List<Map<String,Object>> list_TopLlevelDomainRes =  commonMapper.findManyData("select * from TOPLEVEL_DOMAIN_RES where parentid = '"+parentid+"'");
		for(Map<String,Object> tmp : list_DnsCoinfo ){
			DxxzspDnsCoinfoWithBLOBs blob = dxxzspDnsCoinfoMapper.selectByPrimaryKey((String)tmp.get("ID"));
    		list_ret.add(blob);
    	}
		ret.put("DXXZSP_DNS_COINFO", list_ret);
		ret.put("CO_TECH_LIST", list_CoTechList);
		ret.put("CO_MANAGER_LIST", list_CoManagerList);
		ret.put("SHAREHOLDER_STRU", list_ShareholderStru);
		ret.put("TOPLEVEL_DOMAIN_RES", list_TopLlevelDomainRes);
		}		
		return ret;
	}
}

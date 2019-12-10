package com.module.service.domainRegistration.apply.apply.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.module.dao.base.CommonMapper;
import com.module.dao.domainRegistration.apply.apply.DomainInfoMapper;
import com.module.domain.domainRegistration.apply.apply.DomainInfoWithBLOBs;
import com.module.service.common.ItemUserApplyService;
import com.module.service.domainRegistration.apply.apply.DxxzspDomainNameRegistrationAgencyDomService;
import com.util.AppException;

@Service("DxxzspDomainNameRegistrationAgencyDomService")
public class DxxzspDomainNameRegistrationAgencyDomServiceImpl implements DxxzspDomainNameRegistrationAgencyDomService {
	@Resource
	private CommonMapper commonMapper;
	@Resource
	private DomainInfoMapper domainInfoMapper;
	@Resource
	private ItemUserApplyService itemUserApplyService;
	@Override
	public Map<String, Object> getRow(String id, String flowrunid)throws AppException {
		String itemid=itemUserApplyService.getProcessId(id);
		Map<String,Object> ret = new HashMap<String,Object>();
		Map<String,Object> listagreement =  commonMapper.findOneData("select * from DXXZSP_TERRITORY_DOMAIN where itemid = '"+itemid+"'");
		if(listagreement != null){
			String fwid = (String) listagreement.get("ID");
			List<DomainInfoWithBLOBs> list_ret = new ArrayList<DomainInfoWithBLOBs>();
			List<Map<String,Object>> list_TerritoryDomain =  commonMapper.findManyData("select * from DXXZSP_TERRITORY_DOMAIN where id = '"+fwid+"'");
			List<Map<String,Object>> list_DomainInfo =  commonMapper.findManyData("select * from DOMAIN_INFO where id = '"+fwid+"'");
			for(Map<String,Object> tmp : list_DomainInfo ){
				DomainInfoWithBLOBs blob = domainInfoMapper.selectByPrimaryKey((String)tmp.get("ID"));
	    		list_ret.add(blob);
	    	}
			ret.put("DXXZSP_TERRITORY_DOMAIN", list_TerritoryDomain);
			ret.put("DOMAIN_INFO", list_ret);
		}
		return ret;
	}
}

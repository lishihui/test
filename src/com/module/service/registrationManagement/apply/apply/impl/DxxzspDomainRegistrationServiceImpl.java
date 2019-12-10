package com.module.service.registrationManagement.apply.apply.impl;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.module.dao.base.CommonMapper;
import com.module.dao.registrationManagement.apply.apply.DxxzspDomainRegisterMapper;

import com.module.domain.registrationManagement.apply.apply.DxxzspDomainRegisterWithBLOBs;
import com.module.service.common.ItemUserApplyService;
import com.module.service.registrationManagement.apply.apply.DxxzspDomainRegistrationService ;
import com.util.AppException;

@Service("DxxzspDomainRegistrationService" )
public class DxxzspDomainRegistrationServiceImpl implements DxxzspDomainRegistrationService  {
	@Resource
	private CommonMapper commonMapper;
	@Resource
	private DxxzspDomainRegisterMapper dxxzspDomainRegisterMapper;
	@Resource
	private ItemUserApplyService itemUserApplyService;
	@Override
	public Map<String, Object> getRow(String id, String flowrunid)throws AppException {
		String itemid=itemUserApplyService.getProcessId(id);
		Map<String,Object> ret = new HashMap<String,Object>();
		Map<String,Object> list_DomainRegistration =  commonMapper.findOneData("select * from DXXZSP_DOMAIN_REGISTER where itemid = '"+itemid+"'");
		if(list_DomainRegistration != null){
			String ywid = (String) list_DomainRegistration.get("ID");
			String parentid = (String) list_DomainRegistration.get("ID");
			
			List<Map<String,Object>> list_DxxzspDomainRegister =  commonMapper.findManyData("select * from DXXZSP_DOMAIN_REGISTER where id = '"+ywid+"'");
			
			List<DxxzspDomainRegisterWithBLOBs> list_ret = new ArrayList<DxxzspDomainRegisterWithBLOBs>();
			for(Map<String,Object> tmp : list_DxxzspDomainRegister){
				DxxzspDomainRegisterWithBLOBs blob = dxxzspDomainRegisterMapper.selectByPrimaryKey((String)tmp.get("ID"));
				list_ret.add(blob);

	    	}
			
			List<Map<String,Object>> list_OwnershipStructure =  commonMapper.findManyData("select * from OWNERSHIP_STRUCTURE where PARENTID = '"+parentid+"'");	

			ret.put("DXXZSP_DOMAIN_REGISTER", list_ret);
			ret.put("OWNERSHIP_STRUCTURE", list_OwnershipStructure);

		}
		
		return ret;
	}
	
}

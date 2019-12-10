package com.module.service.domainRegistration.apply.apply.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.module.dao.base.CommonMapper;
import com.module.dao.domainRegistration.apply.apply.DxxzspDomainRegPlanMapper;
import com.module.domain.domainRegistration.apply.apply.DxxzspDomainRegPlanWithBLOBs;
import com.module.service.common.ItemUserApplyService;
import com.module.service.domainRegistration.apply.apply.DxxzspRulesforRegistrationDomService;
import com.util.AppException;

@Service("RulesforRegistrationDomService")
public class DxxzspRulesforRegistrationDomServiceImpl implements DxxzspRulesforRegistrationDomService{
	@Resource
	private CommonMapper commonMapper;
	@Resource
	private DxxzspDomainRegPlanMapper dxxzspDomainRegPlanMapper;
	@Resource
	private ItemUserApplyService itemUserApplyService;
	@Override
	public Map<String, Object> getRow(String id, String flowrunid)throws AppException {
		String itemid=itemUserApplyService.getProcessId(id);
		Map<String,Object> ret = new HashMap<String,Object>();
		List<DxxzspDomainRegPlanWithBLOBs> list_ret = new ArrayList<DxxzspDomainRegPlanWithBLOBs>();
		List<Map<String,Object>> list_DomainRegPlan =  commonMapper.findManyData("select * from DXXZSP_DOMAIN_REG_PLAN where itemid = '"+itemid+"'");			
		for(Map<String,Object> tmp : list_DomainRegPlan ){
			DxxzspDomainRegPlanWithBLOBs blob = dxxzspDomainRegPlanMapper.selectByPrimaryKey((String)tmp.get("ID"));
    		list_ret.add(blob);
    	}
		ret.put("DXXZSP_DOMAIN_REG_PLAN", list_ret);					
		return ret;
	}
}

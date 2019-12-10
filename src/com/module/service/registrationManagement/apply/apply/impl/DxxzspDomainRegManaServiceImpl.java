package com.module.service.registrationManagement.apply.apply.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.module.dao.base.CommonMapper;
import com.module.dao.registrationManagement.apply.apply.DxxzspDomainRegSystemMapper;
import com.module.dao.registrationManagement.apply.apply.DxxzspInfoSafetyMapper;
import com.module.domain.registrationManagement.apply.apply.DxxzspDomainRegSystemWithBLOBs;
import com.module.domain.registrationManagement.apply.apply.DxxzspInfoSafetyWithBLOBs;
import com.module.service.common.ItemUserApplyService;
import com.module.service.registrationManagement.apply.apply.DxxzspDomainRegManaService;
import com.util.AppException;

@Service("DxxzspDomainRegManaService")
public class DxxzspDomainRegManaServiceImpl implements DxxzspDomainRegManaService{
	@Resource
	private CommonMapper commonMapper;
	@Resource
	private DxxzspDomainRegSystemMapper dxxzspDomainRegSystemMapper;
	@Resource
	private ItemUserApplyService itemUserApplyService;
	@Override
	public Map<String, Object> getRow(String id, String flowrunid)throws AppException {
		String itemid=itemUserApplyService.getProcessId(id);
		Map<String,Object> ret = new HashMap<String,Object>();
		List<Map<String,Object>> list_DomainRegMana =  commonMapper.findManyData("select * from DXXZSP_DOMAIN_REG_SYSTEM where itemid = '"+itemid+"'");		
		
		
		List<DxxzspDomainRegSystemWithBLOBs> list_ret = new ArrayList<DxxzspDomainRegSystemWithBLOBs>();
		for(Map<String,Object> tmp : list_DomainRegMana){
			DxxzspDomainRegSystemWithBLOBs blob = dxxzspDomainRegSystemMapper.selectByPrimaryKey((String)tmp.get("ID"));
			list_ret.add(blob);
    	}

		
		
		ret.put("DXXZSP_DOMAIN_REG_SYSTEM", list_ret);
			return ret;
				
		
	}
}

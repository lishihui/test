package com.module.service.registrationManagement.apply.apply.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.module.dao.base.CommonMapper;
import com.module.dao.registrationManagement.apply.apply.DxxzspTechnologyImplementationMapper;
import com.module.domain.registrationManagement.apply.apply.DxxzspTechnologyImplementationWithBLOBs;
import com.module.service.common.ItemUserApplyService;
import com.module.service.registrationManagement.apply.apply.DxxzspTechnologyImplementationService;
import com.util.AppException;

@Service("DxxzspTechnologyImplementationService")
public class DxxzspTechnologyImplementationServiceImpl implements DxxzspTechnologyImplementationService {
	@Resource
	private CommonMapper commonMapper;
	@Resource
	private DxxzspTechnologyImplementationMapper dxxzspTechnologyImplementationMapper;
	@Resource
	private ItemUserApplyService itemUserApplyService;
	@Override
	public Map<String, Object> getRow(String id, String flowrunid)throws AppException {
		String itemid=itemUserApplyService.getProcessId(id);
		Map<String,Object> ret = new HashMap<String,Object>();
		List<DxxzspTechnologyImplementationWithBLOBs> list_ret = new ArrayList<DxxzspTechnologyImplementationWithBLOBs>();
		List<Map<String,Object>> list_DxxzspTechnologyImplementation =  commonMapper.findManyData("select * from DXXZSP_TECHNOLOGY_PLAN where itemid = '"+itemid+"'");
		for(Map<String,Object> tmp : list_DxxzspTechnologyImplementation ){
			DxxzspTechnologyImplementationWithBLOBs blob = dxxzspTechnologyImplementationMapper.selectByPrimaryKey((String)tmp.get("ID"));
    		list_ret.add(blob);
    	}
		ret.put("DXXZSP_TECHNOLOGY_PLAN", list_ret);

		return ret;
	}
	
}
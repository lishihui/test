package com.module.service.registrationManagement.change.change.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.module.dao.base.CommonMapper;
import com.module.dao.registrationManagement.change.change.DxxzspSafePlanMapper;
import com.module.domain.registrationManagement.change.change.DxxzspSafePlanWithBLOBs;
import com.module.service.common.ItemUserApplyService;
import com.module.service.registrationManagement.change.change.DxxzspDxxzspSafePlanChaService;
import com.util.AppException;

@Service("DxxzspDxxzspSafePlanChaService")
public class DxxzspDxxzspSafePlanChaServiceImpl implements DxxzspDxxzspSafePlanChaService{
	@Resource
	private CommonMapper commonMapper;
	@Resource
	private DxxzspSafePlanMapper dxxzspSafePlanMapper;
	@Resource
	private ItemUserApplyService itemUserApplyService;
	@Override
	public Map<String, Object> getRow(String id, String flowrunid)throws AppException {
		String itemid=itemUserApplyService.getProcessId(id);
		Map<String,Object> ret = new HashMap<String,Object>();
		List<DxxzspSafePlanWithBLOBs> list_ret = new ArrayList<DxxzspSafePlanWithBLOBs>();
		List<Map<String,Object>> list_SafePlanCha =  commonMapper.findManyData("select * from DXXZSP_SAFE_PLAN where itemid = '"+itemid+"'");		
		for(Map<String,Object> tmp : list_SafePlanCha ){
			DxxzspSafePlanWithBLOBs blob = dxxzspSafePlanMapper.selectByPrimaryKey((String)tmp.get("ID"));
    		list_ret.add(blob);
    	}
		ret.put("DXXZSP_SAFE_PLAN", list_ret);		
		return ret;
	}
}

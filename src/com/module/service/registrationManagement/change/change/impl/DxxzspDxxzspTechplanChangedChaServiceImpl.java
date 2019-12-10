package com.module.service.registrationManagement.change.change.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.module.dao.base.CommonMapper;
import com.module.dao.registrationManagement.change.change.DxxzspTechplanChangedMapper;
import com.module.domain.registrationManagement.change.change.DxxzspTechplanChangedWithBLOBs;
import com.module.service.common.ItemUserApplyService;
import com.module.service.registrationManagement.change.change.DxxzspDxxzspTechplanChangedChaService;
import com.util.AppException;

@Service("DxxzspDxxzspTechplanChangedChaService")
public class DxxzspDxxzspTechplanChangedChaServiceImpl implements DxxzspDxxzspTechplanChangedChaService{
	@Resource
	private CommonMapper commonMapper;
	@Resource
	private DxxzspTechplanChangedMapper dxxzspTechplanChangedMapper;
	@Resource
	private ItemUserApplyService itemUserApplyService;
	@Override
	public Map<String, Object> getRow(String id, String flowrunid)throws AppException {
		String itemid=itemUserApplyService.getProcessId(id);
		Map<String,Object> ret = new HashMap<String,Object>();
		List<DxxzspTechplanChangedWithBLOBs> list_ret = new ArrayList<DxxzspTechplanChangedWithBLOBs>();
		List<Map<String,Object>> list_TechplanChangedCha =  commonMapper.findManyData("select * from DXXZSP_TECHPLAN_CHANGED where itemid = '"+itemid+"'");		
		for(Map<String,Object> tmp : list_TechplanChangedCha ){
			DxxzspTechplanChangedWithBLOBs blob = dxxzspTechplanChangedMapper.selectByPrimaryKey((String)tmp.get("ID"));
    		list_ret.add(blob);
    	}
		ret.put("DXXZSP_TECHPLAN_CHANGED", list_ret);		
		return ret;
	}
}

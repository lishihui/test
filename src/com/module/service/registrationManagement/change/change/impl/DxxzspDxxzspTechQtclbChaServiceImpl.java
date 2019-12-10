package com.module.service.registrationManagement.change.change.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.module.dao.base.CommonMapper;
import com.module.dao.registrationManagement.change.change.DxxzspTechQtclbMapper;
import com.module.domain.registrationManagement.change.change.DxxzspTechQtclbWithBLOBs;
import com.module.service.common.ItemUserApplyService;
import com.module.service.registrationManagement.change.change.DxxzspDxxzspTechQtclbChaService;
import com.util.AppException;

@Service("DxxzspDxxzspTechQtclbChaService")
public class DxxzspDxxzspTechQtclbChaServiceImpl implements DxxzspDxxzspTechQtclbChaService{
	@Resource
	private CommonMapper commonMapper;
	@Resource
	private DxxzspTechQtclbMapper dxxzspTechQtclbMapper;
	@Resource
	private ItemUserApplyService itemUserApplyService;
	@Override
	public Map<String, Object> getRow(String id, String flowrunid)throws AppException {
		String itemid=itemUserApplyService.getProcessId(id);
		Map<String,Object> ret = new HashMap<String,Object>();
		List<DxxzspTechQtclbWithBLOBs> list_ret = new ArrayList<DxxzspTechQtclbWithBLOBs>();
		List<Map<String,Object>> list_TechQtclbCha =  commonMapper.findManyData("select * from DXXZSP_TECH_QTCLB where itemid = '"+itemid+"'");		
		for(Map<String,Object> tmp : list_TechQtclbCha ){
			DxxzspTechQtclbWithBLOBs blob = dxxzspTechQtclbMapper.selectByPrimaryKey((String)tmp.get("ID"));
    		list_ret.add(blob);
    	}
		ret.put("DXXZSP_TECH_QTCLB", list_ret);		
		return ret;
	}
}

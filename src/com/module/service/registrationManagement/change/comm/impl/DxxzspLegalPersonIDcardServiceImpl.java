package com.module.service.registrationManagement.change.comm.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.module.dao.base.CommonMapper;
import com.module.dao.registrationManagement.change.comm.DxxzspTechLegalMapper;
import com.module.domain.registrationManagement.change.comm.DxxzspTechLegalWithBLOBs;
import com.module.service.common.ItemUserApplyService;
import com.module.service.registrationManagement.change.comm.DxxzspLegalPersonIDcardService;
import com.util.AppException;

@Service("DxxzspLegalPersonIDcardService")
public class DxxzspLegalPersonIDcardServiceImpl implements DxxzspLegalPersonIDcardService {
	@Resource
	private CommonMapper commonMapper;
	@Resource
	private DxxzspTechLegalMapper dxxzspTechLegalMapper;
	@Resource
	private ItemUserApplyService itemUserApplyService;
	@Override
	public Map<String, Object> getRow(String id, String flowrunid)throws AppException {
		String itemid=itemUserApplyService.getProcessId(id);
		Map<String,Object> ret = new HashMap<String,Object>();
		List<DxxzspTechLegalWithBLOBs> list_ret = new ArrayList<DxxzspTechLegalWithBLOBs>();
		List<Map<String,Object>> list_TechLegal =  commonMapper.findManyData("select * from DXXZSP_TECH_LEGAL where itemid = '"+itemid+"'");
		for(Map<String,Object> tmp : list_TechLegal ){
			DxxzspTechLegalWithBLOBs blob = dxxzspTechLegalMapper.selectByPrimaryKey((String)tmp.get("ID"));
    		list_ret.add(blob);
    	}
		ret.put("DXXZSP_TECH_LEGAL", list_ret);
		return ret;
	}
}

package com.module.service.registrationManagement.apply.apply.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.module.dao.base.CommonMapper;
import com.module.dao.registrationManagement.apply.apply.DxxzspInfoSafetyMapper;
import com.module.dao.threeWebElectric.change.change.DxxzspRfcBusinesscoverMapper;
import com.module.domain.registrationManagement.apply.apply.DxxzspInfoSafetyWithBLOBs;
import com.module.domain.threeWebElectric.change.change.DxxzspRfcBusinesscoverWithBLOBs;
import com.module.service.common.ItemUserApplyService;
import com.module.service.registrationManagement.apply.apply.DxxzspInformationSafetyService;
import com.util.AppException;

@Service("DxxzspInformationSafetyService")
public class DxxzspInformationSafetyServiceImpl implements DxxzspInformationSafetyService{
	@Resource
	private CommonMapper commonMapper;
	@Resource
	private DxxzspInfoSafetyMapper dxxzspInfoSafetyMapper;
	@Resource
	private ItemUserApplyService itemUserApplyService;
	@Override
	public Map<String, Object> getRow(String id, String flowrunid)throws AppException {
		String itemid=itemUserApplyService.getProcessId(id);
		Map<String,Object> ret = new HashMap<String,Object>();
		List<Map<String,Object>> list_InformationSafety =  commonMapper.findManyData("select * from DXXZSP_INFO_SAFETY where itemid = '"+itemid+"'");	
		List<DxxzspInfoSafetyWithBLOBs> list_ret = new ArrayList<DxxzspInfoSafetyWithBLOBs>();
		for(Map<String,Object> tmp : list_InformationSafety){
			DxxzspInfoSafetyWithBLOBs blob = dxxzspInfoSafetyMapper.selectByPrimaryKey((String)tmp.get("ID"));
			list_ret.add(blob);
    	}

		
		
		ret.put("DXXZSP_INFO_SAFETY", list_ret);
			return ret;
		
	}
}

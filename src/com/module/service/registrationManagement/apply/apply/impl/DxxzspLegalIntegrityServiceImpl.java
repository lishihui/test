package com.module.service.registrationManagement.apply.apply.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.module.dao.base.CommonMapper;
import com.module.dao.registrationManagement.apply.apply.DxxzspLegalIntegrityMapper;
import com.module.domain.registrationManagement.apply.apply.DxxzspLegalIntegrityWithBLOBs;
import com.module.service.common.ItemUserApplyService;
import com.module.service.registrationManagement.apply.apply.DxxzspLegalIntegrityService;
import com.util.AppException;

@Service("DxxzspLegalIntegrityService")
public class DxxzspLegalIntegrityServiceImpl implements DxxzspLegalIntegrityService {
	@Resource
	private CommonMapper commonMapper;
	@Resource
	private DxxzspLegalIntegrityMapper dxxzspLegalIntegrityMapper;
	@Resource
	private ItemUserApplyService itemUserApplyService;
	@Override
	public Map<String, Object> getRow(String id, String flowrunid)throws AppException {
		String itemid=itemUserApplyService.getProcessId(id);
		Map<String,Object> ret = new HashMap<String,Object>();
		List<DxxzspLegalIntegrityWithBLOBs> list_ret = new ArrayList<DxxzspLegalIntegrityWithBLOBs>();
		List<Map<String,Object>> list_DxxzspLegalIntegrity =  commonMapper.findManyData("select * from DXXZSP_DOMAIN_PROMISE where itemid = '"+itemid+"'");
		for(Map<String,Object> tmp : list_DxxzspLegalIntegrity ){
			DxxzspLegalIntegrityWithBLOBs blob = dxxzspLegalIntegrityMapper.selectByPrimaryKey((String)tmp.get("ID"));
    		list_ret.add(blob);
    	}
		ret.put("DXXZSP_DOMAIN_PROMISE", list_ret);
		return ret;
	}
}

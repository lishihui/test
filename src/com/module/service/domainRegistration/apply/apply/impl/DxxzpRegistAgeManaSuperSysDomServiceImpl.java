package com.module.service.domainRegistration.apply.apply.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.module.dao.base.CommonMapper;
import com.module.dao.domainRegistration.apply.apply.DxxzspRegAgencyMapper;
import com.module.domain.domainRegistration.apply.apply.DxxzspRegAgencyWithBLOBs;
import com.module.service.common.ItemUserApplyService;
import com.module.service.domainRegistration.apply.apply.DxxzpRegistAgeManaSuperSysDomService;
import com.util.AppException;

@Service("DxxzpRegistAgeManaSuperSysDomService")
public class DxxzpRegistAgeManaSuperSysDomServiceImpl implements DxxzpRegistAgeManaSuperSysDomService {
	@Resource
	private CommonMapper commonMapper;
	@Resource
	private DxxzspRegAgencyMapper dxxzspRegAgencyMapper;
	@Resource
	private ItemUserApplyService itemUserApplyService;
	@Override
	public Map<String, Object> getRow(String id, String flowrunid)throws AppException {
		String itemid=itemUserApplyService.getProcessId(id);
		Map<String,Object> ret = new HashMap<String,Object>();
		List<DxxzspRegAgencyWithBLOBs> list_ret = new ArrayList<DxxzspRegAgencyWithBLOBs>();
		List<Map<String,Object>> list_RegAgency =  commonMapper.findManyData("select * from DXXZSP_REG_AGENCY where itemid = '"+itemid+"'");
		for(Map<String,Object> tmp : list_RegAgency ){
			DxxzspRegAgencyWithBLOBs blob = dxxzspRegAgencyMapper.selectByPrimaryKey((String)tmp.get("ID"));
    		list_ret.add(blob);
    	}
		ret.put("DXXZSP_REG_AGENCY", list_ret);
		return ret;
	}
}


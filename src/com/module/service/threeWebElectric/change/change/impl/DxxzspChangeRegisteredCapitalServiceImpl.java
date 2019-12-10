package com.module.service.threeWebElectric.change.change.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.module.dao.base.CommonMapper;
import com.module.service.common.ItemUserApplyService;
import com.module.service.threeWebElectric.change.change.DxxzspChangeRegisteredCapitalService;
import com.util.AppException;

@Service("DxxzspChangeRegisteredCapitalService")
public class DxxzspChangeRegisteredCapitalServiceImpl implements DxxzspChangeRegisteredCapitalService {
	@Resource
	private CommonMapper commonMapper;
	@Resource
	private ItemUserApplyService itemUserApplyService;
	@Override
	public Map<String, Object> getRow(String id, String flowrunid)throws AppException {
		String itemid=itemUserApplyService.getProcessId(id);
		Map<String,Object> ret = new HashMap<String,Object>();
		List<Map<String,Object>> list_agreement =  commonMapper.findManyData("select * from DXXZSP_RFC_REGCAP where itemid = '"+itemid+"'");
		ret.put("DXXZSP_RFC_REGCAP", list_agreement);
		return ret;
	}
	
}

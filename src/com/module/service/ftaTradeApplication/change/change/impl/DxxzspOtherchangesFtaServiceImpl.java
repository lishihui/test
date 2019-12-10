package com.module.service.ftaTradeApplication.change.change.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.module.dao.base.CommonMapper;
import com.module.service.common.ItemUserApplyService;
import com.module.service.ftaTradeApplication.change.change.DxxzspOtherchangesFtaService;
import com.util.AppException;

@Service("DxxzspOtherchangesFtaService")
public class DxxzspOtherchangesFtaServiceImpl implements DxxzspOtherchangesFtaService {
	@Resource
	private CommonMapper commonMapper;
	@Resource
	private ItemUserApplyService itemUserApplyService;
	@Override
	public Map<String, Object> getRow(String id, String flowrunid)throws AppException {
		String itemid=itemUserApplyService.getProcessId(id);
		Map<String,Object> ret = new HashMap<String,Object>();
		List<Map<String,Object>> list_agreement =  commonMapper.findManyData("select * from ZMQC_OTHER_MATTER_CHANGES where itemid = '"+itemid+"'");
		ret.put("ZMQC_OTHER_MATTER_CHANGES", list_agreement);
		return ret;
	}
}

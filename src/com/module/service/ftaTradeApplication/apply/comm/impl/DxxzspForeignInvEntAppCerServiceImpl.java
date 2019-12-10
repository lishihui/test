package com.module.service.ftaTradeApplication.apply.comm.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.module.dao.base.CommonMapper;
import com.module.service.common.ItemUserApplyService;
import com.module.service.ftaTradeApplication.apply.comm.DxxzspForeignInvEntAppCerService;
import com.util.AppException;

@Service("DxxzspForeignInvEntAppCerService")
public class DxxzspForeignInvEntAppCerServiceImpl implements DxxzspForeignInvEntAppCerService {
	@Resource
	private CommonMapper commonMapper;
	@Resource
	private ItemUserApplyService itemUserApplyService;
	@Override
	public Map<String, Object> getRow(String id, String flowrunid)throws AppException {
		String itemid=itemUserApplyService.getProcessId(id);
		Map<String,Object> ret = new HashMap<String,Object>();
		List<Map<String,Object>> list_agreement =  commonMapper.findManyData("select * from DXXZSP_ZYMY  where itemid = '"+itemid+"'");
		ret.put("DXXZSP_ZYMY", list_agreement);
		return ret;
	}
}

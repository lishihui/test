package com.module.service.ftaTradeApplication.change.change.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.module.dao.base.CommonMapper;
import com.module.service.common.ItemUserApplyService;
import com.module.service.ftaTradeApplication.change.change.DxxzspReplenishmentOfLostFtaService;
import com.util.AppException;

@Service("DxxzspReplenishmentOfLostFtaService")
public class DxxzspReplenishmentOfLostFtaServiceImpl implements DxxzspReplenishmentOfLostFtaService{
	@Resource
	private CommonMapper commonMapper;
	@Resource
	private ItemUserApplyService itemUserApplyService;
	@Override
	public Map<String, Object> getRow(String id, String flowrunid)throws AppException {
		String itemid=itemUserApplyService.getProcessId(id);
		Map<String,Object> ret = new HashMap<String,Object>();
		List<Map<String,Object>> list_ReplenishmentOfLostFta =  commonMapper.findManyData("select * from ZMQC_LOSS_LICENSE_APPLICA where itemid = '"+itemid+"'");
		ret.put("ZMQC_LOSS_LICENSE_APPLICA", list_ReplenishmentOfLostFta);
		return ret;
	}
}

package com.module.service.ftaTradeApplication.apply.apply.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.module.dao.base.CommonMapper;
import com.module.service.common.ItemUserApplyService;
import com.module.service.ftaTradeApplication.apply.apply.DxxzspInternetVirtualPrivateFtaService;
import com.util.AppException;

@Service("DxxzspInternetVirtualPrivateFtaService")
public class DxxzspInternetVirtualPrivateFtaServiceImpl implements DxxzspInternetVirtualPrivateFtaService{
	@Resource
	private CommonMapper commonMapper;
	@Resource
	private ItemUserApplyService itemUserApplyService;
	@Override
	public Map<String, Object> getRow(String id, String flowrunid)throws AppException {
		String itemid=itemUserApplyService.getProcessId(id);
		Map<String,Object> ret = new HashMap<String,Object>();
		List<Map<String,Object>> list_InternetVirtualPrivateFta =  commonMapper.findManyData("select * from DXXZSP_ZMQ_VIRTUAL_BUSINE where itemid = '"+itemid+"'");
		ret.put("DXXZSP_ZMQ_VIRTUAL_BUSINE", list_InternetVirtualPrivateFta);
		return ret;
	}
}

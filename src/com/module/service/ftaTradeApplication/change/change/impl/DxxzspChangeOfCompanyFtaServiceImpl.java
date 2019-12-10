package com.module.service.ftaTradeApplication.change.change.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.module.dao.base.CommonMapper;
import com.module.service.common.ItemUserApplyService;
import com.module.service.ftaTradeApplication.change.change.DxxzspChangeOfCompanyFtaService;
import com.util.AppException;

@Service("DxxzspChangeOfCompanyFtaService")
public class DxxzspChangeOfCompanyFtaServiceImpl implements DxxzspChangeOfCompanyFtaService{
	@Resource
	private CommonMapper commonMapper;
	@Resource
	private ItemUserApplyService itemUserApplyService;
	@Override
	public Map<String, Object> getRow(String id, String flowrunid)throws AppException {
		String itemid=itemUserApplyService.getProcessId(id);
		Map<String,Object> ret = new HashMap<String,Object>();
		List<Map<String,Object>> list_ChangeOfCompanyFta =  commonMapper.findManyData("select * from ZMQC_COMPANY_CONVERSION where itemid = '"+itemid+"'");
		ret.put("ZMQC_COMPANY_CONVERSION", list_ChangeOfCompanyFta);
		return ret;
	}
}

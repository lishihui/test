package com.module.service.ftaTradeApplication.change.change.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.module.dao.base.CommonMapper;
import com.module.dao.ftaTradeApplication.change.change.ZmqcContinueApplicationMapper;
import com.module.domain.ftaTradeApplication.change.change.ZmqcContinueApplicationWithBLOBs;
import com.module.service.common.ItemUserApplyService;
import com.module.service.ftaTradeApplication.change.change.DxxzspRenewalOfLicenseFtaService;
import com.util.AppException;

@Service("DxxzspRenewalOfLicenseFtaService")
public class DxxzspRenewalOfLicenseFtaServiceImpl implements DxxzspRenewalOfLicenseFtaService{
	@Resource
	private CommonMapper commonMapper;
	@Resource
	private ZmqcContinueApplicationMapper zmqcContinueApplicationMapper;
	@Resource
	private ItemUserApplyService itemUserApplyService;
	@Override
	public Map<String, Object> getRow(String id, String flowrunid)throws AppException {
		String itemid=itemUserApplyService.getProcessId(id);
		Map<String,Object> ret = new HashMap<String,Object>();
		List<ZmqcContinueApplicationWithBLOBs> list_ret = new ArrayList<ZmqcContinueApplicationWithBLOBs>();
		List<Map<String,Object>> list_ZmqcContinueApplication =  commonMapper.findManyData("select * from ZMQC_CONTINUE_APPLICATION where itemid = '"+itemid+"'");
		for(Map<String,Object> tmp : list_ZmqcContinueApplication ){
			ZmqcContinueApplicationWithBLOBs blob = zmqcContinueApplicationMapper.selectByPrimaryKey((String)tmp.get("ID"));
    		list_ret.add(blob);
    	}
		ret.put("ZMQC_CONTINUE_APPLICATION", list_ret);
		return ret;
	}
}

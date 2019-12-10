package com.module.service.ftaTradeApplication.change.change.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.module.dao.base.CommonMapper;
import com.module.dao.ftaTradeApplication.change.change.ZmqcBusinessChangeMapper;
import com.module.domain.ftaTradeApplication.change.change.ZmqcBusinessChangeWithBLOBs;
import com.module.service.common.ItemUserApplyService;
import com.module.service.ftaTradeApplication.change.change.DxxzspChangeOfOperatingSubjectFtaService;
import com.util.AppException;

@Service("DxxzspChangeOfOperatingSubjectFta")
public class DxxzspChangeOfOperatingSubjectFtaServiceImpl implements DxxzspChangeOfOperatingSubjectFtaService {
	@Resource
	private CommonMapper commonMapper;
	@Resource
	private ZmqcBusinessChangeMapper zmqcBusinessChangeMapper;
	@Resource
	private ItemUserApplyService itemUserApplyService;
	@Override
	public Map<String, Object> getRow(String id, String flowrunid)throws AppException {
		String itemid=itemUserApplyService.getProcessId(id);
		Map<String,Object> ret = new HashMap<String,Object>();
		List<ZmqcBusinessChangeWithBLOBs> list_ret = new ArrayList<ZmqcBusinessChangeWithBLOBs>();
		List<Map<String,Object>> list_ZmqcBusinessChange =  commonMapper.findManyData("select * from ZMQC_BUSINESS_CHANGE where itemid = '"+itemid+"'");
		for(Map<String,Object> tmp : list_ZmqcBusinessChange ){
			ZmqcBusinessChangeWithBLOBs blob = zmqcBusinessChangeMapper.selectByPrimaryKey((String)tmp.get("ID"));
    		list_ret.add(blob);
    	}
		ret.put("ZMQC_BUSINESS_CHANGE", list_ret);
		return ret;
	}
}

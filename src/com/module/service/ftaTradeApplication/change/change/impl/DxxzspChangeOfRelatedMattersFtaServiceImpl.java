package com.module.service.ftaTradeApplication.change.change.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.module.dao.base.CommonMapper;
import com.module.dao.ftaTradeApplication.change.change.ZmqcTerminateApplicatioMapper;
import com.module.domain.ftaTradeApplication.change.change.ZmqcTerminateApplicatioWithBLOBs;
import com.module.service.common.ItemUserApplyService;
import com.module.service.ftaTradeApplication.change.change.DxxzspChangeOfRelatedMattersFtaService;
import com.util.AppException;

@Service("DxxzspChangeOfRelatedMattersFtaService")
public class DxxzspChangeOfRelatedMattersFtaServiceImpl implements DxxzspChangeOfRelatedMattersFtaService{
	@Resource
	private CommonMapper commonMapper;
	@Resource
	private ZmqcTerminateApplicatioMapper zmqcTerminateApplicatioMapper;
	@Resource
	private ItemUserApplyService itemUserApplyService;
	@Override
	public Map<String, Object> getRow(String id, String flowrunid)throws AppException {
		String itemid=itemUserApplyService.getProcessId(id);
		Map<String,Object> ret = new HashMap<String,Object>();
		List<ZmqcTerminateApplicatioWithBLOBs> list_ret = new ArrayList<ZmqcTerminateApplicatioWithBLOBs>();
		List<Map<String,Object>> list_ZmqcTerminateApplicatio =  commonMapper.findManyData("select * from ZMQC_TERMINATE_APPLICATIO where itemid = '"+itemid+"'");
		for(Map<String,Object> tmp : list_ZmqcTerminateApplicatio ){
			ZmqcTerminateApplicatioWithBLOBs blob = zmqcTerminateApplicatioMapper.selectByPrimaryKey((String)tmp.get("ID"));
    		list_ret.add(blob);
    	}
		ret.put("ZMQC_TERMINATE_APPLICATIO", list_ret);
		return ret;
	}
}

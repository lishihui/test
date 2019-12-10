package com.module.service.ftaTradeApplication.apply.comm.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.module.dao.base.CommonMapper;
import com.module.dao.ftaTradeApplication.apply.comm.DxxzspZmqKqyxksqggbMapper;
import com.module.domain.ftaTradeApplication.apply.comm.DxxzspZmqKqyxksqggbWithBLOBs;
import com.module.service.common.ItemUserApplyService;
import com.module.service.ftaTradeApplication.apply.comm.DxxzspInformatSecurityMeasuresFtaService;
import com.util.AppException;

@Service("DxxzspInformatSecurityMeasuresFtaService")
public class DxxzspInformatSecurityMeasuresFtaServiceImpl implements DxxzspInformatSecurityMeasuresFtaService {
	@Resource
	private CommonMapper commonMapper;
	@Resource
	private DxxzspZmqKqyxksqggbMapper dxxzspZmqKqyxksqggbMapper;
	@Resource
	private ItemUserApplyService itemUserApplyService;
	@Override
	public Map<String, Object> getRow(String id, String flowrunid)throws AppException {
		String itemid=itemUserApplyService.getProcessId(id);
		Map<String,Object> ret = new HashMap<String,Object>();
		List<DxxzspZmqKqyxksqggbWithBLOBs> list_ret = new ArrayList<DxxzspZmqKqyxksqggbWithBLOBs>();
		List<Map<String,Object>> list_ZmqKqyxksqggb =  commonMapper.findManyData("select * from DXXZSP_ZMQ_KQYXKSQGGB where itemid = '"+itemid+"'");
		for(Map<String,Object> tmp : list_ZmqKqyxksqggb ){
			DxxzspZmqKqyxksqggbWithBLOBs blob = dxxzspZmqKqyxksqggbMapper.selectByPrimaryKey((String)tmp.get("ID"));
    		list_ret.add(blob);
    	}
		ret.put("DXXZSP_ZMQ_KQYXKSQGGB", list_ret);
		return ret;
	}
	
}
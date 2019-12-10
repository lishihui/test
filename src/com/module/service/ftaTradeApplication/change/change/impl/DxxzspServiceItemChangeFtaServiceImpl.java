package com.module.service.ftaTradeApplication.change.change.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.module.dao.base.CommonMapper;
import com.module.dao.ftaTradeApplication.change.change.DxxzspZmqcServiceProjectChanMapper;
import com.module.domain.ftaTradeApplication.change.change.DxxzspZmqcServiceProjectChanWithBLOBs;
import com.module.service.common.ItemUserApplyService;
import com.module.service.ftaTradeApplication.change.change.DxxzspServiceItemChangeFtaService;
import com.util.AppException;

@Service("DxxzspServiceItemChangeFtaService")
public class DxxzspServiceItemChangeFtaServiceImpl implements DxxzspServiceItemChangeFtaService {
	@Resource
	private CommonMapper commonMapper;
	@Resource
	private ItemUserApplyService itemUserApplyService;
	@Resource
	private DxxzspZmqcServiceProjectChanMapper dxxzspZmqcServiceProjectChanMapper;
	@Override
	public Map<String, Object> getRow(String id, String flowrunid)throws AppException {
		String itemid=itemUserApplyService.getProcessId(id);
		Map<String,Object> ret = new HashMap<String,Object>();
		Map<String,Object> list_ServiceItemChangeFta=  commonMapper.findOneData("select * from ZMQC_SERVICE_PROJECT_CHAN where itemid = '"+itemid+"'");
		if(list_ServiceItemChangeFta != null){
			String ywid = (String) list_ServiceItemChangeFta.get("ID");
			List<DxxzspZmqcServiceProjectChanWithBLOBs> list_ret = new ArrayList<DxxzspZmqcServiceProjectChanWithBLOBs>();
			List<Map<String,Object>> list_ZmqcServiceProjectChan =  commonMapper.findManyData("select * from ZMQC_SERVICE_PROJECT_CHAN where id = '"+ywid+"'");
			for(Map<String,Object> tmp : list_ZmqcServiceProjectChan ){
				DxxzspZmqcServiceProjectChanWithBLOBs blob = dxxzspZmqcServiceProjectChanMapper.selectByPrimaryKey((String)tmp.get("ID"));
	    		list_ret.add(blob);
	    	}
			ret.put("ZMQC_SERVICE_PROJECT_CHAN", list_ret);
		}
		return ret;
	}
	
}
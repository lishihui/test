package com.module.service.ftaTradeApplication.apply.apply.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.module.dao.base.CommonMapper;
import com.module.service.common.ItemUserApplyService;
import com.module.service.ftaTradeApplication.apply.apply.DxxzspInforServInterFreeFtaService;
import com.util.AppException;

@Service("DxxzspInforServInterFreeFtaService")
public class DxxzspInforServInterFreeFtaServiceImpl implements DxxzspInforServInterFreeFtaService{
	@Resource
	private CommonMapper commonMapper;
	@Resource
	private ItemUserApplyService  itemUserApplyService;
	@Override
	public Map<String, Object> getRow(String id, String flowrunid)throws AppException {
		String itemid=itemUserApplyService.getProcessId(id);
		Map<String,Object> ret = new HashMap<String,Object>();
		Map<String,Object> list_InforServInterFreeFta =  commonMapper.findOneData("select * from DXXZSP_ZMQ_BHHLWXXFWYWZYB where itemid = '"+itemid+"'");
		if(list_InforServInterFreeFta != null){
			String ywid = (String) list_InforServInterFreeFta.get("ID");
			String parentid = (String) list_InforServInterFreeFta.get("ID");
			List<Map<String,Object>> list_DxxzspZmqBhhlwxxfwywzyb =  commonMapper.findManyData("select * from DXXZSP_ZMQ_BHHLWXXFWYWZYB where id = '"+ywid+"'");
			List<Map<String,Object>> list_DevelopSituation =  commonMapper.findManyData("select * from DEVELOP_SITUATION where PARENTID = '"+parentid+"'");
		ret.put("DXXZSP_ZMQ_BHHLWXXFWYWZYB", list_DxxzspZmqBhhlwxxfwywzyb);
		ret.put("DEVELOP_SITUATION", list_DevelopSituation);
		}	
		return ret;
	}
}

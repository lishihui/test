package com.module.service.domainRegistration.change.change.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.module.dao.base.CommonMapper;
import com.module.dao.domainRegistration.change.change.RservicefwchangeMapper;
import com.module.domain.domainRegistration.change.change.RservicefwchangeWithBLOBs;
import com.module.service.common.ItemUserApplyService;
import com.module.service.domainRegistration.change.change.DxxzspRangeRealmChangeChaTowService;
import com.util.AppException;

@Service("DxxzspRangeRealmChangeChaTowService")
public class DxxzspRangeRealmChangeChaTowServiceImpl implements DxxzspRangeRealmChangeChaTowService {
	@Resource
	private CommonMapper commonMapper;
	@Resource
	private RservicefwchangeMapper rservicefwchangeMapper;
	@Resource
	private ItemUserApplyService itemUserApplyService;
	@Override
	public Map<String, Object> getRow(String id, String flowrunid)throws AppException {
		String  itemid=itemUserApplyService.getProcessId(id);
		Map<String,Object> ret = new HashMap<String,Object>();
		Map<String,Object> listagreement =  commonMapper.findOneData("select * from RSERVICEFWCHANGE where itemid = '"+itemid+"'");
		if(listagreement != null){
			String ywid = (String) listagreement.get("ID");
			String parentid = (String) listagreement.get("ID");
			List<RservicefwchangeWithBLOBs> list_ret = new ArrayList<RservicefwchangeWithBLOBs>();
			List<Map<String,Object>> list_Rservicefwchange =  commonMapper.findManyData("select * from RSERVICEFWCHANGE where id = '"+ywid+"'");
			List<Map<String,Object>> list_DoSerBusChange =  commonMapper.findManyData("select * from DXXZSP_DO_SER_BUS_CHANGE where parentid = '"+parentid+"'");
			for(Map<String,Object> tmp : list_Rservicefwchange ){
				RservicefwchangeWithBLOBs blob = rservicefwchangeMapper.selectByPrimaryKey((String)tmp.get("ID"));
	    		list_ret.add(blob);
	    	}
			ret.put("RSERVICEFWCHANGE", list_ret);
			ret.put("DXXZSP_DO_SER_BUS_CHANGE", list_DoSerBusChange);
		}
		return ret;
	}
}

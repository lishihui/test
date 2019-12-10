package com.module.service.registrationManagement.apply.apply.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.module.dao.base.CommonMapper;
import com.module.service.common.ItemUserApplyService;
import com.module.service.registrationManagement.apply.apply.DxxzspApplyService;
import com.util.AppException;

@Service("DxxzspApplyService")
public class DxxzspApplyServiceImpl implements DxxzspApplyService{
	@Resource
	private CommonMapper commonMapper;
	@Resource
	private ItemUserApplyService itemUserApplyService;
	@Override
	public Map<String, Object> getRow(String id, String flowrunid)throws AppException {
		String itemid=itemUserApplyService.getProcessId(id);
		Map<String,Object> ret = new HashMap<String,Object>();
		Map<String,Object> list_Apply =  commonMapper.findOneData("select * from DXXZSP_TOPLEVEL_DOMAIN where itemid = '"+itemid+"'");
		if(list_Apply != null){
			String ywid = (String) list_Apply.get("ID");
			String parentid = (String) list_Apply.get("ID");
			List<Map<String,Object>> list_DxxzspToplevelDomain =  commonMapper.findManyData("select * from DXXZSP_TOPLEVEL_DOMAIN where id = '"+ywid+"'");
			List<Map<String,Object>> list_ApplyTopDns =  commonMapper.findManyData("select * from APPLY_TOP_DNS where PARENTID = '"+parentid+"'");
		ret.put("DXXZSP_TOPLEVEL_DOMAIN", list_DxxzspToplevelDomain);
		ret.put("APPLY_TOP_DNS", list_ApplyTopDns);
		}	
		return ret;
	}
}

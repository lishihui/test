package com.module.service.registrationManagement.change.change.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.module.dao.base.CommonMapper;
import com.module.service.common.ItemUserApplyService;
import com.module.service.registrationManagement.change.change.DxxzspDjymglxgxylistChaService;
import com.util.AppException;

@Service("DxxzspDjymglxgxylistChaService")
public class DxxzspDjymglxgxylistChaServiceImpl implements DxxzspDjymglxgxylistChaService{
	@Resource
	private CommonMapper commonMapper;
	@Resource
	private ItemUserApplyService itemUserApplyService;
	@Override
	public Map<String, Object> getRow(String id, String flowrunid)throws AppException {
		String itemid=itemUserApplyService.getProcessId(id);
		Map<String,Object> ret = new HashMap<String,Object>();
		Map<String,Object> listagreement =  commonMapper.findOneData("select * from DJYMGLXGXYLIST where itemid = '"+itemid+"'");
		if(listagreement != null){
			String ywid = (String) listagreement.get("ID");
			String parentid = (String) listagreement.get("ID");
			List<Map<String,Object>> list_agreement =  commonMapper.findManyData("select * from DJYMGLXGXYLIST where id = '"+ywid+"'");
			List<Map<String,Object>> list_agreement1 =  commonMapper.findManyData("select * from VERIFICATION_SYSTEM where PARENTID = '"+parentid+"'");	
			List<Map<String,Object>> list_agreement2 =  commonMapper.findManyData("select * from EMERGENCY_HOST_ZONG where PARENTID = '"+parentid+"'");
			List<Map<String,Object>> list_agreement3 =  commonMapper.findManyData("select * from REGISTER_DATA_HOST where PARENTID = '"+parentid+"'");
			List<Map<String,Object>> list_agreement4 =  commonMapper.findManyData("select * from SYSTEM_BUILD where PARENTID = '"+parentid+"'");
			List<Map<String,Object>> list_agreement5 =  commonMapper.findManyData("select * from OFFICE_ADDRESS where PARENTID = '"+parentid+"'");
			List<Map<String,Object>> list_agreement6 =  commonMapper.findManyData("select * from SYSTEM_CONSTRUCTION where PARENTID = '"+parentid+"'");
			List<Map<String,Object>> list_agreement7 =  commonMapper.findManyData("select * from EXCLUSIVE_AGREEMENT where PARENTID = '"+parentid+"'");
		ret.put("DJYMGLXGXYLIST", list_agreement);
		ret.put("VERIFICATION_SYSTEM", list_agreement1);
		ret.put("EMERGENCY_HOST_ZONG", list_agreement2);
		ret.put("REGISTER_DATA_HOST", list_agreement3);
		ret.put("SYSTEM_BUILD", list_agreement4);
		ret.put("OFFICE_ADDRESS", list_agreement5);
		ret.put("SYSTEM_CONSTRUCTION", list_agreement6);
		ret.put("EXCLUSIVE_AGREEMENT", list_agreement7);
		}	
		return ret;
	}
}

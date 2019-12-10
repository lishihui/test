package com.module.service.domainRegistration.change.change.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.module.dao.base.CommonMapper;
import com.module.service.common.ItemUserApplyService;
import com.module.service.domainRegistration.change.change.DxxzspCompanyRealmChangeService;
import com.util.AppException;

@Service("DxxzspCompanyRealmChangeService")
public class DxxzspCompanyRealmChangeServiceImpl implements DxxzspCompanyRealmChangeService {
	@Resource
	private CommonMapper commonMapper;
	@Resource
	private ItemUserApplyService itemUserApplyService;
	@Override
	public Map<String, Object> getRow(String id, String flowrunid)throws AppException {
		String  itemid=itemUserApplyService.getProcessId(id);
		Map<String,Object> ret = new HashMap<String,Object>();
		Map<String,Object> listagreement =  commonMapper.findOneData("select * from DXXZSP_AGENCY_NAME where itemid = '"+itemid+"'");
		if(listagreement != null){
			String ywid = (String) listagreement.get("ID");
			List<Map<String,Object>> list_agencyName =  commonMapper.findManyData("select * from DXXZSP_AGENCY_NAME where id = '"+ywid+"'");
			ret.put("DXXZSP_AGENCY_NAME", list_agencyName);
		}
		return ret;
	}
	
}

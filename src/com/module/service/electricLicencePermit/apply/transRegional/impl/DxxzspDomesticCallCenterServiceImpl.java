package com.module.service.electricLicencePermit.apply.transRegional.impl;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.module.dao.base.CommonMapper;
import com.module.service.common.ItemUserApplyService;
import com.module.service.electricLicencePermit.apply.transRegional.DxxzspDomesticCallCenterService;
import com.util.AppException;

@Service("DxxzspDomesticCallCenterService")
public class DxxzspDomesticCallCenterServiceImpl implements DxxzspDomesticCallCenterService {
	@Resource
	private CommonMapper commonMapper;
	@Resource
	private ItemUserApplyService itemUserApplyService;
	@Override
	public Map<String, Object> getRow(String id, String flowrunid)throws AppException {
		String itemid= itemUserApplyService.getProcessId(id);
		Map<String,Object> ret = new HashMap<String,Object>();
		Map<String,Object> listagreement =  commonMapper.findOneData("select * from DXXZSP_CALLCENTER where itemid = '"+itemid+"'");
		if(listagreement !=null){
			String ywid = (String) listagreement.get("ID");
			String parentid = (String) listagreement.get("ID");
			List<Map<String,Object>> list_agreement =  commonMapper.findManyData("select * from DXXZSP_CALLCENTER where id = '"+ywid+"'");
			List<Map<String,Object>> list_agreement1 =  commonMapper.findManyData("select * from DXXZSP_CCITYDT where parentid = '"+parentid+"'");
			ret.put("DXXZSP_CALLCENTER", list_agreement);
			ret.put("DXXZSP_CCITYDT", list_agreement1);
		}
		
		return ret;
	}
	
}

package com.module.service.electricLicencePermit.apply.provinceInner.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.module.dao.base.CommonMapper;
import com.module.service.common.ItemUserApplyService;
import com.module.service.electricLicencePermit.apply.provinceInner.DxxzspDomesticCallCenterProService;
import com.util.AppException;

@Service("DxxzspDomesticCallCenterService1")
public class DxxzspDomesticCallCenterProServiceImpl implements DxxzspDomesticCallCenterProService {
	@Resource
	private CommonMapper commonMapper;
	@Resource
	private ItemUserApplyService itemUserApplyService;
	@Override
	public Map<String, Object> getRow(String id, String flowrunid)throws AppException {
		String itemid= itemUserApplyService.getProcessId(id);
		Map<String,Object> ret = new HashMap<String,Object>();
		Map<String,Object> list_DomesticCallCenter =  commonMapper.findOneData("select * from DXXZSP_CALLCENTER where itemid = '"+itemid+"'");
		if(list_DomesticCallCenter != null){
			String ywid = (String) list_DomesticCallCenter.get("ID");
			String parentid = (String) list_DomesticCallCenter.get("ID");
			List<Map<String,Object>> list_DxxzspCallcenter =  commonMapper.findManyData("select * from DXXZSP_CALLCENTER where id = '"+ywid+"'");
			List<Map<String,Object>> list_DxxzspCcitydt =  commonMapper.findManyData("select * from DXXZSP_CCITYDT where PARENTID = '"+parentid+"'");
		
			ret.put("DXXZSP_CALLCENTER", list_DxxzspCallcenter);
			ret.put("DXXZSP_CCITYDT", list_DxxzspCcitydt);
		}
		
		return ret;
	}
	
}

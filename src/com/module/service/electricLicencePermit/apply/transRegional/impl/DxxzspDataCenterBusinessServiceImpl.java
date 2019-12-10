package com.module.service.electricLicencePermit.apply.transRegional.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.module.dao.base.CommonMapper;
import com.module.service.common.ItemUserApplyService;
import com.module.service.electricLicencePermit.apply.transRegional.DxxzspDataCenterBusinessService;
import com.util.AppException;

@Service("DxxzspDataCenterBusinessService")
public class DxxzspDataCenterBusinessServiceImpl implements DxxzspDataCenterBusinessService {
	@Resource
	private CommonMapper commonMapper;
	@Resource
	private ItemUserApplyService itemUserApplyService;
	@Override
	public Map<String, Object> getRow(String id, String flowrunid)throws AppException {
		String itemid= itemUserApplyService.getProcessId(id);
		Map<String,Object> ret = new HashMap<String,Object>();
		Map<String,Object> listagreement =  commonMapper.findOneData("select * from INTERNET_DATA where itemid = '"+itemid+"'");
		if(listagreement != null){
			String ywid = (String) listagreement.get("ID");
			String parentid = (String) listagreement.get("ID");
			List<Map<String,Object>> list_agreement =  commonMapper.findManyData("select * from INTERNET_DATA where id = '"+ywid+"'");
			List<Map<String,Object>> list_agreement1 =  commonMapper.findManyData("select * from DXXZSP_IDC_CITY_YWFW where PARENTID = '"+parentid+"'");
			List<Map<String,Object>> list_agreement2 =  commonMapper.findManyData("select * from DXXZSP_IDC_CITY_NOT_YWFW where PARENTID = '"+parentid+"'");
			
		ret.put("INTERNET_DATA", list_agreement);
		ret.put("DXXZSP_IDC_CITY_YWFW", list_agreement1);
		ret.put("DXXZSP_IDC_CITY_NOT_YWFW", list_agreement2);
		}
		return ret;
	}
	
}

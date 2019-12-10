package com.module.service.electricLicencePermit.apply.transRegional.impl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.module.dao.base.CommonMapper;
import com.module.service.common.ItemUserApplyService;
import com.module.service.electricLicencePermit.apply.transRegional.DxxzspInformationServiceOnlyInternetService;
import com.util.AppException;

@Service("DxxzspInformationServiceOnlyInternetService")
public class DxxzspInformationServiceOnlyInternetServiceImpl implements DxxzspInformationServiceOnlyInternetService {
	@Resource
	private CommonMapper commonMapper;
	@Resource
	private ItemUserApplyService itemUserApplyService;
	@Override
	public Map<String, Object> getRow(String id, String flowrunid)throws AppException {
		String itemid= itemUserApplyService.getProcessId(id);
		Map<String,Object> ret = new HashMap<String,Object>();
		Map<String,Object> listagreement =  commonMapper.findOneData("select * from DXXZSP_HLWXXFW where itemid = '"+itemid+"'");
		if(listagreement !=null){
			String ywid = (String) listagreement.get("ID");
			String parentid = (String) listagreement.get("ID");
			List<Map<String,Object>> list_agreement =  commonMapper.findManyData("select * from DXXZSP_HLWXXFW where id = '"+ywid+"'");
			List<Map<String,Object>> list_agreement1 =  commonMapper.findManyData("select * from DXXZSP_XXJXYWAPPDTBG where parentid = '"+parentid+"'");
			List<Map<String,Object>> list_agreement2 =  commonMapper.findManyData("select * from DXXZSP_XXJXWZDTBG where parentid = '"+parentid+"'");
			ret.put("DXXZSP_HLWXXFW", list_agreement);
			ret.put("DXXZSP_XXJXYWAPPDTBG", list_agreement1);
			ret.put("DXXZSP_XXJXWZDTBG", list_agreement2);
		}
		return ret;
	}
	
}
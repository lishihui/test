package com.module.service.electricLicencePermit.apply.provinceInner.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.module.dao.base.CommonMapper;
import com.module.service.common.ItemUserApplyService;
import com.module.service.electricLicencePermit.apply.provinceInner.DxxzspDataProcessingAndTransactionProService;
import com.util.AppException;

@Service("DxxzspDataProcessingAndTransactionProService")
public class DxxzspDataProcessingAndTransactionProServiceImpl  implements DxxzspDataProcessingAndTransactionProService {
	@Resource
	private CommonMapper commonMapper;
	@Resource
	private ItemUserApplyService itemUserApplyService;
	@Override
	public Map<String, Object> getRow(String id, String flowrunid)throws AppException {
		String itemid= itemUserApplyService.getProcessId(id);
		Map<String,Object> ret = new HashMap<String,Object>();
		Map<String,Object> listagreement =  commonMapper.findOneData("select * from ONLINE_DATA_PROCESS where itemid = '"+itemid+"'");
		if(listagreement != null){
			String ywid = (String) listagreement.get("ID");
			String parentid = (String) listagreement.get("ID");
		List<Map<String,Object>> list_agreement1 =  commonMapper.findManyData("select * from ONLINE_DATA_PROCESS where id = '"+ywid+"'");
		List<Map<String,Object>> list_agreement2 =  commonMapper.findManyData("select * from DXXZSP_ZXSJCLYWAPPDTBG where parentid = '"+parentid+"'");
		ret.put("ONLINE_DATA_PROCESS", list_agreement1);
		ret.put("DXXZSP_ZXSJCLYWAPPDTBG", list_agreement2);
		}	
		return ret;
	}
}

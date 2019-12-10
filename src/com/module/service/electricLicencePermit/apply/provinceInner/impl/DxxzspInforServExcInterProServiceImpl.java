package com.module.service.electricLicencePermit.apply.provinceInner.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.module.dao.base.CommonMapper;
import com.module.service.common.ItemUserApplyService;
import com.module.service.electricLicencePermit.apply.provinceInner.DxxzspInforServExcInterProService;
import com.util.AppException;

@Service("DxxzspInforServExcInterProService")
public class DxxzspInforServExcInterProServiceImpl implements DxxzspInforServExcInterProService {
	@Resource
	private CommonMapper commonMapper;
	@Resource
	private ItemUserApplyService itemUserApplyService;
	@Override
	public Map<String, Object> getRow(String id, String flowrunid)throws AppException {
		String itemid= itemUserApplyService.getProcessId(id);
		Map<String,Object> ret = new HashMap<String,Object>();
		Map<String,Object> list_InforServExcInter =  commonMapper.findOneData("select * from INFORMATION_SERVICE where itemid = '"+itemid+"'");
		if(list_InforServExcInter != null){
			String ywid = (String) list_InforServExcInter.get("ID");
			String parentid = (String) list_InforServExcInter.get("ID");
			List<Map<String,Object>> list_InformationService =  commonMapper.findManyData("select * from INFORMATION_SERVICE where id = '"+ywid+"'");
			List<Map<String,Object>> list_DevelopSituation =  commonMapper.findManyData("select * from DEVELOP_SITUATION where PARENTID = '"+parentid+"'");
			
			ret.put("INFORMATION_SERVICE", list_InformationService);
			ret.put("DEVELOP_SITUATION", list_DevelopSituation);
			
		}
		
		
		return ret;
	}
}

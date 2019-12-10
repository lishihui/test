package com.module.service.electricLicencePermit.apply.provinceInner.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.module.dao.base.CommonMapper;
import com.module.service.common.ItemUserApplyService;
import com.module.service.electricLicencePermit.apply.provinceInner.DxxzspInforServInterOnlyProService;
import com.util.AppException;

@Service("DxxzspInforServInterOnlyService")
public class DxxzspInforServInterOnlyProServiceImpl implements DxxzspInforServInterOnlyProService{
	@Resource
	private CommonMapper commonMapper;
	@Resource
	private ItemUserApplyService itemUserApplyService;
	@Override
	public Map<String, Object> getRow(String id, String flowrunid)throws AppException {
		String itemid= itemUserApplyService.getProcessId(id);
		Map<String,Object> ret = new HashMap<String,Object>();
		Map<String,Object> list_InforServInterOnly =  commonMapper.findOneData("select * from DXXZSP_HLWXXFW where itemid = '"+itemid+"'");
		if(list_InforServInterOnly != null){
			String ywid = (String) list_InforServInterOnly.get("ID");
			String parentid = (String) list_InforServInterOnly.get("ID");
			List<Map<String,Object>> list_DxxzspHlwxxfw =  commonMapper.findManyData("select * from DXXZSP_HLWXXFW where id = '"+ywid+"'");
			List<Map<String,Object>> list_DxxzspXxjxywappdtbg =  commonMapper.findManyData("select * from DXXZSP_XXJXYWAPPDTBG where PARENTID = '"+parentid+"'");
			List<Map<String,Object>> list_DxxzspXxjxwzdTBGtbg =  commonMapper.findManyData("select * from DXXZSP_XXJXWZDTBG where PARENTID = '"+parentid+"'");
			ret.put("DXXZSP_HLWXXFW", list_DxxzspHlwxxfw);
			ret.put("DXXZSP_XXJXYWAPPDTBG", list_DxxzspXxjxywappdtbg);
			ret.put("DXXZSP_XXJXWZDTBG", list_DxxzspXxjxwzdTBGtbg);
		}
		return ret;
	}
}

package com.module.service.electricLicencePermit.apply.provinceInner.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.module.dao.base.CommonMapper;
import com.module.service.common.ItemUserApplyService;
import com.module.service.electricLicencePermit.apply.provinceInner.DxxzspContentDistrNetProService;
import com.util.AppException;

@Service("DxxzspContentDistrNetService")
public class DxxzspContentDistrNetProServiceImpl implements DxxzspContentDistrNetProService{
	@Resource
	private CommonMapper commonMapper;
	@Resource
	private ItemUserApplyService itemUserApplyService;
	@Override
	public Map<String, Object> getRow(String id, String flowrunid)throws AppException {
		String itemid= itemUserApplyService.getProcessId(id);
		Map<String,Object> ret = new HashMap<String,Object>();
		Map<String,Object> list_ContentDistrNet =  commonMapper.findOneData("select * from CONTENT_DISTRIBUTION where itemid = '"+itemid+"'");
		if(list_ContentDistrNet != null){
			String ywid = (String) list_ContentDistrNet.get("ID");
			String parentid = (String) list_ContentDistrNet.get("ID");
			List<Map<String,Object>> list_ContentDistribution =  commonMapper.findManyData("select * from CONTENT_DISTRIBUTION where id = '"+ywid+"'");
			List<Map<String,Object>> list_DxxzspCdnCityYwfw =  commonMapper.findManyData("select * from DXXZSP_CDN_CITY_YWFW where PARENTID = '"+parentid+"'");
			ret.put("CONTENT_DISTRIBUTION", list_ContentDistribution);
			ret.put("DXXZSP_CDN_CITY_YWFW", list_DxxzspCdnCityYwfw);
		}
		return ret;	
	}
}

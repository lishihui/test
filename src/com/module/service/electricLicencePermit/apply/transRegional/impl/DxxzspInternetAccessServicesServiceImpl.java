package com.module.service.electricLicencePermit.apply.transRegional.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.module.dao.base.CommonMapper;
import com.module.service.common.ItemUserApplyService;
import com.module.service.electricLicencePermit.apply.transRegional.DxxzspInternetAccessServicesService;
import com.util.AppException;

@Service("DxxzspInternetAccessServicesService")
public class DxxzspInternetAccessServicesServiceImpl implements DxxzspInternetAccessServicesService{
	@Resource
	private CommonMapper commonMapper;
	@Resource
	private ItemUserApplyService itemUserApplyService;
	@Override
	public Map<String, Object> getRow(String id, String flowrunid) throws AppException {
		String itemid= itemUserApplyService.getProcessId(id);
		Map<String,Object> ret = new HashMap<String,Object>();
		Map<String,Object> list_InternetAccessServices =  commonMapper.findOneData("select * from INTERNET_ACCESS_SERVICE where itemid = '"+itemid+"'");
		if(list_InternetAccessServices != null){
			String ywid = (String) list_InternetAccessServices.get("ID");
			String parentid = (String) list_InternetAccessServices.get("ID");
		List<Map<String,Object>> list_InternetAccessService =  commonMapper.findManyData("select * from INTERNET_ACCESS_SERVICE where id = '"+ywid+"'");
		List<Map<String,Object>> list_DxxzspIspPlatformYwfw =  commonMapper.findManyData("select * from DXXZSP_ISP_PLATFORM_YWFW where parentid = '"+parentid+"'");
		List<Map<String,Object>> list_DxxzspIspUserYwfw =  commonMapper.findManyData("select * from DXXZSP_ISP_USER_YWFW where parentid = '"+parentid+"'");
		ret.put("INTERNET_ACCESS_SERVICE", list_InternetAccessService);
		ret.put("DXXZSP_ISP_PLATFORM_YWFW", list_DxxzspIspPlatformYwfw);
		ret.put("DXXZSP_ISP_USER_YWFW", list_DxxzspIspUserYwfw);
				}		
		return ret;
	}
}

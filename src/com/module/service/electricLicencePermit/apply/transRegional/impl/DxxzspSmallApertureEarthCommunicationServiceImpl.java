package com.module.service.electricLicencePermit.apply.transRegional.impl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.module.dao.base.CommonMapper;
import com.module.service.common.ItemUserApplyService;
import com.module.service.electricLicencePermit.apply.transRegional.DxxzspSmallApertureEarthCommunicationService;
import com.util.AppException;

@Service("DxxzspSmallApertureEarthCommunicationService")
public class DxxzspSmallApertureEarthCommunicationServiceImpl implements DxxzspSmallApertureEarthCommunicationService {
	@Resource
	private CommonMapper commonMapper;
	@Resource
	private ItemUserApplyService itemUserApplyService;
	@Override
	public Map<String, Object> getRow(String id, String flowrunid)throws AppException {
		String itemid= itemUserApplyService.getProcessId(id);
		Map<String,Object> ret = new HashMap<String,Object>();
		List<Map<String,Object>> list_SmallAperEarComm =  commonMapper.findManyData("select * from DXXZSP_DOMESTIC_SMALL where itemid = '"+itemid+"'");
		ret.put("DOMESTIC_SMALL", list_SmallAperEarComm);
		return ret;
	}
	
}
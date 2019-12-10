package com.module.service.domainRegistration.change.change.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.module.dao.base.CommonMapper;
import com.module.dao.domainRegistration.change.change.DxxzspAgencyLicenseMapper;
import com.module.domain.domainRegistration.change.change.DxxzspAgencyLicenseWithBLOBs;
import com.module.service.common.ItemUserApplyService;
import com.module.service.domainRegistration.change.change.DxxzspRegistRealmChangeService;
import com.util.AppException;

@Service("DxxzspRegistRealmChangeService")
public class DxxzspRegistRealmChangeServiceImpl implements DxxzspRegistRealmChangeService{
	@Resource
	private CommonMapper commonMapper;
	@Resource
	private DxxzspAgencyLicenseMapper dxxzspAgencyLicenseMapper;
	@Resource
	private ItemUserApplyService itemUserApplyService;
	@Override
	public Map<String, Object> getRow(String id, String flowrunid)throws AppException {
		String  itemid=itemUserApplyService.getProcessId(id);
		Map<String,Object> ret = new HashMap<String,Object>();
		List<DxxzspAgencyLicenseWithBLOBs> list_ret = new ArrayList<DxxzspAgencyLicenseWithBLOBs>();
		List<Map<String,Object>> list_RegistRealmChange =  commonMapper.findManyData("select * from DXXZSP_AGENCY_LICENSE where itemid = '"+itemid+"'");
		for(Map<String,Object> tmp : list_RegistRealmChange ){
			DxxzspAgencyLicenseWithBLOBs blob = dxxzspAgencyLicenseMapper.selectByPrimaryKey((String)tmp.get("ID"));
			list_ret.add(blob);
    	}
		ret.put("DXXZSP_AGENCY_LICENSE", list_ret);
		return ret;
	}
}

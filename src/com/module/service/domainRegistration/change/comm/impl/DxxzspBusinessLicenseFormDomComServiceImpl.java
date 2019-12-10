package com.module.service.domainRegistration.change.comm.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.module.dao.base.CommonMapper;
import com.module.dao.domainRegistration.change.comm.DxxzspLicenseChangedMapper;
import com.module.domain.domainRegistration.change.comm.DxxzspLicenseChangedWithBLOBs;
import com.module.service.common.ItemUserApplyService;
import com.module.service.domainRegistration.change.comm.DxxzspBusinessLicenseFormDomComService;
import com.util.AppException;

@Service("DxxzspBusinessLicenseFormDomComService")
public class DxxzspBusinessLicenseFormDomComServiceImpl implements DxxzspBusinessLicenseFormDomComService{
	@Resource
	private CommonMapper commonMapper;
	@Resource
	private DxxzspLicenseChangedMapper dxxzspLicenseChangedMapper;
	@Resource
	private ItemUserApplyService itemUserApplyService;
	@Override
	public Map<String, Object> getRow(String id, String flowrunid)throws AppException {
		String itemid=itemUserApplyService.getProcessId(id);
		Map<String,Object> ret = new HashMap<String,Object>();
		List<DxxzspLicenseChangedWithBLOBs> list_ret = new ArrayList<DxxzspLicenseChangedWithBLOBs>();
		List<Map<String,Object>> list_BusinessLicenseFormDomCom =  commonMapper.findManyData("select * from DXXZSP_LICENSE_CHANGED where itemid = '"+itemid+"'");
		for(Map<String,Object> tmp : list_BusinessLicenseFormDomCom ){
			DxxzspLicenseChangedWithBLOBs blob = dxxzspLicenseChangedMapper.selectByPrimaryKey((String)tmp.get("ID"));
			list_ret.add(blob);
    	}
		ret.put("DXXZSP_LICENSE_CHANGED", list_ret);
		return ret;
	}
}

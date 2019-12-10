package com.module.service.electricLicencePermit.change.provinceInnerChange.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.module.dao.base.CommonMapper;
import com.module.dao.electricLicencePermit.change.TransRegionalChange.ContinueApplicationMapper;
import com.module.domain.electricLicencePermit.change.TransRegionalChange.ContinueApplicationWithBLOBs;
import com.module.service.electricLicencePermit.change.provinceInnerChange.DxxzspRenewalOfLicenseChaProService;
import com.util.AppException;

@Service("DxxzspRenewalOfLicenseChaProService")
public class DxxzspRenewalOfLicenseChaProServiceImpl implements DxxzspRenewalOfLicenseChaProService{
	@Resource
	private CommonMapper commonMapper;
	@Resource
	private ContinueApplicationMapper continueApplicationMapper;
	@Override
	public Map<String, Object> getRow(String id, String flowrunid)throws AppException {
		Map<String,Object> ret = new HashMap<String,Object>();
		List<ContinueApplicationWithBLOBs> list_ret = new ArrayList<ContinueApplicationWithBLOBs>();
		List<Map<String,Object>> list_RenewalOfLicense=  commonMapper.findManyData("select * from CONTINUE_APPLICATION where id = '"+id+"'");
		for(Map<String,Object> tmp : list_RenewalOfLicense ){
			ContinueApplicationWithBLOBs blob = continueApplicationMapper.selectByPrimaryKey((String)tmp.get("ID"));
    		list_ret.add(blob);
//    		System.out.println("================================");
//    		System.out.print(list_ret);
//    		System.out.println("================================");
    	}
		ret.put("CONTINUE_APPLICATION", list_ret);

		return ret;
	}
}


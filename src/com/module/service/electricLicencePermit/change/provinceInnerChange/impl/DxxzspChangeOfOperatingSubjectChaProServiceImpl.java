package com.module.service.electricLicencePermit.change.provinceInnerChange.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.module.dao.base.CommonMapper;
import com.module.dao.electricLicencePermit.change.provinceInnerChange.DxxzspBusinessChangeMapper;
import com.module.domain.electricLicencePermit.change.provinceInnerChange.DxxzspBusinessChangeWithBLOBs;
import com.module.service.electricLicencePermit.change.provinceInnerChange.DxxzspChangeOfOperatingSubjectChaProService;
import com.util.AppException;

@Service("DxxzspChangeOfOperatingSubjectChaProService")
public class DxxzspChangeOfOperatingSubjectChaProServiceImpl implements DxxzspChangeOfOperatingSubjectChaProService {
	@Resource
	private CommonMapper commonMapper;
	@Resource
	private DxxzspBusinessChangeMapper dxxzspBusinessChangeMapper;
	@Override
	public Map<String, Object> getRow(String id, String flowrunid)throws AppException {
		Map<String,Object> ret = new HashMap<String,Object>();
		Map<String,Object> list_ChangeOfOperatingSubjectChaPro =  commonMapper.findOneData("select * from BUSINESS_CHANGE where id = '"+id+"'");
		if(list_ChangeOfOperatingSubjectChaPro != null){
			String ywid = (String) list_ChangeOfOperatingSubjectChaPro.get("ID");
			
			List<DxxzspBusinessChangeWithBLOBs> list_ret = new ArrayList<DxxzspBusinessChangeWithBLOBs>();
			List<Map<String,Object>> list_BusinessChange =  commonMapper.findManyData("select * from BUSINESS_CHANGE where id = '"+ywid+"'");
			for(Map<String,Object> tmp : list_BusinessChange ){
				DxxzspBusinessChangeWithBLOBs blob = dxxzspBusinessChangeMapper.selectByPrimaryKey((String)tmp.get("ID"));
	    		list_ret.add(blob);

	    	}
			
			ret.put("BUSINESS_CHANGE", list_ret);
			
		}
		return ret;
	}
	
}

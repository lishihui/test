package com.module.service.electricLicencePermit.change.provinceInnerChange.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.module.dao.base.CommonMapper;
import com.module.dao.electricLicencePermit.change.provinceInnerChange.DynamicTableMapper;
import com.module.domain.electricLicencePermit.change.provinceInnerChange.DynamicTableWithBLOBs;
import com.module.service.electricLicencePermit.change.provinceInnerChange.DxxzspBusinessCoverageChangeChaProService;
import com.util.AppException;

@Service("DxxzspBusinessCoverageChangeChaProService")
public class DxxzspBusinessCoverageChangeChaProServiceImpl implements DxxzspBusinessCoverageChangeChaProService{
	@Resource
	private CommonMapper commonMapper;
	@Resource
	private DynamicTableMapper dynamicTableMapper;
	@Override
	public Map<String, Object> getRow(String id, String flowrunid)throws AppException {
		Map<String,Object> ret = new HashMap<String,Object>();
		Map<String,Object> list_BusinessCoverageChangeChaPro =  commonMapper.findOneData("select * from BUSINESS_COVERAGE_CHANGE where id = '"+id+"'");
		if(list_BusinessCoverageChangeChaPro != null){
			String ywid = (String) list_BusinessCoverageChangeChaPro.get("ID");
			String parentid = (String) list_BusinessCoverageChangeChaPro.get("ID");
			List<DynamicTableWithBLOBs> list_ret = new ArrayList<DynamicTableWithBLOBs>();
			List<Map<String,Object>> list_BusinessCoverageChange =  commonMapper.findManyData("select * from BUSINESS_COVERAGE_CHANGE where id = '"+ywid+"'");
			List<Map<String,Object>> list_DynamicTable =  commonMapper.findManyData("select * from DYNAMIC_TABLE where PARENTID = '"+parentid+"'");
			for(Map<String,Object> tmp : list_DynamicTable ){
				DynamicTableWithBLOBs blob = dynamicTableMapper.selectByPrimaryKey((String)tmp.get("ID"));
				list_ret.add(blob);
//	    		System.out.println("================================");
//	    		System.out.print(list_ret);
//	    		System.out.println("================================");
	    	}
			// System.out.println("================================");
			// System.out.print(list_agreement);
			// System.out.print(list_agreement1);
			// System.out.print(list_agreement2);
			// System.out.printf("================================");
			ret.put("BUSINESS_COVERAGE_CHANGE", list_BusinessCoverageChange);
			ret.put("DYNAMIC_TABLE", list_ret);
		}	
		return ret;
	}
}

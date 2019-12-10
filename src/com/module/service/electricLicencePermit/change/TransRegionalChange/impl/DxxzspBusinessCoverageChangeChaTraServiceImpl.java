package com.module.service.electricLicencePermit.change.TransRegionalChange.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.module.dao.base.CommonMapper;
import com.module.dao.electricLicencePermit.change.provinceInnerChange.DynamicTableMapper;
import com.module.domain.electricLicencePermit.change.provinceInnerChange.DynamicTableWithBLOBs;
import com.module.service.electricLicencePermit.change.TransRegionalChange.DxxzspBusinessCoverageChangeChaTraService;
import com.util.AppException;

@Service("DxxzspBusinessCoverageChangeChaTraService")
public class DxxzspBusinessCoverageChangeChaTraServiceImpl implements DxxzspBusinessCoverageChangeChaTraService{
	@Resource
	private CommonMapper commonMapper;
	@Resource
	private DynamicTableMapper dynamicTableMapper;
	@Override
	public Map<String, Object> getRow(String id, String flowrunid)throws AppException {
		Map<String,Object> ret = new HashMap<String,Object>();
		Map<String,Object> listagreement =  commonMapper.findOneData("select * from BUSINESS_COVERAGE_CHANGE where id = '"+id+"'");
		if(listagreement != null){
			String ywid = (String) listagreement.get("ID");
			String parentid = (String) listagreement.get("ID");
			List<DynamicTableWithBLOBs> list_ret = new ArrayList<DynamicTableWithBLOBs>();
			List<Map<String,Object>> list_agreement =  commonMapper.findManyData("select * from BUSINESS_COVERAGE_CHANGE where id = '"+ywid+"'");
			List<Map<String,Object>> list_DynamicTable =  commonMapper.findManyData("select * from DYNAMIC_TABLE where PARENTID = '"+parentid+"'");
			
			for(Map<String,Object> tmp : list_DynamicTable ){
				DynamicTableWithBLOBs blob = dynamicTableMapper.selectByPrimaryKey((String)tmp.get("ID"));
	    		list_ret.add(blob); 		
	    	}
			ret.put("BUSINESS_COVERAGE_CHANGE", list_agreement);
			ret.put("DYNAMIC_TABLE", list_DynamicTable);
		}	
		return ret;
	}
}

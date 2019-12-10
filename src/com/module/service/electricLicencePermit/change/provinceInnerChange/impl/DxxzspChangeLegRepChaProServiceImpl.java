package com.module.service.electricLicencePermit.change.provinceInnerChange.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.module.dao.base.CommonMapper;
import com.module.dao.electricLicencePermit.change.provinceInnerChange.DxxzspLegalChangeMapper;
import com.module.domain.electricLicencePermit.change.provinceInnerChange.DxxzspLegalChangeWithBLOBs;
import com.module.service.electricLicencePermit.change.provinceInnerChange.DxxzspChangeLegRepChaProService;
import com.util.AppException;

@Service("DxxzspChangeLegRepChaProService")
public class DxxzspChangeLegRepChaProServiceImpl implements DxxzspChangeLegRepChaProService {
	@Resource
	private CommonMapper commonMapper;
	@Resource
	private DxxzspLegalChangeMapper dxxzspLegalChangeMapper;
	@Override
	public Map<String, Object> getRow(String id, String flowrunid)throws AppException {
		Map<String,Object> ret = new HashMap<String,Object>();
		Map<String,Object> list_ChangeLegRepChaPro =  commonMapper.findOneData("select * from LEGAL_CHANGE where id = '"+id+"'");
		if(list_ChangeLegRepChaPro != null){
			String ywid = (String) list_ChangeLegRepChaPro.get("ID");
			
			List<DxxzspLegalChangeWithBLOBs> list_ret = new ArrayList<DxxzspLegalChangeWithBLOBs>();
			List<Map<String,Object>> list_LegalChange =  commonMapper.findManyData("select * from LEGAL_CHANGE where id = '"+ywid+"'");
			for(Map<String,Object> tmp : list_LegalChange ){
				DxxzspLegalChangeWithBLOBs blob = dxxzspLegalChangeMapper.selectByPrimaryKey((String)tmp.get("ID"));
	    		list_ret.add(blob);

	    	}
			
			ret.put("LEGAL_CHANGE", list_ret);
			
		}
		return ret;
	}
	
}

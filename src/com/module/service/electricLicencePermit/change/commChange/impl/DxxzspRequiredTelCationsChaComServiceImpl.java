package com.module.service.electricLicencePermit.change.commChange.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.module.dao.base.CommonMapper;
import com.module.dao.electricLicencePermit.change.commChange.ChangePublicFormsMapper;
import com.module.domain.electricLicencePermit.change.commChange.ChangePublicFormsWithBLOBs;
import com.module.service.electricLicencePermit.change.commChange.DxxzspRequiredTelCationsChaComService;
import com.util.AppException;

@Service("DxxzspRequiredTelCationsChaComService")
public class DxxzspRequiredTelCationsChaComServiceImpl implements DxxzspRequiredTelCationsChaComService {
	@Resource
	private CommonMapper commonMapper;
	@Resource
	private ChangePublicFormsMapper changePublicFormsMapper;
	@Override
	public Map<String, Object> getRow(String id, String flowrunid)throws AppException {
		Map<String,Object> ret = new HashMap<String,Object>();
		Map<String,Object> listagreement =  commonMapper.findOneData("select * from CHANGE_PUBLIC_FORMS where id = '"+id+"'");
		if(listagreement != null){
			String ywid = (String) listagreement.get("ID");
			List<ChangePublicFormsWithBLOBs> list_ret = new ArrayList<ChangePublicFormsWithBLOBs>();
			List<Map<String,Object>> list_agreement =  commonMapper.findManyData("select * from CHANGE_PUBLIC_FORMS where id = '"+ywid+"'");
			for(Map<String,Object> tmp : list_agreement ){
				ChangePublicFormsWithBLOBs blob = changePublicFormsMapper.selectByPrimaryKey((String)tmp.get("ID"));
	    		list_ret.add(blob);
	    	}
			ret.put("CHANGE_PUBLIC_FORMS", list_ret);
		}
		return ret;
	}
	
}

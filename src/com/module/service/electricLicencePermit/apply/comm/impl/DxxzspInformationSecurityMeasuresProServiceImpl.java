package com.module.service.electricLicencePermit.apply.comm.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.module.dao.base.CommonMapper;
import com.module.dao.electricLicencePermit.apply.comm.DxxzspKqyxksqggbMapper;
import com.module.domain.electricLicencePermit.apply.comm.DxxzspKqyxksqggbWithBLOBs;
import com.module.service.common.ItemUserApplyService;
import com.module.service.electricLicencePermit.apply.comm.DxxzspInformationSecurityMeasuresProService;
import com.util.AppException;

@Service("DxxzspInformationSecurityMeasuresProService")
public class DxxzspInformationSecurityMeasuresProServiceImpl implements DxxzspInformationSecurityMeasuresProService {
	@Resource
	private CommonMapper commonMapper;
	@Resource
	private DxxzspKqyxksqggbMapper dxxzspKqyxksqggbMapper;
	@Resource
	private ItemUserApplyService itemUserApplyService;
	@Override
	public Map<String, Object> getRow(String id, String flowrunid)throws AppException {
		String itemid=itemUserApplyService.getProcessId(id);
		Map<String,Object> ret = new HashMap<String,Object>();
		Map<String,Object> list_InformationSecurityMeasuresPro =  commonMapper.findOneData("select * from DXXZSP_KQYXKSQGGB where itemid = '"+itemid+"'");
		if(list_InformationSecurityMeasuresPro != null){
			String ywid = (String) list_InformationSecurityMeasuresPro.get("ID");
			String parentid = (String) list_InformationSecurityMeasuresPro.get("ID");
			List<DxxzspKqyxksqggbWithBLOBs> list_ret = new ArrayList<DxxzspKqyxksqggbWithBLOBs>();
			List<Map<String,Object>> list_DxxzspKqyxksqggb =  commonMapper.findManyData("select * from DXXZSP_KQYXKSQGGB where id = '"+ywid+"'");
			for(Map<String,Object> tmp : list_DxxzspKqyxksqggb ){
				DxxzspKqyxksqggbWithBLOBs blob = dxxzspKqyxksqggbMapper.selectByPrimaryKey((String)tmp.get("ID"));
	    		list_ret.add(blob);

	    	}
			List<Map<String,Object>> list_DxxzspGgbgqjg =  commonMapper.findManyData("select * from DXXZSP_GGBGQJG where PARENTID = '"+parentid+"'");
			List<Map<String,Object>> list_DxxzspZyjsrymd =  commonMapper.findManyData("select * from DXXZSP_ZYJSRYMD where PARENTID = '"+parentid+"'");
			List<Map<String,Object>> list_DxxzspZyglrymd =  commonMapper.findManyData("select * from DXXZSP_ZYGLRYMD where PARENTID = '"+parentid+"'");
			

			ret.put("DXXZSP_KQYXKSQGGB", list_ret);
			ret.put("DXXZSP_GGBGQJG", list_DxxzspGgbgqjg);
			ret.put("DXXZSP_ZYJSRYMD", list_DxxzspZyjsrymd);
			ret.put("DXXZSP_ZYGLRYMD", list_DxxzspZyglrymd);

		}
		
		return ret;
	}
	
}

package com.module.service.registrationManagement.apply.apply.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.module.dao.base.CommonMapper;
import com.module.dao.registrationManagement.apply.apply.CompanyManagerListMapper;
import com.module.domain.registrationManagement.apply.apply.CompanyManagerListWithBLOBs;
import com.module.dao.registrationManagement.apply.apply.DxxzspCompanyProfileMapper;
import com.module.domain.registrationManagement.apply.apply.DxxzspCompanyProfileWithBLOBs;
import com.module.dao.registrationManagement.apply.apply.CompanyTechListMapper;
import com.module.domain.registrationManagement.apply.apply.CompanyTechListWithBLOBs;
import com.module.service.common.ItemUserApplyService;
import com.module.service.registrationManagement.apply.apply.DxxzspCompanyProfileService;
import com.util.AppException;

@Service("DxxzspCompanyProfileService")
public class DxxzspCompanyProfileServiceImpl implements DxxzspCompanyProfileService{
	@Resource
	private CommonMapper commonMapper;
	@Resource
	private DxxzspCompanyProfileMapper dxxzspCompanyProfileMapper;
	@Resource
	private CompanyManagerListMapper companyManagerListMapper;
	@Resource
	private CompanyTechListMapper companyTechListMapper;
	@Resource
	private ItemUserApplyService itemUserApplyService;
	@Override
	public Map<String, Object> getRow(String id, String flowrunid)throws AppException {
		String itemid=itemUserApplyService.getProcessId(id);
		Map<String,Object> ret = new HashMap<String,Object>();
		Map<String,Object> listagreement =  commonMapper.findOneData("select * from DXXZSP_COMPANY_PROFILE where itemid = '"+itemid+"'");
		if(listagreement !=null){
			String ywid = (String) listagreement.get("ID");
			String parentid = (String) listagreement.get("ID");
			List<Map<String,Object>> list_DxxzspCompanyProfile =  commonMapper.findManyData("select * from DXXZSP_COMPANY_PROFILE where id = '"+ywid+"'");
			List<DxxzspCompanyProfileWithBLOBs> list_retDCP = new ArrayList<DxxzspCompanyProfileWithBLOBs>();
			List<Map<String,Object>> list_CompanyTechList =  commonMapper.findManyData("select * from COMPANY_TECH_LIST where parentid = '"+parentid+"'");
			List<CompanyTechListWithBLOBs> list_retCTL = new ArrayList<CompanyTechListWithBLOBs>();
			List<Map<String,Object>> list_CompanyManagerList =  commonMapper.findManyData("select * from COMPANY_MANAGER_LIST where parentid = '"+parentid+"'");
			List<CompanyManagerListWithBLOBs> list_retCML = new ArrayList<CompanyManagerListWithBLOBs>();
			for(Map<String,Object> tmp : list_DxxzspCompanyProfile){
				DxxzspCompanyProfileWithBLOBs blob = dxxzspCompanyProfileMapper.selectByPrimaryKey((String)tmp.get("ID"));
	    		list_retDCP.add(blob);
	    	}
			for(Map<String,Object> tmp : list_CompanyManagerList){
				CompanyManagerListWithBLOBs blob = companyManagerListMapper.selectByPrimaryKey((String)tmp.get("ID"));
	    		list_retCML.add(blob);
	    	}
			for(Map<String,Object> tmp : list_CompanyTechList){
				CompanyTechListWithBLOBs blob = companyTechListMapper.selectByPrimaryKey((String)tmp.get("ID"));
				list_retCTL.add(blob);
	    	}
			ret.put("DXXZSP_COMPANY_PROFILE", list_retDCP);
			ret.put("COMPANY_TECH_LIST", list_retCTL);
			ret.put("COMPANY_MANAGER_LIST", list_retCML);

		}
		return ret;
	}
	
}
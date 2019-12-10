package com.module.service.electricLicencePermit.change.provinceInnerChange.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.module.dao.electricLicencePermit.change.provinceInnerChange.CompanyChangeDymMapper;
import com.module.dao.electricLicencePermit.change.provinceInnerChange.authorizedCompanyChangeMapper;
import com.module.dao.base.CommonMapper;
import com.module.domain.electricLicencePermit.change.provinceInnerChange.CompanyChangeDymWithBLOBs;
import com.module.domain.electricLicencePermit.change.provinceInnerChange.authorizedCompanyChangeWithBLOBs;
import com.module.service.electricLicencePermit.change.provinceInnerChange.DxxzspAuthorizedSubsidiaryChaProService;
import com.util.AppException;

@Service("DxxzspAuthorizedSubsidiaryChaProService")
public class DxxzspAuthorizedSubsidiaryChaProServiceImpl implements DxxzspAuthorizedSubsidiaryChaProService{
	@Resource
	private CommonMapper commonMapper;
	@Resource
	private authorizedCompanyChangeMapper authorizedCompanyChangeMapper;
	@Resource
	private CompanyChangeDymMapper companyChangeDymMapper;
	@Override
	public Map<String, Object> getRow(String id, String flowrunid)throws AppException {
		Map<String,Object> ret = new HashMap<String,Object>();
		Map<String,Object> list_AuthorizedSubsidiaryChaPro =  commonMapper.findOneData("select * from AUTHORIZED_COMPANY_CHANGE where id = '"+id+"'");
		if(list_AuthorizedSubsidiaryChaPro != null){
			String ywid = (String) list_AuthorizedSubsidiaryChaPro.get("ID");
			String parentid = (String) list_AuthorizedSubsidiaryChaPro.get("ID");
			List<Map<String,Object>> list_authorizedCompanyChange =  commonMapper.findManyData("select * from AUTHORIZED_COMPANY_CHANGE where id = '"+ywid+"'");
			List<Map<String,Object>> list_CompanyChangeDym =  commonMapper.findManyData("select * from COMPANY_CHANGE_DYM where PARENTID = '"+parentid+"'");	
		
		
		List<authorizedCompanyChangeWithBLOBs> list_ret = new ArrayList<authorizedCompanyChangeWithBLOBs>();
		List<CompanyChangeDymWithBLOBs> list_retCom = new ArrayList<CompanyChangeDymWithBLOBs>();
		for(Map<String,Object> tmp : list_authorizedCompanyChange){
			authorizedCompanyChangeWithBLOBs blob = authorizedCompanyChangeMapper.selectByPrimaryKey((String)tmp.get("ID"));
			list_ret.add(blob);
//    		System.out.println("================================");
//    		System.out.print(list_ret);
//    		System.out.println("================================");
    	}
		
		for(Map<String,Object> tmp : list_CompanyChangeDym){
			CompanyChangeDymWithBLOBs blob = companyChangeDymMapper.selectByPrimaryKey((String)tmp.get("ID"));
			list_retCom.add(blob);
//    		System.out.println("================================");
//    		System.out.print(list_ret);
//    		System.out.println("================================");
    	}
		
	/*System.out.println("================================");
	System.out.print(list_agreement);
	System.out.print(list_agreement1);
	System.out.print(list_agreement2);
	System.out.printf("================================");*/
	
	ret.put("AUTHORIZED_COMPANY_CHANGE", list_ret);
	ret.put("COMPANY_CHANGE_DYM", list_retCom);
	
	}	
	return ret;
	}
	
}

package com.module.service.ftaTradeApplication.change.change.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.module.dao.base.CommonMapper;
import com.module.dao.electricLicencePermit.change.provinceInnerChange.CompanyChangeDymMapper;
import com.module.dao.ftaTradeApplication.change.change.ZmqcAuthorizedCompanyMapper;
import com.module.domain.electricLicencePermit.change.provinceInnerChange.CompanyChangeDymWithBLOBs;
import com.module.domain.ftaTradeApplication.change.change.ZmqcAuthorizedCompanyWithBLOBs;
import com.module.service.common.ItemUserApplyService;
import com.module.service.ftaTradeApplication.change.change.DxxzspAuthorizedSubsidiaryFtaService;
import com.util.AppException;

@Service("DxxzspAuthorizedSubsidiaryFtaService")
public class DxxzspAuthorizedSubsidiaryFtaServiceImpl implements DxxzspAuthorizedSubsidiaryFtaService{
	@Resource
	private CommonMapper commonMapper;
	@Resource
	private ZmqcAuthorizedCompanyMapper zmqcAuthorizedCompanyMapper;
	@Resource
	private CompanyChangeDymMapper CompanyChangeDymMapper;
	@Resource
	private ItemUserApplyService itemUserApplyService;
	@Override
	public Map<String, Object> getRow(String id, String flowrunid)throws AppException {
		String itemid=itemUserApplyService.getProcessId(id);
		Map<String,Object> ret = new HashMap<String,Object>();
		Map<String,Object> listagreement =  commonMapper.findOneData("select * from ZMQC_AUTHORIZED_COMPANY where itemid = '"+itemid+"'");
		if(listagreement != null){
			String ywid = (String) listagreement.get("ID");
			String parentid = (String) listagreement.get("ID");
			List<ZmqcAuthorizedCompanyWithBLOBs> list_ret = new ArrayList<ZmqcAuthorizedCompanyWithBLOBs>();
			List<CompanyChangeDymWithBLOBs> list_retDym = new ArrayList<CompanyChangeDymWithBLOBs>();
			List<Map<String,Object>> list_ZmqcAuthorizedCompany =  commonMapper.findManyData("select * from ZMQC_AUTHORIZED_COMPANY where id = '"+ywid+"'");
			List<Map<String,Object>> list_CompanyChangeDym =  commonMapper.findManyData("select * from COMPANY_CHANGE_DYM where PARENTID = '"+parentid+"'");	
			for(Map<String,Object> tmp : list_ZmqcAuthorizedCompany ){
				ZmqcAuthorizedCompanyWithBLOBs blob = zmqcAuthorizedCompanyMapper.selectByPrimaryKey((String)tmp.get("ID"));
	    		list_ret.add(blob);
	    	}
			for(Map<String,Object> tmp : list_CompanyChangeDym ){
				CompanyChangeDymWithBLOBs blob = CompanyChangeDymMapper.selectByPrimaryKey((String)tmp.get("ID"));
	    		list_retDym.add(blob);
	    	}
			ret.put("ZMQC_AUTHORIZED_COMPANY", list_ret);
			ret.put("COMPANY_CHANGE_DYM", list_retDym);
		}	
		return ret;
	}
}

package com.module.service.internetDomainRootServices.apply.apply.imp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.module.dao.base.CommonMapper;
import com.module.dao.internetDomainRootServices.apply.apply.DxxzspAgrnciesOverviewMapper;
import com.module.dao.internetDomainRootServices.apply.apply.DxxzspManagementListMapper;
import com.module.dao.internetDomainRootServices.apply.apply.DxxzspTechnicalListMapper;
import com.module.domain.internetDomainRootServices.apply.apply.DxxzspAgenciesOverviewWithBLOBs;
import com.module.domain.internetDomainRootServices.apply.apply.DxxzspManagementListWithBLOBs;
import com.module.domain.internetDomainRootServices.apply.apply.DxxzspTechnicalListWithBLOBs;
import com.module.service.common.ItemUserApplyService;
import com.module.service.internetDomainRootServices.apply.apply.DxxzspOperationOrganizationIntService;
import com.util.AppException;

@Service("DxxzspOperationOrganizationIntService")
public class DxxzspOperationOrganizationIntServiceImpl implements DxxzspOperationOrganizationIntService {
	@Resource
	private CommonMapper commonMapper;
	@Resource
	private DxxzspAgrnciesOverviewMapper dxxzspAgrnciesOverviewMapper;
	@Resource
	private DxxzspManagementListMapper dxxzspManagementListMapper;
	@Resource
	private DxxzspTechnicalListMapper dxxzspTechnicalListMapper;
	@Resource
	private ItemUserApplyService itemUserApplyService;
	@Override
	public Map<String, Object> getRow(String id, String flowrunid)throws AppException {
		String itemid = itemUserApplyService.getProcessId(id);
		Map<String,Object> ret = new HashMap<String,Object>();
		Map<String,Object> list_OperationOrganizationInt =  commonMapper.findOneData("select * from DXXZSP_AGENCIES_OVERVIEW where itemid = '"+itemid+"'");
		if(list_OperationOrganizationInt != null){
			String ywid = (String) list_OperationOrganizationInt.get("ID");
			String parentid = (String) list_OperationOrganizationInt.get("ID");
			List<DxxzspAgenciesOverviewWithBLOBs> list_ret_agen = new ArrayList<DxxzspAgenciesOverviewWithBLOBs>();
			List<DxxzspManagementListWithBLOBs> list_ret_man = new ArrayList<DxxzspManagementListWithBLOBs>();
			List<DxxzspTechnicalListWithBLOBs> list_ret_tech = new ArrayList<DxxzspTechnicalListWithBLOBs>();
			
			List<Map<String,Object>> list_DxxzspAgenciesOverview =  commonMapper.findManyData("select * from DXXZSP_AGENCIES_OVERVIEW where id = '"+ywid+"'");
			
			for(Map<String,Object> tmp : list_DxxzspAgenciesOverview ){
				DxxzspAgenciesOverviewWithBLOBs blob = dxxzspAgrnciesOverviewMapper.selectByPrimaryKey((String)tmp.get("ID"));
				list_ret_agen.add(blob);
	    		
	    	}
			
			List<Map<String,Object>> list_ManagementList =  commonMapper.findManyData("select * from MANAGEMENT_LIST where parentid = '"+parentid+"'");
			for(Map<String,Object> tmp : list_ManagementList ){
				DxxzspManagementListWithBLOBs blob = dxxzspManagementListMapper.selectByPrimaryKey((String)tmp.get("ID"));
				list_ret_man.add(blob);
	    		
	    	}
			
			List<Map<String,Object>> list_TechnicalList =  commonMapper.findManyData("select * from TECHNICAL_LIST where parentid = '"+parentid+"'");
			for(Map<String,Object> tmp : list_TechnicalList ){
				DxxzspTechnicalListWithBLOBs blob = dxxzspTechnicalListMapper.selectByPrimaryKey((String)tmp.get("ID"));
				list_ret_tech.add(blob);
	    		
	    	}
			ret.put("DXXZSP_AGENCIES_OVERVIEW", list_ret_agen);
			ret.put("MANAGEMENT_LIST", list_ret_man);
			ret.put("TECHNICAL_LIST", list_ret_tech);
			
		}
		return ret;
	}
	
}


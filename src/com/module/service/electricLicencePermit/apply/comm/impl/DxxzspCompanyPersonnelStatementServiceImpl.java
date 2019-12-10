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
import com.module.service.electricLicencePermit.apply.comm.DxxzspCompanyPersonnelStatementService;
import com.util.AppException;

@Service("DxxzspCompanyPersonnelStatementService")
public class DxxzspCompanyPersonnelStatementServiceImpl implements DxxzspCompanyPersonnelStatementService {
	@Resource
	private CommonMapper commonMapper;
	@Resource
	private DxxzspKqyxksqggbMapper dxxzspKqyxksqggbMapper;
	@Resource
	private ItemUserApplyService  itemUserApplyService;
	@Override
	public Map<String, Object> getRow(String id, String flowrunid)throws AppException {
		String  itemid=itemUserApplyService.getProcessId(id);
		Map<String,Object> ret = new HashMap<String,Object>();
		Map<String,Object> list_CompanyPersonnelStatement =  commonMapper.findOneData("select * from DXXZSP_KQYXKSQGGB where itemid = '"+itemid+"'");
		if(list_CompanyPersonnelStatement != null){
			String ywid = (String) list_CompanyPersonnelStatement.get("ID");
			List<DxxzspKqyxksqggbWithBLOBs> list_ret = new ArrayList<DxxzspKqyxksqggbWithBLOBs>();
			List<Map<String,Object>> list_DxxzspKqyxksqggb =  commonMapper.findManyData("select * from DXXZSP_KQYXKSQGGB where id = '"+ywid+"'");
			for(Map<String,Object> tmp : list_DxxzspKqyxksqggb ){
				DxxzspKqyxksqggbWithBLOBs blob = dxxzspKqyxksqggbMapper.selectByPrimaryKey((String)tmp.get("ID"));
	    		list_ret.add(blob);

	    	}
			ret.put("DXXZSP_KQYXKSQGGB", list_ret);
		
		}	
		return ret;
	}
}

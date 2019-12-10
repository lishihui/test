package com.module.service.domainRegistration.change.change.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.module.dao.base.CommonMapper;
import com.module.dao.registrationManagement.change.change.BeforeChangedHolderMapper;
import com.module.domain.registrationManagement.change.change.BeforeChangedHolderWithBLOBs;
import com.module.service.common.ItemUserApplyService;
import com.module.service.domainRegistration.change.change.DxxzspShareholderRealmChangeService;
import com.util.AppException;

@Service("DxxzspShareholderRealmChangeService")
public class DxxzspShareholderRealmChangeServiceImpl implements DxxzspShareholderRealmChangeService {
	@Resource
	private CommonMapper commonMapper;
	@Resource
	private BeforeChangedHolderMapper beforeChangedHolderMapper;
	@Resource
	private ItemUserApplyService itemUserApplyService;
	@Override
	public Map<String, Object> getRow(String id, String flowrunid)throws AppException {
		String  itemid=itemUserApplyService.getProcessId(id);
		Map<String,Object> ret = new HashMap<String,Object>();
		Map<String,Object> list_ShareholderRealmChange=  commonMapper.findOneData("select * from DXXZSP_OFFICE_ADDRESS where itemid = '"+itemid+"'");
		if(list_ShareholderRealmChange != null){
			String ywid = (String) list_ShareholderRealmChange.get("ID");
			String parentid = (String) list_ShareholderRealmChange.get("ID");
			List<BeforeChangedHolderWithBLOBs> list_ret = new ArrayList<BeforeChangedHolderWithBLOBs>();
			List<Map<String,Object>> list_DxxzspSharedholerChange =  commonMapper.findManyData("select * from DXXZSP_SHAREDHOLER_CHANGE where id = '"+ywid+"'");
			List<Map<String,Object>> list_BeforeChange =  commonMapper.findManyData("select * from BEFORE_CHANGED_HOLDER where parentid = '"+parentid+"'");
			for(Map<String,Object> tmp : list_BeforeChange ){
				BeforeChangedHolderWithBLOBs blob = beforeChangedHolderMapper.selectByPrimaryKey((String)tmp.get("ID"));
	    		list_ret.add(blob);
	    	}

			ret.put("DXXZSP_SHAREDHOLER_CHANGE", list_DxxzspSharedholerChange);
			ret.put("BEFORE_CHANGED_HOLDER", list_ret );
		}
		
		return ret;
	}
	
}

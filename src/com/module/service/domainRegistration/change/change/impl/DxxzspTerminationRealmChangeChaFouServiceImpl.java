package com.module.service.domainRegistration.change.change.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.module.dao.base.CommonMapper;
import com.module.dao.registrationManagement.change.change.DxxzspInfoproChangedMapper;
import com.module.domain.registrationManagement.change.change.DxxzspInfoproChangedWithBLOBs;
import com.module.service.common.ItemUserApplyService;
import com.module.service.domainRegistration.change.change.DxxzspTerminationRealmChangeChaFouService;
import com.util.AppException;

@Service("DxxzspTerminationRealmChangeChaFouService")
public class DxxzspTerminationRealmChangeChaFouServiceImpl implements DxxzspTerminationRealmChangeChaFouService {
	@Resource
	private CommonMapper commonMapper;
	@Resource
	private DxxzspInfoproChangedMapper dxxzspInfoproChangedMapper;
	@Resource
	private ItemUserApplyService itemUserApplyService;
	@Override
	public Map<String, Object> getRow(String id, String flowrunid)throws AppException {
		String  itemid=itemUserApplyService.getProcessId(id);
		Map<String,Object> ret = new HashMap<String,Object>();
		Map<String,Object> listagreement =  commonMapper.findOneData("select * from DXXZSP_INFOPRO_CHANGED where itemid = '"+itemid+"'");
		if(listagreement != null){
			String ywid = (String) listagreement.get("ID");
			List<DxxzspInfoproChangedWithBLOBs> list_ret = new ArrayList<DxxzspInfoproChangedWithBLOBs>();
			List<Map<String,Object>> list_InfoproChanged =  commonMapper.findManyData("select * from DXXZSP_INFOPRO_CHANGED where id = '"+ywid+"'");
			for(Map<String,Object> tmp : list_InfoproChanged ){
				DxxzspInfoproChangedWithBLOBs blob = dxxzspInfoproChangedMapper.selectByPrimaryKey((String)tmp.get("ID"));
	    		list_ret.add(blob);
	    	}
			ret.put("DXXZSP_INFOPRO_CHANGED", list_ret);
		}
		return ret;
	}
	
}

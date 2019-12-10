package com.module.service.domainRegistration.apply.apply.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.module.dao.base.CommonMapper;
import com.module.dao.domainRegistration.apply.apply.DxxzspRegisterServerLsMapper;
import com.module.domain.domainRegistration.apply.apply.DxxzspRegisterServerLsWithBLOBs;
import com.module.service.common.ItemUserApplyService;
import com.module.service.domainRegistration.apply.apply.DxxzspRegistrationServRelSysDomService;
import com.util.AppException;

@Service("RegistrationServRelSysDomService")
public class DxxzspRegistrationServRelSysDomServiceImpl implements DxxzspRegistrationServRelSysDomService{
	@Resource
	private CommonMapper commonMapper;
	@Resource
	private DxxzspRegisterServerLsMapper dxxzspRegisterServerLsMapper;
	@Resource
	private ItemUserApplyService itemUserApplyService;
	@Override
	public Map<String, Object> getRow(String id, String flowrunid)throws AppException {
		String itemid=itemUserApplyService.getProcessId(id);
		Map<String,Object> ret = new HashMap<String,Object>();
		List<DxxzspRegisterServerLsWithBLOBs> list_ret = new ArrayList<DxxzspRegisterServerLsWithBLOBs>();
		Map<String,Object> listagreement =  commonMapper.findOneData("select * from  DXXZSP_REGISTR_SERVER_LS where itemid = '"+itemid+"'");	
		List<Map<String,Object>> list_RegisterServer =  commonMapper.findManyData("select * from DXXZSP_REGISTR_SERVER where id = '"+id+"'");		
		ret.put("DXXZSP_REGISTR_SERVER", list_RegisterServer);		
		if(listagreement != null){
			String ywid = (String) listagreement.get("ID");
			String parentid = (String) listagreement.get("ID");
			List<Map<String,Object>> list_RegisterServerLs =  commonMapper.findManyData("select * from DXXZSP_REGISTR_SERVER_LS where id = '"+ywid+"'");
			List<Map<String,Object>> list_RegisterServerZ =  commonMapper.findManyData("select * from DXXZSP_REGISTR_SERVER_Z where PARENTID = '"+parentid+"'");		
			for(Map<String,Object> tmp : list_RegisterServerLs ){
				DxxzspRegisterServerLsWithBLOBs blob = dxxzspRegisterServerLsMapper.selectByPrimaryKey((String)tmp.get("ID"));
	    		list_ret.add(blob);
	    	}
			ret.put("DXXZSP_REGISTR_SERVER_LS", list_ret);
			ret.put("DXXZSP_REGISTR_SERVER_Z", list_RegisterServerZ);
		}	
		return ret;
	}
}

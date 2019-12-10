
package com.module.service.domainRegistration.change.change.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.module.dao.base.CommonMapper;
import com.module.service.common.ItemUserApplyService;
import com.module.service.domainRegistration.change.change.DxxzspAddressRealmChangeService;
import com.util.AppException;

@Service("DxxzspAddressRealmChangeService")
public class DxxzspAddressRealmChangeServiceImpl implements DxxzspAddressRealmChangeService {
	@Resource
	private CommonMapper commonMapper;
	@Resource
	private ItemUserApplyService itemUserApplyService;
	@Override
	public Map<String, Object> getRow(String id, String flowrunid)throws AppException {
        String  itemid=itemUserApplyService.getProcessId(id);
		Map<String,Object> ret = new HashMap<String,Object>();
		Map<String,Object> listagreement =  commonMapper.findOneData("select * from DXXZSP_OFFICE_ADDRESS where itemid = '"+itemid+"'");
		if(listagreement != null){
			String ywid = (String) listagreement.get("ID");
		
		List<Map<String,Object>> list_agreement =  commonMapper.findManyData("select * from DXXZSP_OFFICE_ADDRESS where id = '"+ywid+"'");		
		ret.put("DXXZSP_OFFICE_ADDRESS", list_agreement);
		}
		
		return ret;
	}
	
}

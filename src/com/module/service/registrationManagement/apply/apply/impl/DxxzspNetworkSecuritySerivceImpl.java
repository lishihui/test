package com.module.service.registrationManagement.apply.apply.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.module.dao.base.CommonMapper;
import com.module.dao.registrationManagement.apply.apply.DxxzspNetworkMeasuresMapper;
import com.module.domain.registrationManagement.apply.apply.DxxzspNetworkMeasuresWithBLOBs;
import com.module.service.common.ItemUserApplyService;
import com.module.service.registrationManagement.apply.apply.DxxzspNetworkSecurityService;
import com.util.AppException;

@Service("DxxzspNetworkSecurityService")
public class DxxzspNetworkSecuritySerivceImpl   implements DxxzspNetworkSecurityService {
	@Resource
	private CommonMapper commonMapper;
	@Resource
	private DxxzspNetworkMeasuresMapper dxxzspNetworkMeasuresMapper;
	@Resource
	private ItemUserApplyService itemUserApplyService;
	@Override
	public Map<String, Object> getRow(String id, String flowrunid)throws AppException {
		String itemid=itemUserApplyService.getProcessId(id);
		Map<String,Object> ret = new HashMap<String,Object>();
		Map<String,Object> listagreement =  commonMapper.findOneData("select * from DXXZSP_NETWORK_MEASURES where itemid = '"+itemid+"'");
		if(listagreement != null){
			String ywid = (String) listagreement.get("ID");
			List<DxxzspNetworkMeasuresWithBLOBs> list_ret = new ArrayList<DxxzspNetworkMeasuresWithBLOBs>();
			List<Map<String,Object>> list_agreement =  commonMapper.findManyData("select * from DXXZSP_NETWORK_MEASURES where id = '"+ywid+"'");
			for(Map<String,Object> tmp : list_agreement ){
				DxxzspNetworkMeasuresWithBLOBs blob = dxxzspNetworkMeasuresMapper.selectByPrimaryKey((String)tmp.get("ID"));
	    		list_ret.add(blob);
	    			    	}
			ret.put("DXXZSP_NETWORK_MEASURES", list_ret);
			
		
		}
		return ret;
	}

}


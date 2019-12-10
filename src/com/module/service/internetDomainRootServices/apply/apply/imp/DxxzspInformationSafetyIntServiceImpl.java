package com.module.service.internetDomainRootServices.apply.apply.imp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.module.dao.base.CommonMapper;
import com.module.service.common.ItemUserApplyService;
import com.module.service.internetDomainRootServices.apply.apply.DxxzspInformationSafetyIntService;
import com.module.dao.internetDomainRootServices.apply.apply.DxxzspInfoSecurityMapper;
import com.module.domain.internetDomainRootServices.apply.apply.DxxzspInfoSecurityWithBLOBs;
import com.util.AppException;

@Service("DxxzspInformationSafetyIntService")
public class DxxzspInformationSafetyIntServiceImpl implements DxxzspInformationSafetyIntService {
	@Resource
	private CommonMapper commonMapper;
	@Resource
	private DxxzspInfoSecurityMapper dxxzspInfoSecurityMapper;
	@Resource
	private ItemUserApplyService itemUserApplyService;
	@Override
	public Map<String, Object> getRow(String id, String flowrunid)throws AppException {
		String itemid = itemUserApplyService.getProcessId(id);
		Map<String,Object> ret = new HashMap<String,Object>();
		Map<String,Object> listagreement =  commonMapper.findOneData("select * from DXXZSP_INFO_SECURITY where itemid = '"+itemid+"'");
		if(listagreement != null){
			String ywid = (String) listagreement.get("ID");
			String parentid = (String) listagreement.get("ID");
			
			List<DxxzspInfoSecurityWithBLOBs> list_ret = new ArrayList<DxxzspInfoSecurityWithBLOBs>();
			List<Map<String,Object>> list_agreement =  commonMapper.findManyData("select * from DXXZSP_INFO_SECURITY where id = '"+ywid+"'");
			for(Map<String,Object> tmp : list_agreement ){
				DxxzspInfoSecurityWithBLOBs blob = dxxzspInfoSecurityMapper.selectByPrimaryKey((String)tmp.get("ID"));
	    		list_ret.add(blob);
	    	}
			ret.put("DXXZSP_INFO_SECURITY", list_ret);
		}
		return ret;
	}
	
}


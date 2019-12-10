package com.module.service.electricLicencePermit.apply.transRegional.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.module.dao.base.CommonMapper;
import com.module.dao.electricLicencePermit.apply.provinceInner.DxxzspNetManagedMapper;
import com.module.domain.electricLicencePermit.apply.provinceInner.DxxzspNetManagedWithBLOBs;
import com.module.service.common.ItemUserApplyService;
import com.module.service.electricLicencePermit.apply.transRegional.DxxzspNetworkHostingService;
import com.util.AppException;

@Service("DxxzspNetworkHostingService")
public class DxxzspNetworkHostingServiceImpl implements DxxzspNetworkHostingService {
	@Resource
	private CommonMapper commonMapper;
	@Resource
	private DxxzspNetManagedMapper dxxzspNetManagedMapper;
	@Resource
	private ItemUserApplyService itemUserApplyService;
	@Override
	public Map<String, Object> getRow(String id, String flowrunid)throws AppException {
		String itemid= itemUserApplyService.getProcessId(id);
		Map<String,Object> ret = new HashMap<String,Object>();
		Map<String,Object> listagreement =  commonMapper.findOneData("select * from DXXZSP_NET_MANAGED where itemid = '"+itemid+"'");
		if(listagreement != null){
			String ywid = (String) listagreement.get("ID");
			String parentid = (String) listagreement.get("ID");
			List<DxxzspNetManagedWithBLOBs> list_ret = new ArrayList<DxxzspNetManagedWithBLOBs>();
			List<Map<String,Object>> list_NetManaged =  commonMapper.findManyData("select * from DXXZSP_NET_MANAGED where id = '"+ywid+"'");
			List<Map<String,Object>> list_ProQuCe =  commonMapper.findManyData("select * from PRO_QU_CE where PARENTID = '"+parentid+"'");
			List<Map<String,Object>> list_TitleC =  commonMapper.findManyData("select * from TITLE_C where PARENTID = '"+parentid+"'");
			for(Map<String,Object> tmp : list_NetManaged ){
				DxxzspNetManagedWithBLOBs blob = dxxzspNetManagedMapper.selectByPrimaryKey((String)tmp.get("ID"));
	    		list_ret.add(blob);
	    	}
			ret.put("DXXZSP_NET_MANAGED", list_ret);
			ret.put("PRO_QU_CE", list_ProQuCe);
			ret.put("TITLE_C", list_TitleC);
		}
		return ret;
	}
}
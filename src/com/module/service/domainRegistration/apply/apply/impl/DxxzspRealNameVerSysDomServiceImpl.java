package com.module.service.domainRegistration.apply.apply.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.module.dao.base.CommonMapper;
import com.module.dao.domainRegistration.apply.apply.DxxzspCheckSystemListMapper;
import com.module.dao.domainRegistration.apply.apply.DxxzspCheckSystemMapper;
import com.module.domain.domainRegistration.apply.apply.DxxzspCheckSystemListWithBLOBs;
import com.module.domain.domainRegistration.apply.apply.DxxzspCheckSystemWithBLOBs;
import com.module.service.common.ItemUserApplyService;
import com.module.service.domainRegistration.apply.apply.DxxzspRealNameVerSysDomService;
import com.util.AppException;

@Service("DxxzspRealNameVerSysDomService")
public class DxxzspRealNameVerSysDomServiceImpl implements DxxzspRealNameVerSysDomService {
	@Resource
	private CommonMapper commonMapper;
	@Resource
	private DxxzspCheckSystemMapper dxxzspCheckSystemMapper;
	@Resource
	private DxxzspCheckSystemListMapper dxxzspCheckSystemListMapper;
	@Resource
	private ItemUserApplyService itemUserApplyService;
	@Override
	public Map<String, Object> getRow(String id, String flowrunid)throws AppException {
		String itemid=itemUserApplyService.getProcessId(id);
		Map<String,Object> ret = new HashMap<String,Object>();
		Map<String,Object> listagreement =  commonMapper.findOneData("select * from DXXZSP_CHECK_SYSTEM_LIST where itemid = '"+itemid+"'");
		if(listagreement != null){
			String ywid = (String) listagreement.get("ID");
			String parentid = (String) listagreement.get("ID");
			List<DxxzspCheckSystemListWithBLOBs> list_retList = new ArrayList<DxxzspCheckSystemListWithBLOBs>();
			List<Map<String,Object>> list_CheckSystemList =  commonMapper.findManyData("select * from DXXZSP_CHECK_SYSTEM_LIST where id = '"+ywid+"'");
			List<Map<String,Object>> list_CheckSystemZong =  commonMapper.findManyData("select * from DXXZSP_CHECK_SYSTEM_ZONG where parentid = '"+parentid+"'");
			List<DxxzspCheckSystemWithBLOBs> list_ret = new ArrayList<DxxzspCheckSystemWithBLOBs>();
			List<Map<String,Object>> list_CheckSystem =  commonMapper.findManyData("select * from DXXZSP_CHECK_SYSTEM where parentid = '"+parentid+"'");
			for(Map<String,Object> tmp : list_CheckSystem ){
				DxxzspCheckSystemWithBLOBs blob = dxxzspCheckSystemMapper.selectByPrimaryKey((String)tmp.get("ID"));
	    		list_ret.add(blob);
	    	}
			for(Map<String,Object> tmp : list_CheckSystemList ){
				DxxzspCheckSystemListWithBLOBs blob = dxxzspCheckSystemListMapper.selectByPrimaryKey((String)tmp.get("ID"));
	    		list_retList.add(blob);
	    	}
			ret.put("DXXZSP_CHECK_SYSTEM_LIST", list_retList);
			ret.put("DXXZSP_CHECK_SYSTEM_ZONG", list_CheckSystemZong);
			ret.put("DXXZSP_CHECK_SYSTEM", list_ret);
		}
		return ret;
	}
}


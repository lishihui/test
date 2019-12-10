package com.module.service.threeWebElectric.change.comm.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.module.dao.base.CommonMapper;
import com.module.dao.threeWebElectric.change.comm.DXXZSP_RfcCommonfileMapper;
import com.module.domain.threeWebElectric.change.comm.DXXZSP_RfcCommonfileWithBLOBs;
import com.module.service.common.ItemUserApplyService;
import com.module.service.threeWebElectric.change.comm.DxxzspApplyCommService;
import com.util.AppException;

@Service("DxxzspApplyCommService")
public class DxxzspApplyCommServiceImpl implements DxxzspApplyCommService {
	@Resource
	private CommonMapper commonMapper;
	@Resource
	private DXXZSP_RfcCommonfileMapper dXXZSP_RfcCommonfileMapper;
	@Resource
	private ItemUserApplyService itemUserApplyService;
	@Override
	public Map<String, Object> getRow(String id, String flowrunid)throws AppException {
		String itemid = itemUserApplyService.getProcessId(id);
		Map<String,Object> ret = new HashMap<String,Object>();
		Map<String,Object> Map =  commonMapper.findOneData("select * from DXXSP_RFC_COMMONFILE where itemid = '"+itemid+"'");
		
		if(Map != null){
			String ywid = (String) Map.get("ID");
			List<DXXZSP_RfcCommonfileWithBLOBs> list_ret = new ArrayList<DXXZSP_RfcCommonfileWithBLOBs>();
			List<Map<String,Object>> list_applyComm =  commonMapper.findManyData("select * from DXXSP_RFC_COMMONFILE where id = '"+ywid+"'");
			for(Map<String,Object> tmp : list_applyComm ){
				DXXZSP_RfcCommonfileWithBLOBs blob = dXXZSP_RfcCommonfileMapper.selectByPrimaryKey((String)tmp.get("ID"));
	    		list_ret.add(blob);
	    	}
			ret.put("list_ApplyComm", list_ret);

		}
		return ret;
	}
}

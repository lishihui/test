package com.module.service.threeWebElectric.change.change.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.module.dao.base.CommonMapper;
import com.module.dao.threeWebElectric.change.change.DxxzspRfcRenewalMapper;
import com.module.domain.threeWebElectric.change.change.DxxzspRfcRenewalWithBLOBs;
import com.module.service.common.ItemUserApplyService;
import com.module.service.threeWebElectric.change.change.DxxzspRenewalService;
import com.util.AppException;

@Service("DxxzspRenewalService")
public class DxxzspRenewalServiceImpl implements DxxzspRenewalService{
	@Resource
	private CommonMapper commonMapper;
	@Resource
	private DxxzspRfcRenewalMapper dxxzspRfcRenewalMapper;
	@Resource
	private ItemUserApplyService itemUserApplyService;
	@Override
	public Map<String, Object> getRow(String id, String flowrunid)throws AppException {
		String itemid=itemUserApplyService.getProcessId(id);
		Map<String,Object> ret = new HashMap<String,Object>();
		Map<String,Object> list_agreement =  commonMapper.findOneData("select * from DXXZSP_RFC_RENEWAL where itemid = '"+itemid+"'");
		if(list_agreement != null){
			String ywid = (String) list_agreement.get("ID");
			List<DxxzspRfcRenewalWithBLOBs> list_ret = new ArrayList<DxxzspRfcRenewalWithBLOBs>();
			List<Map<String,Object>> list_renewal =  commonMapper.findManyData("select * from DXXZSP_RFC_RENEWAL where id = '"+ywid+"'");
			for(Map<String,Object> tmp : list_renewal ){
				DxxzspRfcRenewalWithBLOBs blob = dxxzspRfcRenewalMapper.selectByPrimaryKey((String)tmp.get("ID"));
	    		list_ret.add(blob);
	    	}
			ret.put("DXXZSP_RFC_RENEWAL", list_ret);
		}
		return ret;
	}
}

package com.module.service.threeWebElectric.change.change.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.module.dao.base.CommonMapper;
import com.module.dao.threeWebElectric.change.change.DxxzspRfcComnameMapper;
import com.module.domain.threeWebElectric.change.change.DxxzspRfcComnameWithBLOBs;
import com.module.service.common.ItemUserApplyService;
import com.module.service.threeWebElectric.change.change.DxxzspChangeOfCompanyService;
import com.util.AppException;

@Service("DxxzspChangeOfCompanyService")
public class DxxzspChangeOfCompanyServiceImpl implements DxxzspChangeOfCompanyService{
	@Resource
	private CommonMapper commonMapper;
	@Resource
	private DxxzspRfcComnameMapper dxxzspRfcComnameMapper;
	@Resource
	private ItemUserApplyService itemUserApplyService;
	@Override
	public Map<String, Object> getRow(String id, String flowrunid)throws AppException {
		String itemid=itemUserApplyService.getProcessId(id);
		Map<String,Object> ret = new HashMap<String,Object>();
		Map<String,Object> list_ChangeOfCompany =  commonMapper.findOneData("select * from DXXZSP_RFC_COMNAME where itemid = '"+itemid+"'");
			if(list_ChangeOfCompany != null){
			String ywid = (String) list_ChangeOfCompany.get("ID");
			List<DxxzspRfcComnameWithBLOBs> list_ret = new ArrayList<DxxzspRfcComnameWithBLOBs>();
			List<Map<String,Object>> list_DxxzspRfcComname =  commonMapper.findManyData("select * from DXXZSP_RFC_COMNAME where id = '"+ywid+"'");
			for(Map<String,Object> tmp : list_DxxzspRfcComname ){
				DxxzspRfcComnameWithBLOBs blob = dxxzspRfcComnameMapper.selectByPrimaryKey((String)tmp.get("ID"));
	    		list_ret.add(blob);
	    	}
			ret.put("DXXZSP_RFC_COMNAME", list_ret);
		}
		return ret;
	}
}

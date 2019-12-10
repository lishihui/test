package com.module.service.threeWebElectric.change.change.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.module.dao.base.CommonMapper;
import com.module.dao.threeWebElectric.change.change.DxxzspRfcLegalMapper;
import com.module.domain.threeWebElectric.change.change.DxxzspRfcLegalWithBLOBs;
import com.module.service.common.ItemUserApplyService;
import com.module.service.threeWebElectric.change.change.DxxzspChangeLegRepService;
import com.util.AppException;

@Service("DxxzspChangeLegRepService")
public class DxxzspChangeLegRepServiceImpl implements DxxzspChangeLegRepService {
	@Resource
	private CommonMapper commonMapper;
	
	@Resource
	private DxxzspRfcLegalMapper dxxzspRfcLegalMapper;
	@Resource
	private ItemUserApplyService itemUserApplyService;
	
	@Override
	public Map<String, Object> getRow(String id, String flowrunid)throws AppException {
		String itemid=itemUserApplyService.getProcessId(id);
		Map<String,Object> ret = new HashMap<String,Object>();
		Map<String,Object> map =  commonMapper.findOneData("select * from DXXZSP_RFC_LEGAL where itemid = '"+itemid+"'");
		
		if(map != null){
			String ywid = (String)map.get("ID");
			List<DxxzspRfcLegalWithBLOBs> list_ret = new ArrayList<DxxzspRfcLegalWithBLOBs>();
			List<Map<String,Object>> list_DxxzspRfcLegal =  commonMapper.findManyData("select * from DXXZSP_RFC_LEGAL where id = '"+ywid+"'");
			
			for(Map<String,Object> tmp : list_DxxzspRfcLegal ){
				DxxzspRfcLegalWithBLOBs blob = dxxzspRfcLegalMapper.selectByPrimaryKey((String)tmp.get("ID"));
	    		list_ret.add(blob);

	    	}
			ret.put("list_DxxzspRfcLegal", list_ret);
		}
		return ret;
	}
}
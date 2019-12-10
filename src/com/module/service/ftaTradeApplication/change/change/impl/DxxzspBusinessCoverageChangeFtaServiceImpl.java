package com.module.service.ftaTradeApplication.change.change.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.module.dao.base.CommonMapper;
import com.module.dao.ftaTradeApplication.change.change.DxxzspDynamicTableMapper;
import com.module.domain.ftaTradeApplication.change.change.DxxzspDynamicTableWithBLOBs;
import com.module.service.common.ItemUserApplyService;
import com.module.service.ftaTradeApplication.change.change.DxxzspBusinessCoverageChangeFtaService;
import com.util.AppException;

@Service("DxxzspBusinessCoverageChangeFtaService")
public class DxxzspBusinessCoverageChangeFtaServiceImpl implements DxxzspBusinessCoverageChangeFtaService{
	@Resource
	private CommonMapper commonMapper;
	@Resource
	private DxxzspDynamicTableMapper dxxzspDynamicTableMapper;
	@Resource
	private ItemUserApplyService itemUserApplyService;
	@Override
	public Map<String, Object> getRow(String id, String flowrunid)throws AppException {
		String itemid=itemUserApplyService.getProcessId(id);
		Map<String,Object> ret = new HashMap<String,Object>();
		Map<String,Object> listagreement =  commonMapper.findOneData("select * from ZMQC_BUSINESS_COVERAGE where itemid = '"+itemid+"'");
		if(listagreement != null){
			String ywid = (String) listagreement.get("ID");
			String parentid = (String) listagreement.get("ID");
			List<DxxzspDynamicTableWithBLOBs> list_ret = new ArrayList<DxxzspDynamicTableWithBLOBs>();
			List<Map<String,Object>> list_ZmqcBusinessCoverage =  commonMapper.findManyData("select * from ZMQC_BUSINESS_COVERAGE where id = '"+ywid+"'");
			List<Map<String,Object>> list_DynamicTable =  commonMapper.findManyData("select * from DXXZSP_DYNAMIC_TABLE where PARENTID = '"+parentid+"'");	
			for(Map<String,Object> tmp : list_DynamicTable){
				DxxzspDynamicTableWithBLOBs blob = dxxzspDynamicTableMapper.selectByPrimaryKey((String)tmp.get("ID"));
	    		list_ret.add(blob);
	    	}
			ret.put("ZMQC_BUSINESS_COVERAGE", list_ZmqcBusinessCoverage);
			ret.put("DXXZSP_DYNAMIC_TABLE", list_ret);
		}	
		return ret;
	}
}

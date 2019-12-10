package com.module.service.ftaTradeApplication.change.change.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.module.dao.base.CommonMapper;
import com.module.dao.ftaTradeApplication.change.change.ZmqcLegalChangeMapper;
import com.module.domain.ftaTradeApplication.change.change.ZmqcLegalChangeWithBLOBs;
import com.module.service.common.ItemUserApplyService;
import com.module.service.ftaTradeApplication.change.change.DxxzspChangeLegRepFtaService;
import com.util.AppException;

@Service("DxxzspChangeLegRepFtaService")
public class DxxzspChangeLegRepFtaServiceImpl implements DxxzspChangeLegRepFtaService {
	@Resource
	private CommonMapper commonMapper;
	@Resource
	private ZmqcLegalChangeMapper ZmqcLegalChangeMapper;
	@Resource
	private ItemUserApplyService itemUserApplyService;
	@Override
	public Map<String, Object> getRow(String id, String flowrunid)throws AppException {
		String itemid=itemUserApplyService.getProcessId(id);
		Map<String,Object> ret = new HashMap<String,Object>();
		Map<String,Object> listagreement =  commonMapper.findOneData("select * from ZMQC_LEGAL_CHANGE where itemid = '"+itemid+"'");
		if(listagreement != null){
			String ywid = (String) listagreement.get("ID");
			List<ZmqcLegalChangeWithBLOBs> list_ret = new ArrayList<ZmqcLegalChangeWithBLOBs>();
			List<Map<String,Object>> list_agreement =  commonMapper.findManyData("select * from ZMQC_LEGAL_CHANGE where id = '"+ywid+"'");
			for(Map<String,Object> tmp : list_agreement ){
				ZmqcLegalChangeWithBLOBs blob = ZmqcLegalChangeMapper.selectByPrimaryKey((String)tmp.get("ID"));
	    		list_ret.add(blob);
	    	}
			ret.put("ZMQC_LEGAL_CHANGE", list_ret);
		}
		return ret;
	}
}
package com.module.service.ftaTradeApplication.apply.comm.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.module.dao.base.CommonMapper;
import com.module.dao.ftaTradeApplication.apply.comm.DxxzspZmqKqyxksqggbMapper;
import com.module.domain.ftaTradeApplication.apply.comm.DxxzspZmqKqyxksqggbWithBLOBs;
import com.module.service.common.ItemUserApplyService;
import com.module.service.ftaTradeApplication.apply.comm.DxxzspShaTraRelCertMaterFtaService;
import com.util.AppException;

@Service("DxxzspShaTraRelCertMaterFtaService")
public class DxxzspShaTraRelCertMaterFtaServiceImpl implements DxxzspShaTraRelCertMaterFtaService {
	@Resource
	private CommonMapper commonMapper;
	@Resource
	private DxxzspZmqKqyxksqggbMapper dxxzspZmqKqyxksqggbMapper;
	@Resource
	private ItemUserApplyService itemUserApplyService;
	@Override
	public Map<String, Object> getRow(String id, String flowrunid)throws AppException {
		String itemid=itemUserApplyService.getProcessId(id);
		Map<String,Object> ret = new HashMap<String,Object>();
		Map<String,Object> list_ShaTraRelCertMaterFta =  commonMapper.findOneData("select * from DXXZSP_ZMQ_KQYXKSQGGB where itemid = '"+itemid+"'");
		if(list_ShaTraRelCertMaterFta != null){
			String ywid = (String) list_ShaTraRelCertMaterFta.get("ID");
			String parentid = (String) list_ShaTraRelCertMaterFta.get("ID");
			List<DxxzspZmqKqyxksqggbWithBLOBs> list_ret = new ArrayList<DxxzspZmqKqyxksqggbWithBLOBs>();
			List<Map<String,Object>> list_ZmqKqyxksqggb =  commonMapper.findManyData("select * from DXXZSP_ZMQ_KQYXKSQGGB where id = '"+ywid+"'");
			List<Map<String,Object>> list_Zyjsrymd =  commonMapper.findManyData("select * from DXXZSP_ZYJSRYMD where PARENTID = '"+parentid+"'");
			List<Map<String,Object>> list_Zyglrymd =  commonMapper.findManyData("select * from DXXZSP_ZYGLRYMD where PARENTID = '"+parentid+"'");
			List<Map<String,Object>> list_Ggbgqjg =  commonMapper.findManyData("select * from DXXZSP_GGBGQJG where PARENTID = '"+parentid+"'");
			for(Map<String,Object> tmp : list_ZmqKqyxksqggb ){
				DxxzspZmqKqyxksqggbWithBLOBs blob = dxxzspZmqKqyxksqggbMapper.selectByPrimaryKey((String)tmp.get("ID"));
	    		list_ret.add(blob);
	    	}
			ret.put("DXXZSP_ZMQ_KQYXKSQGGB", list_ret);
			ret.put("DXXZSP_ZYJSRYMD", list_Zyjsrymd);
			ret.put("DXXZSP_ZYGLRYMD", list_Zyglrymd);
			ret.put("DXXZSP_GGBGQJG", list_Ggbgqjg);
		}
		return ret;
	}
}

package com.module.service.registrationManagement.change.change.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.module.dao.base.CommonMapper;
import com.module.dao.registrationManagement.change.change.DxxzspZzjyCommitMapper;
import com.module.domain.registrationManagement.change.change.DxxzspZzjyCommitWithBLOBs;
import com.module.service.common.ItemUserApplyService;
import com.module.service.registrationManagement.change.change.DxxzspTerminationChangeChaTwoService;
import com.util.AppException;

@Service("DxxzspTerminationChangeChaTwoService")
public class DxxzspTerminationChangeChaTwoServiceImpl implements DxxzspTerminationChangeChaTwoService{
	@Resource
	private CommonMapper commonMapper;
	@Resource
	private DxxzspZzjyCommitMapper dxxzspZzjyCommitMapper;
	@Resource
	private ItemUserApplyService itemUserApplyService;
	@Override
	public Map<String, Object> getRow(String id, String flowrunid)throws AppException {
		String itemid=itemUserApplyService.getProcessId(id);
		Map<String,Object> ret = new HashMap<String,Object>();
		List<DxxzspZzjyCommitWithBLOBs> list_ret = new ArrayList<DxxzspZzjyCommitWithBLOBs>();
		List<Map<String,Object>> list_DxxzspZzjyCommit =  commonMapper.findManyData("select * from DXXZSP_ZZJY_COMMIT where itemid = '"+itemid+"'");
		for(Map<String,Object> tmp : list_DxxzspZzjyCommit ){
			DxxzspZzjyCommitWithBLOBs blob = dxxzspZzjyCommitMapper.selectByPrimaryKey((String)tmp.get("ID"));
    		list_ret.add(blob);
    	}
		ret.put("DXXZSP_ZZJY_COMMIT", list_ret);
		return ret;
	}
}

package com.module.service.domainRegistration.change.change.impl;

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
import com.module.service.domainRegistration.change.change.DxxzspTerminationRealmChangeChaTheService;
import com.util.AppException;

@Service("DxxzspTerminationRealmChangeChaTheService")
public class DxxzspTerminationRealmChangeChaTheServiceImpl implements DxxzspTerminationRealmChangeChaTheService {
	@Resource
	private CommonMapper commonMapper;
	@Resource
	private DxxzspZzjyCommitMapper dxxzspZzjyCommitMapper;
	@Resource
	private ItemUserApplyService itemUserApplyService;
	@Override
	public Map<String, Object> getRow(String id, String flowrunid)throws AppException {
		String  itemid=itemUserApplyService.getProcessId(id);
		Map<String,Object> ret = new HashMap<String,Object>();
		Map<String,Object> listagreement =  commonMapper.findOneData("select * from DXXZSP_ZZJY_COMMIT where itemid = '"+itemid+"'");
		if(listagreement != null){
			String ywid = (String) listagreement.get("ID");
			List<DxxzspZzjyCommitWithBLOBs> list_ret = new ArrayList<DxxzspZzjyCommitWithBLOBs>();
			List<Map<String,Object>> list_ZzjyCommit =  commonMapper.findManyData("select * from DXXZSP_ZZJY_COMMIT where id = '"+ywid+"'");
			for(Map<String,Object> tmp : list_ZzjyCommit ){
				DxxzspZzjyCommitWithBLOBs blob = dxxzspZzjyCommitMapper.selectByPrimaryKey((String)tmp.get("ID"));
	    		list_ret.add(blob);
	    	}
			ret.put("DXXZSP_ZZJY_COMMIT", list_ret);
		}
		return ret;
	}
	
}

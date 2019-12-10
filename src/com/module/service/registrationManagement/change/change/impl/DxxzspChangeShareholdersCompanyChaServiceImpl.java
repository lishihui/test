package com.module.service.registrationManagement.change.change.impl;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.module.dao.base.CommonMapper;
import com.module.dao.registrationManagement.change.change.BeforeChangedHolderMapper;
import com.module.dao.registrationManagement.change.change.DxxzspBoardResolutionMapper;
import com.module.domain.registrationManagement.change.change.BeforeChangedHolderWithBLOBs;
import com.module.domain.registrationManagement.change.change.DxxzspBoardResolutionWithBLOBs;
import com.module.service.common.ItemUserApplyService;
import com.module.service.registrationManagement.change.change.DxxzspChangeShareholdersCompanyChaService;
import com.util.AppException;

@Service("DxxzspChangeShareholdersCompanyChaService")
public class DxxzspChangeShareholdersCompanyChaServiceImpl implements DxxzspChangeShareholdersCompanyChaService {
	@Resource
	private CommonMapper commonMapper;
	@Resource
	private BeforeChangedHolderMapper beforeChangedHolderMapper;
	@Resource
	private DxxzspBoardResolutionMapper dxxzspBoardResolutionMapper;
	@Resource
	private ItemUserApplyService itemUserApplyService;
	@Override
	public Map<String, Object> getRow(String id, String flowrunid)throws AppException {
		String itemid=itemUserApplyService.getProcessId(id);
		Map<String,Object> ret = new HashMap<String,Object>();
		Map<String,Object> list_ChangeShareholdersCompanyCha =  commonMapper.findOneData("select * from DXXZSP_SHAREDHOLER_CHANGE where itemid = '"+itemid+"'");
		if(list_ChangeShareholdersCompanyCha != null){
			String ywid = (String) list_ChangeShareholdersCompanyCha.get("ID");
			String parentid = (String) list_ChangeShareholdersCompanyCha.get("ID");
			List<BeforeChangedHolderWithBLOBs> list_retBefore = new ArrayList<BeforeChangedHolderWithBLOBs>();
			List<DxxzspBoardResolutionWithBLOBs> list_retBoard = new ArrayList<DxxzspBoardResolutionWithBLOBs>();
			List<Map<String,Object>> list_SharedHolderChange =  commonMapper.findManyData("select * from DXXZSP_SHAREDHOLER_CHANGE where id = '"+ywid+"'");
			List<Map<String,Object>> list_BeforeChangedHolder =  commonMapper.findManyData("select * from BEFORE_CHANGED_HOLDER where PARENTID = '"+parentid+"'");
			List<Map<String,Object>> list_BoardResolution =  commonMapper.findManyData("select * from DXXZSP_BOARD_RESOLUTION  where id = '"+ywid+"'");
			for(Map<String,Object> tmp : list_BeforeChangedHolder ){
				BeforeChangedHolderWithBLOBs blob = beforeChangedHolderMapper.selectByPrimaryKey((String)tmp.get("ID"));
				list_retBefore.add(blob);
	    	}
			for(Map<String,Object> tmp : list_BoardResolution ){
				DxxzspBoardResolutionWithBLOBs blob = dxxzspBoardResolutionMapper.selectByPrimaryKey((String)tmp.get("ID"));
				list_retBoard.add(blob);
	    	}
			ret.put("DXXZSP_SHAREDHOLER_CHANGE", list_SharedHolderChange);
			ret.put("BEFORE_CHANGED_HOLDER", list_retBefore);
			ret.put("DXXZSP_BOARD_RESOLUTION", list_retBoard);
		}
		return ret;
	}
}

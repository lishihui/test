package com.module.service.electricLicencePermit.change.provinceInnerChange.impl;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.module.dao.base.CommonMapper;
import com.module.dao.electricLicencePermit.change.provinceInnerChange.DxxzspReplenishmentOfLostMapper;
import com.module.domain.electricLicencePermit.change.provinceInnerChange.DxxzspReplenishmentOfLostWithBLOBs;
import com.module.service.electricLicencePermit.change.provinceInnerChange.DxxzspReplenishmentOfLostChaProService;
import com.util.AppException;

@Service("DxxzspReplenishmentOfLostChaProService")
public class DxxzspReplenishmentOfLostChaProServiceImpl implements DxxzspReplenishmentOfLostChaProService {
	@Resource
	private CommonMapper commonMapper;
	@Resource
	private DxxzspReplenishmentOfLostMapper dxxzspReplenishmentOfLostMapper;
	@Override
	public Map<String, Object> getRow(String id, String flowrunid)throws AppException {
		Map<String,Object> ret = new HashMap<String,Object>();
		List<DxxzspReplenishmentOfLostWithBLOBs> list_ret = new ArrayList<DxxzspReplenishmentOfLostWithBLOBs>();
		List<Map<String,Object>>list_DxxzspReplenishmentOfLost =  commonMapper.findManyData("select * from LOSS_LICENSE_APPLICATION where id = '"+id+"'");
		
		for(Map<String,Object> tmp : list_DxxzspReplenishmentOfLost){
			DxxzspReplenishmentOfLostWithBLOBs blob = dxxzspReplenishmentOfLostMapper.selectByPrimaryKey((String)tmp.get("ID"));
    			list_ret.add(blob);

    		}

		ret.put("LOSS_LICENSE_APPLICATION", list_ret);
	      
		return ret;
	}
}

package com.module.service.broadbandAccService.comm.imp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.module.dao.base.CommonMapper;
import com.module.dao.domain.DXXZSPGdzsjqxgclMapper;
import com.module.dao.domain.DxxzspWLXIAQBZCSMapper;
import com.module.domain.domain.DXXZSPGdzsjqxgclWithBLOBs;
import com.module.domain.domain.DxxzspWLXIAQBZCSWithBLOBs;
import com.module.service.broadbandAccService.comm.StructureChartService;
import com.module.service.common.ItemUserApplyService;
import com.util.AppException;

//完整详细的股权结构图
@Service("StructureChartService")
public class StructureChartServiceImpl implements StructureChartService {
	
	@Resource
	private CommonMapper commonMapper;
	@Resource
	private ItemUserApplyService itemUserApplyService;
	
	@Resource
	private DXXZSPGdzsjqxgclMapper dXXZSPGdzsjqxgclMapper;
	
	
	//根据主键查询业务数据
    public Map<String,Object> getRow(String id,String flowrunid) throws AppException{ 
    	String Itemid=itemUserApplyService.getProcessId(id);
    	Map<String,Object> ret = new HashMap<String,Object>();
    	//查询业务主表记录ID
    	Map<String,Object> map = commonMapper.findOneData("select * from DXXZSP_GDZSJQXGCL where itemid = '"+Itemid+"' or id = '"+id+"'");
    	if(map !=null){
	    	String ywid = (String)map.get("ID");
	    	String itemid = (String)map.get("ITEMID");
	    	//查询展示数据
	    	List<Map<String,Object>> list_GDZSJXGZMCL =  commonMapper.findManyData("select * from DXXZSP_GDZSJQXGCL where id = '"+ywid+"'"); 
	     	List<DXXZSPGdzsjqxgclWithBLOBs> list_ret = new ArrayList<DXXZSPGdzsjqxgclWithBLOBs>();
	    	for(Map<String,Object> tmp : list_GDZSJXGZMCL ){
	    		DXXZSPGdzsjqxgclWithBLOBs blob = dXXZSPGdzsjqxgclMapper.selectByPrimaryKey((String)tmp.get("ID"));
	    		list_ret.add(blob);
	    	}
	    	ret.put("list_GDZSJXGZMCL", list_ret);
    	}
    	return ret;
    }
}

package com.module.service.broadbandAccService.comm.imp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.module.dao.base.CommonMapper;
import com.module.dao.domain.DxxzspWLXIAQBZCSMapper;
import com.module.domain.domain.DxxzspWLXIAQBZCSWithBLOBs;
import com.module.service.broadbandAccService.comm.BylawScriptService;
import com.module.service.common.ItemUserApplyService;
import com.util.AppException;

//公司章程(加盖工商局档案查询章原件)(bylawScript)
@Service("BylawScriptService")
public class BylawScriptServiceImpl implements BylawScriptService {
	
	@Resource
	private CommonMapper commonMapper;
	@Resource
	private ItemUserApplyService itemUserApplyService;
	
	@Resource
	private DxxzspWLXIAQBZCSMapper dxxzspWLXIAQBZCSMapper;
	
	
	//根据主键查询业务数据
    public Map<String,Object> getRow(String id,String flowrunid) throws AppException{ 
    	String Itemid=itemUserApplyService.getProcessId(id);
    	Map<String,Object> ret = new HashMap<String,Object>();
    	//查询业务主表记录ID
    	Map<String,Object> map = commonMapper.findOneData("select * from DXXZSP_GSZC where itemid = '"+Itemid+"' or id = '"+id+"'");
    	if(map !=null){
	    	String ywid = (String)map.get("ID");
	    	String itemid = (String)map.get("ITEMID");
	    	//查询展示数据
	    	List<Map<String,Object>> list_GSZC =  commonMapper.findManyData("select * from DXXZSP_GSZC where id = '"+ywid+"'"); 
	     	List<DxxzspWLXIAQBZCSWithBLOBs> list_ret = new ArrayList<DxxzspWLXIAQBZCSWithBLOBs>();
	    	for(Map<String,Object> tmp : list_GSZC ){
	    		DxxzspWLXIAQBZCSWithBLOBs blob = dxxzspWLXIAQBZCSMapper.selectByPrimaryKey((String)tmp.get("ID"));
	    		list_ret.add(blob);
	    	}
	    	ret.put("list_GSZC", list_GSZC);
    	}
    	return ret;
    }
}

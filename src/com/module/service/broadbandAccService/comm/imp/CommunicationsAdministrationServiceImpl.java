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
import com.module.service.broadbandAccService.comm.CommunicationsAdministrationService;
import com.module.service.common.ItemUserApplyService;
import com.util.AppException;

//省通信管理局要求提交的其他材料
@Service("CommunicationsAdministrationService")
public class CommunicationsAdministrationServiceImpl implements CommunicationsAdministrationService {
	
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
    	Map<String,Object> map = commonMapper.findOneData("select * from DXXZSP_STXGLJYQQICL where itemid = '"+Itemid+"' or id = '"+id+"'");
    	if(map !=null){
	    	String ywid = (String)map.get("ID");
	    	String itemid = (String)map.get("ITEMID");
	    	//查询展示数据
	    	List<Map<String,Object>> list_XTXGLJYQTJDQTCLB =  commonMapper.findManyData("select * from DXXZSP_STXGLJYQQICL where id = '"+ywid+"'"); 
	     	List<DxxzspWLXIAQBZCSWithBLOBs> list_ret = new ArrayList<DxxzspWLXIAQBZCSWithBLOBs>();
	    	for(Map<String,Object> tmp : list_XTXGLJYQTJDQTCLB ){
	    		DxxzspWLXIAQBZCSWithBLOBs blob = dxxzspWLXIAQBZCSMapper.selectByPrimaryKey((String)tmp.get("ID"));
	    		list_ret.add(blob);
	    	}
	    	ret.put("list_XTXGLJYQTJDQTCLB", list_XTXGLJYQTJDQTCLB);
    	}
    	return ret;
    }
}

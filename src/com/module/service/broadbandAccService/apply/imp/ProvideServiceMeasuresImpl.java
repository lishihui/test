package com.module.service.broadbandAccService.apply.imp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import com.module.dao.base.CommonMapper;
import com.module.dao.domain.DxxzspTGCQFWHZLBZCSMapper;
import com.module.domain.domain.DxxzspTGCQFWHZLBZCSWithBLOBs;
import com.module.domain.domain.DxxzspWlyjsfaZybWithBLOBs;
import com.module.service.broadbandAccService.apply.ProvideServiceMeasuresService;
import com.module.service.common.ItemUserApplyService;
import com.util.AppException;

//为用户提供保障长期服务和保护措施
@Service("ProvideServiceMeasuresService")
public class ProvideServiceMeasuresImpl implements ProvideServiceMeasuresService {
	
	@Resource
	private CommonMapper commonMapper;
	@Resource
	private DxxzspTGCQFWHZLBZCSMapper dxxzspTGCQFWHZLBZCSMapper;
	@Resource
	private ItemUserApplyService itemUserApplyService;
	//根据主键查询业务数据
    public Map<String,Object> getRow(String id,String flowrunid) throws AppException{ 
    	String Itemid=itemUserApplyService.getProcessId(id);
    	Map<String,Object> ret = new HashMap<String,Object>();
    	//查询业务主表记录ID
    	Map<String,Object> map = commonMapper.findOneData("select * from DXXZSP_TGCQFWHZLBZCS where itemid = '"+Itemid+"' or id = '"+id+"' ");
    	if(map !=null){
	    	String ywid = (String)map.get("ID");
	    	String itemid = (String)map.get("ITEMID");
	    	
	    	//查询展示数据
	    	List<Map<String,Object>> list_TGCQFWHZLBZCS =  commonMapper.findManyData("select * from DXXZSP_TGCQFWHZLBZCS where id = '"+ywid+"'");
	    	List<DxxzspTGCQFWHZLBZCSWithBLOBs> list_ret = new ArrayList<DxxzspTGCQFWHZLBZCSWithBLOBs>();
	    	for(Map<String,Object> tmp : list_TGCQFWHZLBZCS ){
	    		DxxzspTGCQFWHZLBZCSWithBLOBs blob = dxxzspTGCQFWHZLBZCSMapper.selectByPrimaryKey((String)tmp.get("ID"));
	    		list_ret.add(blob); 
	    	}
	    	ret.put("list_TGCQFWHZLBZCS",list_ret );
    	}
    	return ret;
    }
}

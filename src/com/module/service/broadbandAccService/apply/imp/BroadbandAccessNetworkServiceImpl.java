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
import com.module.dao.domain.DxxzspYfjykdjrwyeMapper;
import com.module.domain.domain.DXXZSPYwsdsqbWithBLOBs;
import com.module.domain.domain.DxxzspTGCQFWHZLBZCSWithBLOBs;
import com.module.domain.domain.DxxzspYfjykdjrwyeWithBLOBs;
import com.module.service.broadbandAccService.apply.BroadbandAccessNetworkService;
import com.module.service.broadbandAccService.apply.InformatSecurityMeasuresService;
import com.module.service.broadbandAccService.apply.NetworkTechnicalService;
import com.module.service.common.ItemUserApplyService;
import com.module.service.domain.IDxxzspDomainAgreementService;
import com.util.AppException;

//依法经营宽带接入网业务承诺书
@Service("BroadbandAccessNetworkService")
public class BroadbandAccessNetworkServiceImpl implements BroadbandAccessNetworkService {
	
	@Resource
	private CommonMapper commonMapper;
	@Resource
	private ItemUserApplyService itemUserApplyService;
	@Resource
	private DxxzspYfjykdjrwyeMapper dxxzspYfjykdjrwyeMapper;
	//根据主键查询业务数据
    public Map<String,Object> getRow(String id,String flowrunid) throws AppException{ 
    	String Itemid=itemUserApplyService.getProcessId(id);
    	Map<String,Object> ret = new HashMap<String,Object>();
    	//查询业务主表记录ID
    	Map<String,Object> map = commonMapper.findOneData("select * from DXXZSP_YFJYKDJRWYE_CNS where itemid = '"+Itemid+"' or id = '"+id+"' ");
    	if(map !=null){
	    	String ywid = (String)map.get("ID");
	    	String itemid = (String)map.get("ITEMID");
	  	    	//查询展示数据
	    	List<Map<String,Object>> list_YFJYKD =  commonMapper.findManyData("select * from DXXZSP_YFJYKDJRWYE_CNS where id = '"+ywid+"'");
	    	List<DxxzspYfjykdjrwyeWithBLOBs> list_ret = new ArrayList<DxxzspYfjykdjrwyeWithBLOBs>();
	    	for(Map<String,Object> tmp : list_YFJYKD ){
	    		DxxzspYfjykdjrwyeWithBLOBs blob = dxxzspYfjykdjrwyeMapper.selectByPrimaryKey((String)tmp.get("ID"));
	    		list_ret.add(blob); 
	    	}
	    	ret.put("list_YFJYKD",list_ret );
    	}
	    	
    	return ret;
    }
}

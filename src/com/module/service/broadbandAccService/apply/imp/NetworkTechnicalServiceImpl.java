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
import com.module.dao.domain.DxxzspWlyjsfaZybMapper;
import com.module.domain.domain.DxxzspWLXIAQBZCSWithBLOBs;
import com.module.domain.domain.DxxzspWlyjsfaZybWithBLOBs;
import com.module.service.broadbandAccService.apply.InformatSecurityMeasuresService;
import com.module.service.broadbandAccService.apply.NetworkTechnicalService;
import com.module.service.common.ItemUserApplyService;
import com.module.service.domain.IDxxzspDomainAgreementService;
import com.util.AppException;

//网络与技术方案专用表格
@Service("NetworkTechnicalService")
public class NetworkTechnicalServiceImpl implements NetworkTechnicalService {
	
	@Resource
	private CommonMapper commonMapper;
	
	@Resource
	private DxxzspWlyjsfaZybMapper dxxzspWlyjsfaZybMapper;
	@Resource
	private ItemUserApplyService itemUserApplyService;
	//根据主键查询业务数据
    public Map<String,Object> getRow(String id,String flowrunid) throws AppException{ 
    	String Itemid=itemUserApplyService.getProcessId(id);
    	Map<String,Object> ret = new HashMap<String,Object>();
    	//查询业务主表记录ID
    	Map<String,Object> map = commonMapper.findOneData("select * from DXXZSP_WLYJSFA_ZYB where itemid = '"+Itemid+"' or id = '"+id+"' ");
    	if(map !=null){
	    	String ywid = (String)map.get("ID");
	    	String itemid = (String)map.get("ITEMID");
	    	
	    	//查询展示数据
	    	List<Map<String,Object>> list_WLYJSFA =  commonMapper.findManyData("select * from DXXZSP_WLYJSFA_ZYB where id = '"+ywid+"'");
	    	List<DxxzspWlyjsfaZybWithBLOBs> list_ret = new ArrayList<DxxzspWlyjsfaZybWithBLOBs>();
	    	for(Map<String,Object> tmp : list_WLYJSFA ){
	    		DxxzspWlyjsfaZybWithBLOBs blob = dxxzspWlyjsfaZybMapper.selectByPrimaryKey((String)tmp.get("ID"));
	    		list_ret.add(blob);
	    	}
	    	ret.put("list_WLYJSFA", list_ret);
    	}
    	return ret;
    }
}

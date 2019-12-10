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
import com.module.dao.domain.DxxzspYwfzhssjhZybgMapper;
import com.module.dao.domain.DxxzspYwfzhsssjhzybDtbgMapper;
import com.module.domain.domain.DxxzspYwfzhssjhZybgWithBLOBs;
import com.module.domain.domain.DxxzspYwfzhsssjhzybDtbgWithBLOBs;
import com.module.service.broadbandAccService.apply.BussinessDevelopmentService;
import com.module.service.common.ItemUserApplyService;
import com.util.AppException;

//业务发展和实施计划专用表(bussinessDevelopment)
@Service("BussinessDevelopmentService")
public class BussinessDevelopmentServiceImpl implements BussinessDevelopmentService {
	
	@Resource
	private CommonMapper commonMapper;
	
	@Resource
	private DxxzspYwfzhssjhZybgMapper dxxzspYwfzhssjhZybgMapper;
	@Resource
	private ItemUserApplyService itemUserApplyService;
	
	@Resource
	private DxxzspYwfzhsssjhzybDtbgMapper dxxzspYwfzhsssjhzybDtbgMapper;
	
	//根据主键查询业务数据
    public Map<String,Object> getRow(String id,String flowrunid) throws AppException{ 
    	String Itemid=itemUserApplyService.getProcessId(id);
    	Map<String,Object> ret = new HashMap<String,Object>();
    	//查询业务主表记录ID
    	Map<String,Object> map = commonMapper.findOneData("select * from DXXZSP_YWFZHSSJH_ZYBG where itemid = '"+Itemid+"' or id = '"+id+"' ");

    	if(map !=null){
	    	String ywid = (String)map.get("ID");
	    	String itemid = (String)map.get("ITEMID");
	    	
	    	//查询展示数据
	    	List<Map<String,Object>> list_YWFZHSSJH =  commonMapper.findManyData("select * from DXXZSP_YWFZHSSJH_ZYBG where id = '"+ywid+"'");
	    	List<Map<String,Object>> list_YWFZHSSJHZYBG =  commonMapper.findManyData("select * from DXXZSP_YWFZHSSSJHZYB_DTBG where parentid = '"+ywid+"' ");
	    	
	     	List<DxxzspYwfzhssjhZybgWithBLOBs> list_ret1 = new ArrayList<DxxzspYwfzhssjhZybgWithBLOBs>();
	    	for(Map<String,Object> tmp : list_YWFZHSSJH ){
	    		DxxzspYwfzhssjhZybgWithBLOBs blob = dxxzspYwfzhssjhZybgMapper.selectByPrimaryKey((String)tmp.get("ID"));
	    		list_ret1.add(blob);
	    	}
	    	
	     	List<DxxzspYwfzhsssjhzybDtbgWithBLOBs> list_ret2 = new ArrayList<DxxzspYwfzhsssjhzybDtbgWithBLOBs>();
	    	for(Map<String,Object> tmp : list_YWFZHSSJHZYBG ){
	    		DxxzspYwfzhsssjhzybDtbgWithBLOBs blob = dxxzspYwfzhsssjhzybDtbgMapper.selectByPrimaryKey((String)tmp.get("ID"));
	    		list_ret2.add(blob);
	    	}
	    	
	    	ret.put("list_YWFZHSSJH", list_ret1);
	    	ret.put("list_YWFZHSSJHZYBG", list_ret2);

	    
    	}
    	return ret;
    }
     
    //测试
   	public static void main(String[] args) {
   		ApplicationContext ac=new ClassPathXmlApplicationContext("classpath:spring-mybatis.xml");
   		BussinessDevelopmentService test = (BussinessDevelopmentService) ac.getBean("BussinessDevelopmentService");
   		try {
   			//查询数据
   			Map<String,Object> map = test.getRow("A1001","F1001");
   			System.out.println(map.toString());
   		} catch (AppException e) {
   			e.printStackTrace();
   		}	    
   	}
}

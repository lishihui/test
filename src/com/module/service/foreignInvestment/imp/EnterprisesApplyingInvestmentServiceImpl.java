package com.module.service.foreignInvestment.imp;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import com.module.dao.base.CommonMapper;
import com.module.service.common.ItemUserApplyService;
import com.module.service.foreignInvestment.EnterprisesApplyingInvestmentService;
import com.util.AppException;

//外商投资申请企业投资者基本情况
@Service("EnterprisesApplyingInvestmentService")
public class EnterprisesApplyingInvestmentServiceImpl implements EnterprisesApplyingInvestmentService {
	
	@Resource
	private CommonMapper commonMapper;
	@Resource
	private ItemUserApplyService itemUserApplyService;
	
	//根据主键查询业务数据
    public Map<String,Object> getRow(String id,String flowrunid) throws AppException{ 
    	String Itemid=itemUserApplyService.getProcessId(id);
    	Map<String,Object> ret = new HashMap<String,Object>();
    	//查询业务主表记录ID
    	
    	Map<String,Object> map = commonMapper.findOneData("select * from DXXZSP_INVESTORS where itemid = '"+Itemid+"' or id = '"+id+"' ");

    	if(map !=null){
	    	String ywid = (String)map.get("ID");
	    	String itemid = (String)map.get("ITEMID");
	    	
	    	//查询展示数据
	    	List<Map<String,Object>> list_SQQYTZZJBQK =  commonMapper.findManyData("select * from DXXZSP_INVESTORS where id = '"+ywid+"'");
	    	List<Map<String,Object>> list_DTBGWFZRRGDXX =  commonMapper.findManyData("select * from DXXZSP_WZ_WFZRR where parentid = '"+ywid+"' ");
	    	List<Map<String,Object>> list_DTBGWFFRGDXX =  commonMapper.findManyData("select * from DXXZSP_WZ_WFFR where parentid = '"+ywid+"' ");
	    	List<Map<String,Object>> list_DTBGZFZRRGDXX =  commonMapper.findManyData("select * from DXXZSP_WZ_ZFZRR where parentid = '"+ywid+"' ");
	    	List<Map<String,Object>> list_DTBGZFFRGDXX =  commonMapper.findManyData("select * from DXXZSP_WZ_ZFFR where parentid = '"+ywid+"' ");

	    	
	    	ret.put("list_SQQYTZZJBQK", list_SQQYTZZJBQK);
	    	ret.put("list_DTBGWFZRRGDXX", list_DTBGWFZRRGDXX);
	    	ret.put("list_DTBGWFFRGDXX", list_DTBGWFFRGDXX);
	    	ret.put("list_DTBGZFZRRGDXX", list_DTBGZFZRRGDXX);
	    	ret.put("list_DTBGZFFRGDXX", list_DTBGZFFRGDXX);
	    
    	}
    	return ret;
    }
     
    //测试
   	public static void main(String[] args) {
   		ApplicationContext ac=new ClassPathXmlApplicationContext("classpath:spring-mybatis.xml");
   		EnterprisesApplyingInvestmentService test = (EnterprisesApplyingInvestmentService) ac.getBean("EnterprisesApplyingInvestmentService");
   		try {
   			//查询数据
   			Map<String,Object> map = test.getRow("A1001","F1001");
   			System.out.println(map.toString());
   		} catch (AppException e) {
   			e.printStackTrace();
   		}	    
   	}
}

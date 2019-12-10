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
import com.module.service.foreignInvestment.BasicSituationApplicantService;
import com.util.AppException;

//外商投资申请企业投资者基本情况
@Service("BasicSituationApplicantService")
public class BasicSituationApplicantImpl implements BasicSituationApplicantService {
	
	@Resource
	private CommonMapper commonMapper;
	@Resource
	private ItemUserApplyService itemUserApplyService;
	//根据主键查询业务数据
    public Map<String,Object> getRow(String id,String flowrunid) throws AppException{ 
    	String Itemid=itemUserApplyService.getProcessId(id);
    	Map<String,Object> ret = new HashMap<String,Object>();
    	//查询业务主表记录ID
    	
    	Map<String,Object> map = commonMapper.findOneData("select * from DXXZSP_BASICSITUATION where itemid = '"+Itemid+"' or id = '"+id+"' ");

    	if(map !=null){
	    	String ywid = (String)map.get("ID");
	    	String itemid = (String)map.get("ITEMID");
	    	
	    	//查询展示数据
	    	List<Map<String,Object>> list_BASICSITUATION =  commonMapper.findManyData("select * from DXXZSP_BASICSITUATION where id = '"+ywid+"'");
	    	List<Map<String,Object>> list_CELLULARMOVEMENT =  commonMapper.findManyData("select * from DXXZSP_CELLULARMOVEMENT where parentid = '"+ywid+"' ");
	    	List<Map<String,Object>> list_VIRTUALPRIVATENETW =  commonMapper.findManyData("select * from DXXZSP_VIRTUALPRIVATENETW where parentid = '"+ywid+"' ");
	    	List<Map<String,Object>> DXXZSP_STOREANDFORWARD =  commonMapper.findManyData("select * from DXXZSP_STOREANDFORWARD where parentid = '"+ywid+"' ");
	    	List<Map<String,Object>> list_SHUJUZHONGXINYEWU =  commonMapper.findManyData("select * from DXXZSP_SHUJUZHONGXINYEWU where parentid = '"+ywid+"' ");
          
	    	List<Map<String,Object>> list_PARSINGSERVICE =  commonMapper.findManyData("select * from DXXZSP_PARSINGSERVICE where parentid = '"+ywid+"' ");
	    	List<Map<String,Object>> list_NETWORKSERVICE =  commonMapper.findManyData("select * from DXXZSP_NETWORKSERVICE where parentid = '"+ywid+"' ");
	    	List<Map<String,Object>> list_INFORMATIONSERVICE =  commonMapper.findManyData("select * from DXXZSP_INFORMATIONSERVICE where parentid = '"+ywid+"' ");
	    	List<Map<String,Object>> list_EXCLUDINGINTERNET =  commonMapper.findManyData("select * from DXXZSP_EXCLUDINGINTERNET where parentid = '"+ywid+"' ");
	    	List<Map<String,Object>> list_DATAPROCESS =  commonMapper.findManyData("select * from DXXZSP_DATAPROCESS where parentid = '"+ywid+"' ");
	    	List<Map<String,Object>> list_COMMUNICATIONSERVI =  commonMapper.findManyData("select * from DXXZSP_COMMUNICATIONSERVI where parentid = '"+ywid+"' ");
	    	List<Map<String,Object>> list_CALLCENTERBUSINESS =  commonMapper.findManyData("select * from DXXZSP_CALLCENTERBUSINESS where parentid = '"+ywid+"' ");
	    	List<Map<String,Object>> list_ACCESSSERVICE =  commonMapper.findManyData("select * from DXXZSP_ACCESSSERVICE where parentid = '"+ywid+"' ");
	    	
	    	
	    	
	    	ret.put("list_BASICSITUATION", list_BASICSITUATION);
	    	ret.put("list_CELLULARMOVEMENT", list_CELLULARMOVEMENT);
	    	ret.put("list_VIRTUALPRIVATENETW", list_VIRTUALPRIVATENETW);
	    	ret.put("DXXZSP_STOREANDFORWARD", DXXZSP_STOREANDFORWARD);
	    	ret.put("list_SHUJUZHONGXINYEWU", list_SHUJUZHONGXINYEWU);
	    	
	    	ret.put("list_PARSINGSERVICE", list_PARSINGSERVICE);
	    	ret.put("list_NETWORKSERVICE", list_NETWORKSERVICE);
	    	ret.put("list_INFORMATIONSERVICE", list_INFORMATIONSERVICE);
	    	ret.put("list_EXCLUDINGINTERNET", list_EXCLUDINGINTERNET);
	    	ret.put("list_DATAPROCESS", list_DATAPROCESS);
	    	ret.put("list_COMMUNICATIONSERVI", list_COMMUNICATIONSERVI);
	    	ret.put("list_CALLCENTERBUSINESS", list_CALLCENTERBUSINESS);
	    	ret.put("list_ACCESSSERVICE", list_ACCESSSERVICE);
	    
    	}
    	return ret;
    }
     
    //测试
   	public static void main(String[] args) {
   		ApplicationContext ac=new ClassPathXmlApplicationContext("classpath:spring-mybatis.xml");
   		BasicSituationApplicantService test = (BasicSituationApplicantService) ac.getBean("BasicSituationApplicantService");
   		try {
   			//查询数据
   			Map<String,Object> map = test.getRow("A1001","F1001");
   			System.out.println(map.toString());
   		} catch (AppException e) {
   			e.printStackTrace();
   		}	    
   	}
}

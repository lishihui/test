package com.module.controller.demo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.module.annotation.SystemControllerLog;
import com.module.domain.base.Page;
import com.util.AppException;
import com.util.JsonUtil;
import com.module.domain.demo.DemoUser;
import com.module.service.demo.IDemoUserService;

//程序样例
@Controller
@RequestMapping("/DemoUser")
public class DemoUserController {
	
	@Resource
	private IDemoUserService iDemoUserService;
	
	//页面跳转
	@RequestMapping("/toDemoUser")
	public ModelAndView toDemoUser(){
		ModelAndView mv = new ModelAndView("demo/demoUser");
		return mv;
	}
		
	//页面跳转 审批样例 传入查询主键
	@RequestMapping("/toDemoUserAit")
	public ModelAndView toDemoUserAudit(String appuuid){
		ModelAndView mv = new ModelAndView("demo/demoUserAudit");
		mv.addObject("appuuid",appuuid);//
		return mv;
	}
	
	//查询业务数据
	@RequestMapping("/toGetRow")  
	@ResponseBody
	public Map<String,Object> toGetRow(String appuuid) throws AppException {
		Map<String,Object> map = new HashMap<String,Object>(); 
		map = iDemoUserService.getRow(appuuid);
        return map;  
	}
		
	//查询grid中数据
	@SystemControllerLog(description="查询人员记录")
	@RequestMapping("/toDataGrid")
	@ResponseBody
	public Map<String,Object> toDataGrid(Page<DemoUser> ph,HttpServletRequest request) throws AppException {
		Map<String,Object> map = new HashMap<String,Object>();  		        
		List<Map<String, Object>> list = iDemoUserService.getAllRow(ph);
		map.put("rows", list); 
    	map.put("total",ph.getTotalRecord());    	
    	return map;
	}

	//新增修改记录
	@SystemControllerLog(description="新增修改测试人员记录")
	@RequestMapping(value = "/toUpdateRow")  
	@ResponseBody
	public Map<String,Object> toUpdateRow(String jsonStr) throws AppException {
		Map<String,Object> map = new HashMap<String,Object>(); 
		DemoUser demoUser = JsonUtil.JsonToBean(jsonStr, DemoUser.class);
		if(demoUser.getFlag().equals("add")){
			map = iDemoUserService.insertRow(demoUser);//新增
		}else{
			map = iDemoUserService.updateRow(demoUser);//修改
		}
        return map;  
	}
		
	//删除记录
	@SystemControllerLog(description="删除测试人员记录")
	@RequestMapping("/toDeleteRow")  
	@ResponseBody
	public Map<String,Object> toDeleteRow(String uuid) throws AppException{
		Map<String,Object> map = new HashMap<String,Object>(); 
		map = iDemoUserService.deleteRow(uuid);
        return map;  
	}
	
}

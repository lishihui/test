package com.module.controller.broadbandAccService.comm;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.module.service.broadbandAccService.comm.BylawScriptService;
import com.util.AppException;

//公司章程(加盖工商局档案查询章原件)(bylawScript)
@Controller
@RequestMapping("/bylawScript")
public class BylawScriptController {
	
	@Resource
	private BylawScriptService bylawScriptService;
	
	//页面跳转
	@RequestMapping("/bylawScript")
	public ModelAndView informatSecurityMeasures(String id,String flowrunid) throws AppException {
		ModelAndView mv = new ModelAndView("broadbandAccService/comm/bylawScript");
		//业务查询
		Map<String,Object> data = bylawScriptService.getRow(id, flowrunid);
		mv.addObject("data", data);
		return mv;
	}
		
}

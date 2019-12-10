package com.module.controller.domainRegistration.apply.apply;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;




import com.module.service.domainRegistration.apply.apply.DxxzspRealNameVerSysDomService;
import com.util.AppException;

//1、实名核验系统对接情况
@Controller
@RequestMapping("/DxxzspRealNameVerSysDom")
public class DxxzspRealNameVerSysDomController {
	@Resource
	private DxxzspRealNameVerSysDomService DxxzspRealNameVerSysDomService;
	
	//页面跳转
	@RequestMapping("/toDxxzspRealNameVerSysDom")
	public ModelAndView toDxxzspRealNameVerSys(String id,String flowrunid) throws AppException {
		ModelAndView mv = new ModelAndView("domainRegistration/apply/apply/DxxzspRealNameVerSysDom");
		//业务查询
		Map<String,Object> data = DxxzspRealNameVerSysDomService.getRow(id, flowrunid);
		mv.addObject("data", data);
		System.out.println("**************************************");
		System.out.println(data);
		System.out.println("**************************************");
		return mv;
	}

}



package com.module.controller.domainRegistration.apply.apply;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


import com.module.service.domainRegistration.apply.apply.DxxzspImplementationPlanDomService;
import com.util.AppException;

//1、信息服务（仅限互联网信息服务）业务
@Controller
@RequestMapping("/DxxzspImplementationPlanDom")
public class DxxzspImplementationPlanDomController {
	@Resource
	private DxxzspImplementationPlanDomService DxxzspImplementationPlanDomService;
	
	//页面跳转
	@RequestMapping("/toDxxzspImplementationPlanDom")
	public ModelAndView toDxxzspImplementationPlanDom(String id,String flowrunid) throws AppException {
		ModelAndView mv = new ModelAndView("domainRegistration/apply/apply/DxxzspImplementationPlanDom");
		//业务查询
		Map<String,Object> data = DxxzspImplementationPlanDomService.getRow(id, flowrunid);
		mv.addObject("data", data);
//		System.out.println("**************************************");
//		System.out.println(mv);
//		System.out.println("**************************************");
		return mv;
	}

}


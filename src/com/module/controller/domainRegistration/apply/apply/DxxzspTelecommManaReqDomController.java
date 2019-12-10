package com.module.controller.domainRegistration.apply.apply;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


import com.module.service.domainRegistration.apply.apply.DxxzspTelecommManaReqDomService;
import com.util.AppException;

//1、信息服务（仅限互联网信息服务）业务
@Controller
@RequestMapping("/DxxzspTelecommManaReqDom")
public class DxxzspTelecommManaReqDomController {
	@Resource
	private DxxzspTelecommManaReqDomService DxxzspTelecommManaReqDomService;
	
	//页面跳转
	@RequestMapping("/toDxxzspTelecommManaReqDom")
	public ModelAndView toDxxzspTechnologyImplementation(String id,String flowrunid) throws AppException {
		ModelAndView mv = new ModelAndView("domainRegistration/apply/apply/DxxzspTelecommManaReqDom");
		//业务查询
		Map<String,Object> data = DxxzspTelecommManaReqDomService.getRow(id, flowrunid);
		mv.addObject("data", data);
		System.out.println("**************************************");
		System.out.println(mv);
		System.out.println("**************************************");
		return mv;
	}

}


package com.module.controller.registrationManagement.apply.apply;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


import com.module.service.registrationManagement.apply.apply.DxxzspTechnologyImplementationService;
import com.util.AppException;

//1、信息服务（仅限互联网信息服务）业务
@Controller
@RequestMapping("/DxxzspTechnologyImplementation")
public class DxxzspTechnologyImplementationController {
	@Resource
	private DxxzspTechnologyImplementationService DxxzspTechnologyImplementationService;
	
	//页面跳转
	@RequestMapping("/toDxxzspTechnologyImplementation")
	public ModelAndView toDxxzspTechnologyImplementation(String id,String flowrunid) throws AppException {
		ModelAndView mv = new ModelAndView("registrationManagement/apply/apply/DxxzspTechnologyImplementation");
		//业务查询
		Map<String,Object> data = DxxzspTechnologyImplementationService.getRow(id, flowrunid);
		mv.addObject("data", data);
//		System.out.println("**************************************");
//		System.out.println(mv);
//		System.out.println("**************************************");
		return mv;
	}

}


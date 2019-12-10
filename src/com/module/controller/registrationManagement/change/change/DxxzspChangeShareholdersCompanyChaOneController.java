package com.module.controller.registrationManagement.change.change;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


import com.module.service.registrationManagement.change.change.DxxzspChangeShareholdersCompanyChaService;
import com.util.AppException;

//1、信息服务（仅限互联网信息服务）业务
@Controller
@RequestMapping("/DxxzspChangeShareholdersCompanyChaOne")
public class DxxzspChangeShareholdersCompanyChaOneController {
	@Resource
	private DxxzspChangeShareholdersCompanyChaService DxxzspChangeShareholdersCompanyChaService;
	
	//页面跳转
	@RequestMapping("/toDxxzspChangeShareholdersCompanyChaOne")
	public ModelAndView toDxxzspChangeShareholdersCompanyChaOne(String id,String flowrunid) throws AppException {
		ModelAndView mv = new ModelAndView("registrationManagement/change/change/DxxzspChangeShareholdersCompanyChaOne");
		//业务查询
		Map<String,Object> data = DxxzspChangeShareholdersCompanyChaService.getRow(id, flowrunid);
		mv.addObject("data", data);
//		System.out.println("**************************************");
//		System.out.println(mv);
//		System.out.println("**************************************");
		return mv;
	}

}


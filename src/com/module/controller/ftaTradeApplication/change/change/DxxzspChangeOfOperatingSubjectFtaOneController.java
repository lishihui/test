package com.module.controller.ftaTradeApplication.change.change;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


import com.module.service.ftaTradeApplication.change.change.DxxzspChangeOfOperatingSubjectFtaService;
import com.util.AppException;

//1、信息服务（仅限互联网信息服务）业务
@Controller
@RequestMapping("/DxxzspChangeOfOperatingSubjectFtaOne")
public class DxxzspChangeOfOperatingSubjectFtaOneController {
	@Resource
	private DxxzspChangeOfOperatingSubjectFtaService DxxzspChangeOfOperatingSubjectFtaService;
	
	//页面跳转
	@RequestMapping("/toDxxzspChangeOfOperatingSubjectFtaOne")
	public ModelAndView toDxxzspChangeOfOperatingSubjectFtaOne(String id,String flowrunid) throws AppException {
		ModelAndView mv = new ModelAndView("ftaTradeApplication/change/change/DxxzspChangeOfOperatingSubjectFtaOne");
		//业务查询
		Map<String,Object> data = DxxzspChangeOfOperatingSubjectFtaService.getRow(id, flowrunid);
		mv.addObject("data", data);
//		System.out.println("**************************************");
//		System.out.println(mv);
//		System.out.println("**************************************");
		return mv;
	}

}


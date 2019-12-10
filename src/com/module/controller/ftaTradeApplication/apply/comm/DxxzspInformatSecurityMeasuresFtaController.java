package com.module.controller.ftaTradeApplication.apply.comm;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


import com.module.service.ftaTradeApplication.apply.comm.DxxzspInformatSecurityMeasuresFtaService;
import com.util.AppException;

//1、信息服务（仅限互联网信息服务）业务
@Controller
@RequestMapping("/DxxzspInformatSecurityMeasuresFta")
public class DxxzspInformatSecurityMeasuresFtaController {
	@Resource
	private DxxzspInformatSecurityMeasuresFtaService DxxzspInformatSecurityMeasuresFtaService;
	
	//页面跳转
	@RequestMapping("/toDxxzspInformatSecurityMeasuresFta")
	public ModelAndView toDxxzspInformatSecurityMeasuresFta(String id,String flowrunid) throws AppException {
		ModelAndView mv = new ModelAndView("ftaTradeApplication/apply/comm/DxxzspInformatSecurityMeasuresFta");
		//业务查询
		Map<String,Object> data = DxxzspInformatSecurityMeasuresFtaService.getRow(id, flowrunid);
		mv.addObject("data", data);
//		System.out.println("**************************************");
//		System.out.println(mv);
//		System.out.println("**************************************");
		return mv;
	}

}


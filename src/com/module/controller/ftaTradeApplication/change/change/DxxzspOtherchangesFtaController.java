package com.module.controller.ftaTradeApplication.change.change;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


import com.module.service.ftaTradeApplication.change.change.DxxzspOtherchangesFtaService;
import com.util.AppException;

//1、信息服务（仅限互联网信息服务）业务
@Controller
@RequestMapping("/DxxzspOtherchangesFta")
public class DxxzspOtherchangesFtaController {
	@Resource
	private DxxzspOtherchangesFtaService DxxzspOtherchangesFtaService;
	
	//页面跳转
	@RequestMapping("/toDxxzspOtherchangesFta")
	public ModelAndView toDxxzspOtherchangesFta(String id,String flowrunid) throws AppException {
		ModelAndView mv = new ModelAndView("ftaTradeApplication/change/change/DxxzspOtherchangesFta");
		//业务查询
		Map<String,Object> data = DxxzspOtherchangesFtaService.getRow(id, flowrunid);
		mv.addObject("data", data);
//		System.out.println("**************************************");
//		System.out.println(mv);
//		System.out.println("**************************************");
		return mv;
	}

}


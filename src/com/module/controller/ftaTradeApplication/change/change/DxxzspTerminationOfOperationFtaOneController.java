package com.module.controller.ftaTradeApplication.change.change;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


import com.module.service.ftaTradeApplication.change.change.DxxzspTerminationOfOperationFtaService;
import com.util.AppException;

//1、信息服务（仅限互联网信息服务）业务
@Controller
@RequestMapping("/DxxzspTerminationOfOperationFtaOne")
public class DxxzspTerminationOfOperationFtaOneController {
	@Resource
	private DxxzspTerminationOfOperationFtaService DxxzspTerminationOfOperationFtaService;
	
	//页面跳转
	@RequestMapping("/toDxxzspTerminationOfOperationFtaOne")
	public ModelAndView toDxxzspTerminationOfOperationFtaOne(String id,String flowrunid) throws AppException {
		ModelAndView mv = new ModelAndView("ftaTradeApplication/change/change/DxxzspTerminationOfOperationFtaOne");
		//业务查询
		Map<String,Object> data = DxxzspTerminationOfOperationFtaService.getRow(id, flowrunid);
		mv.addObject("data", data);
//		System.out.println("**************************************");
//		System.out.println(mv);
//		System.out.println("**************************************");
		return mv;
	}

}


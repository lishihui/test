package com.module.controller.ftaTradeApplication.apply.apply;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


import com.module.service.ftaTradeApplication.apply.apply.DxxzspDataProcessTransactionFtaService;
import com.util.AppException;

//1、信息服务（仅限互联网信息服务）业务
@Controller
@RequestMapping("/DxxzspDataProcessTransactionFta")
public class DxxzspDataProcessTransactionFtaController {
	@Resource
	private DxxzspDataProcessTransactionFtaService DxxzspDataProcessTransactionFtaService;
	
	//页面跳转
	@RequestMapping("/toDxxzspDataProcessTransactionFta")
	public ModelAndView toDxxzspStorageForwardSv(String id,String flowrunid) throws AppException {
		ModelAndView mv = new ModelAndView("ftaTradeApplication/apply/apply/DxxzspDataProcessTransactionFta");
		//业务查询
		Map<String,Object> data = DxxzspDataProcessTransactionFtaService.getRow(id, flowrunid);
		mv.addObject("data", data);
//		System.out.println("**************************************");
//		System.out.println(mv);
//		System.out.println("**************************************");
		return mv;
	}

}


package com.module.controller.ftaTradeApplication.apply.apply;


import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


import com.module.service.ftaTradeApplication.apply.apply.DxxzspInternetAccessServicesFtaService;
import com.util.AppException;

//1、固定网国内数据传送业务
@Controller
@RequestMapping("/DxxzspInternetAccessServicesFta")
public class DxxzspInternetAccessServicesFtaController {
	@Resource
	private DxxzspInternetAccessServicesFtaService DxxzspInternetAccessServicesFtaService;
	
	//页面跳转
	@RequestMapping("/toDxxzspInternetAccessServicesFta")
	public ModelAndView toDxxzspInternetAccessServicesFta(String id,String flowrunid) throws AppException {
		ModelAndView mv = new ModelAndView("ftaTradeApplication/apply/apply/DxxzspInternetAccessServicesFta");
		//业务查询
		Map<String,Object> data = DxxzspInternetAccessServicesFtaService.getRow(id, flowrunid);
		mv.addObject("data", data);
//		System.out.println("**************************************");
//		System.out.println(mv);
//		System.out.println("**************************************");
		return mv;
	}

}


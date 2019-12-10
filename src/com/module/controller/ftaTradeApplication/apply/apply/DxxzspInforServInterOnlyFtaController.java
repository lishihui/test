package com.module.controller.ftaTradeApplication.apply.apply;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;



import com.module.service.ftaTradeApplication.apply.apply.DxxzspInforServInterOnlyFtaService;
import com.util.AppException;

//1、信息服务(仅限互联网信息服务)业务
@Controller
@RequestMapping("/DxxzspInforServInterOnlyFta")
public class DxxzspInforServInterOnlyFtaController {
	@Resource
	private DxxzspInforServInterOnlyFtaService DxxzspInforServInterOnlyFtaService;
	
	//页面跳转
	@RequestMapping("/toDxxzspInforServInterOnlyFta")
	public ModelAndView toDxxzspInforServInterOnly(String id,String flowrunid) throws AppException {
		ModelAndView mv = new ModelAndView("ftaTradeApplication/apply/apply/DxxzspInforServInterOnlyFta");
		//业务查询
		Map<String,Object> data = DxxzspInforServInterOnlyFtaService.getRow(id, flowrunid);
		mv.addObject("data", data);
		System.out.println("**************************************");
		System.out.println(mv);
		System.out.println("**************************************");
		return mv;
	}

}


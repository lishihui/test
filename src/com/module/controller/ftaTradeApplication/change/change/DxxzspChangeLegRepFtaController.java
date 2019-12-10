package com.module.controller.ftaTradeApplication.change.change;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;



import com.module.service.ftaTradeApplication.change.change.DxxzspChangeLegRepFtaService;
import com.util.AppException;

//1、法定代表人变更
@Controller
@RequestMapping("/DxxzspChangeLegRepFta")
public class DxxzspChangeLegRepFtaController {
	@Resource
	private DxxzspChangeLegRepFtaService DxxzspChangeLegRepFtaService;
	
	//页面跳转
	@RequestMapping("/toDxxzspChangeLegRepFta")
	public ModelAndView toDxxzspChangeLegRepFta(String id,String flowrunid) throws AppException {
		ModelAndView mv = new ModelAndView("ftaTradeApplication/change/change/DxxzspChangeLegRepFta");
		//业务查询
		Map<String,Object> data = DxxzspChangeLegRepFtaService.getRow(id, flowrunid);
		mv.addObject("data", data);
		System.out.println("**************************************");
		System.out.println(mv);
		System.out.println("**************************************");
		return mv;
	}

}


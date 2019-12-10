package com.module.controller.ftaTradeApplication.change.change;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.module.service.ftaTradeApplication.change.change.DxxzspChangeOfCompanyFtaService;
import com.util.AppException;

@Controller
@RequestMapping("/DxxzspChangeOfCompanyFta")
public class DxxzspChangeOfCompanyFtaController {
	@Resource
	private DxxzspChangeOfCompanyFtaService dxxzspChangeOfCompanyFtaService;
	
	//页面跳转
	@RequestMapping("/toDxxzspChangeOfCompanyFta")
	public ModelAndView toDxxzspChangeOfCompanyFta(String id,String flowrunid) throws AppException {
		ModelAndView mv = new ModelAndView("ftaTradeApplication/change/change/DxxzspChangeOfCompanyFta");
		//业务查询
		Map<String,Object> data = dxxzspChangeOfCompanyFtaService.getRow(id, flowrunid);
		mv.addObject("data", data);
//		System.out.println("**************************************");
//		System.out.println(mv);
//		System.out.println("**************************************");
		return mv;
	}
}

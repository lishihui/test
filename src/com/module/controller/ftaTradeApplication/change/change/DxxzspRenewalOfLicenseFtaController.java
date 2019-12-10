package com.module.controller.ftaTradeApplication.change.change;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


import com.module.service.ftaTradeApplication.change.change.DxxzspRenewalOfLicenseFtaService;
import com.util.AppException;

//1、信息服务（仅限互联网信息服务）业务
@Controller
@RequestMapping("/DxxzspRenewalOfLicenseFta")
public class DxxzspRenewalOfLicenseFtaController {
	@Resource
	private DxxzspRenewalOfLicenseFtaService DxxzspRenewalOfLicenseFtaService;
	
	//页面跳转
	@RequestMapping("/toDxxzspRenewalOfLicenseFta")
	public ModelAndView toDxxzspRenewalOfLicenseFta(String id,String flowrunid) throws AppException {
		ModelAndView mv = new ModelAndView("ftaTradeApplication/change/change/DxxzspRenewalOfLicenseFta");
		//业务查询
		Map<String,Object> data = DxxzspRenewalOfLicenseFtaService.getRow(id, flowrunid);
		mv.addObject("data", data);
//		System.out.println("**************************************");
//		System.out.println(mv);
//		System.out.println("**************************************");
		return mv;
	}

}


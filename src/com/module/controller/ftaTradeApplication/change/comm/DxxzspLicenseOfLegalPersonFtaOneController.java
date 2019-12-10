package com.module.controller.ftaTradeApplication.change.comm;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


import com.module.service.ftaTradeApplication.change.comm.DxxzspLicenseOfLegalPersonFtaService;
import com.util.AppException;

//1、信息服务（仅限互联网信息服务）业务
@Controller
@RequestMapping("/DxxzspLicenseOfLegalPersonFtaOne")
public class DxxzspLicenseOfLegalPersonFtaOneController {
	@Resource
	private DxxzspLicenseOfLegalPersonFtaService DxxzspLicenseOfLegalPersonFtaService;
	
	//页面跳转
	@RequestMapping("/toDxxzspLicenseOfLegalPersonFtaOne")
	public ModelAndView toDxxzspLicenseOfLegalPersonFtaOne(String id,String flowrunid) throws AppException {
		ModelAndView mv = new ModelAndView("ftaTradeApplication/change/comm/DxxzspLicenseOfLegalPersonFtaOne");
		//业务查询
		Map<String,Object> data = DxxzspLicenseOfLegalPersonFtaService.getRow(id, flowrunid);
		mv.addObject("data", data);
//		System.out.println("**************************************");
//		System.out.println(mv);
//		System.out.println("**************************************");
		return mv;
	}

}


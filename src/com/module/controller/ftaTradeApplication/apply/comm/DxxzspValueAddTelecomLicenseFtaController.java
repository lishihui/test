package com.module.controller.ftaTradeApplication.apply.comm;


import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


import com.module.service.ftaTradeApplication.apply.comm.DxxzspValueAddTelecomLicenseFtaService;
import com.util.AppException;

//1、固定网国内数据传送业务
@Controller
@RequestMapping("/DxxzspValueAddTelecomLicenseFta")
public class DxxzspValueAddTelecomLicenseFtaController {
	@Resource
	private DxxzspValueAddTelecomLicenseFtaService DxxzspValueAddTelecomLicenseFtaService;
	
	//页面跳转
	@RequestMapping("/toDxxzspValueAddTelecomLicenseFta")
	public ModelAndView toDxxzspValueAddTelecomLicenseFta(String id,String flowrunid) throws AppException {
		ModelAndView mv = new ModelAndView("ftaTradeApplication/apply/comm/DxxzspValueAddTelecomLicenseFta");
		//业务查询
		Map<String,Object> data = DxxzspValueAddTelecomLicenseFtaService.getRow(id, flowrunid);
		mv.addObject("data", data);
//		System.out.println("**************************************");
//		System.out.println(mv);
//		System.out.println("**************************************");
		return mv;
	}

}


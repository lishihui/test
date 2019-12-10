package com.module.controller.ftaTradeApplication.apply.comm;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.module.service.ftaTradeApplication.apply.comm.DxxzspLetterOfOperatingTelecomFtaService;
import com.util.AppException;

//1、依法经营电信业务承诺书
@Controller
@RequestMapping("/DxxzspLetterOfOperatingTelecomFta")
public class DxxzspLetterOfOperatingTelecomFtaController {
	@Resource
	private DxxzspLetterOfOperatingTelecomFtaService dxxzspLetterOfOperatingTelecomFtaService;
	
	//页面跳转
	@RequestMapping("/toDxxzspLetterOfOperatingTelecomFta")
	public ModelAndView toDxxzspLetterOfOperatingTelecomFta(String id,String flowrunid) throws AppException {
		ModelAndView mv = new ModelAndView("ftaTradeApplication/apply/comm/DxxzspLetterOfOperatingTelecomFta");
		//业务查询
		Map<String,Object> data = dxxzspLetterOfOperatingTelecomFtaService.getRow(id, flowrunid);
		mv.addObject("data", data);
		/*System.out.println("**************************************");
		System.out.println(mv);
		System.out.println("**************************************");*/
		return mv;
	}
}

package com.module.controller.ftaTradeApplication.apply.comm;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.module.service.ftaTradeApplication.apply.comm.DxxzspForeignInvEntAppCerService;
import com.util.AppException;

@Controller
@RequestMapping("/DxxzspForeignInvEntAppCer")
public class DxxzspForeignInvEntAppCerController {
	@Resource
	private DxxzspForeignInvEntAppCerService DxxzspForeignInvEntAppCerService;
	
	//页面跳转
	@RequestMapping("/toDxxzspForeignInvEntAppCer")
	public ModelAndView toDxxzspValueAddTelecomLicense(String id,String flowrunid) throws AppException {
		ModelAndView mv = new ModelAndView("ftaTradeApplication/apply/comm/DxxzspForeignInvEntAppCer");
		//业务查询
		Map<String,Object> data = DxxzspForeignInvEntAppCerService.getRow(id, flowrunid);
		mv.addObject("data", data);
//		System.out.println("**************************************");
//		System.out.println(mv);
//		System.out.println("**************************************");
		return mv;
	}
}

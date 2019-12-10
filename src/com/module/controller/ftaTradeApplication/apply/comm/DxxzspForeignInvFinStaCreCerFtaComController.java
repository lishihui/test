package com.module.controller.ftaTradeApplication.apply.comm;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


import com.module.service.ftaTradeApplication.apply.comm.DxxzspForeignInvFinStaCreCerFtaComService;
import com.util.AppException;

//1、信息服务（仅限互联网信息服务）业务
@Controller
@RequestMapping("/DxxzspForeignInvFinStaCreCerFtaCom")
public class DxxzspForeignInvFinStaCreCerFtaComController {
	@Resource
	private DxxzspForeignInvFinStaCreCerFtaComService DxxzspForeignInvFinStaCreCerFtaComService;
	
	//页面跳转
	@RequestMapping("/toDxxzspForeignInvFinStaCreCerFtaCom")
	public ModelAndView toDxxzspStorageForwardSv(String id,String flowrunid) throws AppException {
		ModelAndView mv = new ModelAndView("ftaTradeApplication/apply/comm/DxxzspForeignInvFinStaCreCerFtaCom");
		//业务查询
		Map<String,Object> data = DxxzspForeignInvFinStaCreCerFtaComService.getRow(id, flowrunid);
		mv.addObject("data", data);
//		System.out.println("**************************************");
//		System.out.println(mv);
//		System.out.println("**************************************");
		return mv;
	}

}


package com.module.controller.ftaTradeApplication.apply.comm;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


import com.module.service.ftaTradeApplication.apply.comm.DxxzspShaTraRelCertMaterFtaService;
import com.util.AppException;

//1、信息服务（仅限互联网信息服务）业务
@Controller
@RequestMapping("/DxxzspShaTraRelCertMaterFta")
public class DxxzspShaTraRelCertMaterFtaController {
	@Resource
	private DxxzspShaTraRelCertMaterFtaService DxxzspShaTraRelCertMaterFtaService;
	
	//页面跳转
	@RequestMapping("/toDxxzspShaTraRelCertMaterFta")
	public ModelAndView toDxxzspShaTraRelCertMaterFta(String id,String flowrunid) throws AppException {
		ModelAndView mv = new ModelAndView("ftaTradeApplication/apply/comm/DxxzspShaTraRelCertMaterFta");
		//业务查询
		Map<String,Object> data = DxxzspShaTraRelCertMaterFtaService.getRow(id, flowrunid);
		mv.addObject("data", data);
//		System.out.println("**************************************");
//		System.out.println(mv);
//		System.out.println("**************************************");
		return mv;
	}

}


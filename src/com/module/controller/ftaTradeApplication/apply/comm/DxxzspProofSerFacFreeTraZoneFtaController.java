package com.module.controller.ftaTradeApplication.apply.comm;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


import com.module.service.ftaTradeApplication.apply.comm.DxxzspProofSerFacFreeTraZoneFtaService;
import com.util.AppException;

//1、信息服务（仅限互联网信息服务）业务
@Controller
@RequestMapping("/DxxzspProofSerFacFreeTraZoneFta")
public class DxxzspProofSerFacFreeTraZoneFtaController {
	@Resource
	private DxxzspProofSerFacFreeTraZoneFtaService DxxzspProofSerFacFreeTraZoneFtaService;
	
	//页面跳转
	@RequestMapping("/toDxxzspProofSerFacFreeTraZoneFta")
	public ModelAndView toDxxzspProofSerFacFreeTraZoneFta(String id,String flowrunid) throws AppException {
		ModelAndView mv = new ModelAndView("ftaTradeApplication/apply/comm/DxxzspProofSerFacFreeTraZoneFta");
		//业务查询
		Map<String,Object> data = DxxzspProofSerFacFreeTraZoneFtaService.getRow(id, flowrunid);
		mv.addObject("data", data);
//		System.out.println("**************************************");
//		System.out.println(mv);
//		System.out.println("**************************************");
		return mv;
	}

}


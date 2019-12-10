package com.module.controller.registrationManagement.change.comm;


import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


import com.module.service.registrationManagement.change.comm.DxxzspLegalPersonIDcardService;
import com.util.AppException;

//1、固定网国内数据传送业务
@Controller
@RequestMapping("/DxxzspLegalPersonIDcard")
public class DxxzspLegalPersonIDcardController {
	@Resource
	private DxxzspLegalPersonIDcardService DxxzspLegalPersonIDcardService;
	
	//页面跳转
	@RequestMapping("/toDxxzspLegalPersonIDcard")
	public ModelAndView toDxxzspLegalPersonIDcard(String id,String flowrunid) throws AppException {
		ModelAndView mv = new ModelAndView("registrationManagement/change/comm/DxxzspLegalPersonIDcard");
		//业务查询
		Map<String,Object> data = DxxzspLegalPersonIDcardService.getRow(id, flowrunid);
		mv.addObject("data", data);
//		System.out.println("**************************************");
//		System.out.println(mv);
//		System.out.println("**************************************");
		return mv;
	}

}


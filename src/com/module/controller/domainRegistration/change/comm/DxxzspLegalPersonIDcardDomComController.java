package com.module.controller.domainRegistration.change.comm;


import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


import com.module.service.domainRegistration.change.comm.DxxzspLegalPersonIDcardDomComService;
import com.util.AppException;

//1、固定网国内数据传送业务
@Controller
@RequestMapping("/DxxzspLegalPersonIDcardDomCom")
public class DxxzspLegalPersonIDcardDomComController {
	@Resource
	private DxxzspLegalPersonIDcardDomComService DxxzspLegalPersonIDcardDomComService;
	
	//页面跳转
	@RequestMapping("/toDxxzspLegalPersonIDcardDomCom")
	public ModelAndView toDxxzspLegalPersonIDcardDomCom(String id,String flowrunid) throws AppException {
		ModelAndView mv = new ModelAndView("domainRegistration/change/comm/DxxzspLegalPersonIDcardDomCom");
		//业务查询
		Map<String,Object> data = DxxzspLegalPersonIDcardDomComService.getRow(id, flowrunid);
		mv.addObject("data", data);
//		System.out.println("**************************************");
//		System.out.println(mv);
//		System.out.println("**************************************");
		return mv;
	}

}


package com.module.controller.domainRegistration.change.comm;


import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


import com.module.service.domainRegistration.change.comm.DxxzspLegalIntegrityDomComService;
import com.util.AppException;

//1、固定网国内数据传送业务
@Controller
@RequestMapping("/DxxzspLegalIntegrityDomCom")
public class DxxzspLegalIntegrityDomComController {
	@Resource
	private DxxzspLegalIntegrityDomComService DxxzspLegalIntegrityDomComService;
	
	//页面跳转
	@RequestMapping("/toDxxzspLegalIntegrityDomCom")
	public ModelAndView toDxxzspLegalIntegrityDomCom(String id,String flowrunid) throws AppException {
		ModelAndView mv = new ModelAndView("domainRegistration/change/comm/DxxzspLegalIntegrityDomCom");
		//业务查询
		Map<String,Object> data = DxxzspLegalIntegrityDomComService.getRow(id, flowrunid);
		mv.addObject("data", data);
//		System.out.println("**************************************");
//		System.out.println(mv);
//		System.out.println("**************************************");
		return mv;
	}

}


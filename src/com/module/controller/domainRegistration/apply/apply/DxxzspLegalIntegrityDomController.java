package com.module.controller.domainRegistration.apply.apply;


import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


import com.module.service.domainRegistration.apply.apply.DxxzspLegalIntegrityDomService;
import com.util.AppException;

//1、固定网国内数据传送业务
@Controller
@RequestMapping("/DxxzspLegalIntegrityDom")
public class DxxzspLegalIntegrityDomController {
	@Resource
	private DxxzspLegalIntegrityDomService DxxzspLegalIntegrityDomService;
	
	//页面跳转
	@RequestMapping("/toDxxzspLegalIntegrityDom")
	public ModelAndView toDxxzspLegalIntegrityDom(String id,String flowrunid) throws AppException {
		ModelAndView mv = new ModelAndView("domainRegistration/apply/apply/DxxzspLegalIntegrityDom");
		//业务查询
		Map<String,Object> data = DxxzspLegalIntegrityDomService.getRow(id, flowrunid);
		mv.addObject("data", data);
//		System.out.println("**************************************");
//		System.out.println(mv);
//		System.out.println("**************************************");
		return mv;
	}

}


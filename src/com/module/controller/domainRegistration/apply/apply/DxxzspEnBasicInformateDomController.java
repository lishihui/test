package com.module.controller.domainRegistration.apply.apply;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


import com.module.service.domainRegistration.apply.apply.DxxzspEnBasicInformateDomService;
import com.util.AppException;

//1、信息服务（仅限互联网信息服务）业务
@Controller
@RequestMapping("/DxxzspEnBasicInformateDom")
public class DxxzspEnBasicInformateDomController {
	@Resource
	private DxxzspEnBasicInformateDomService dxxzspEnBasicInformateDomService;
	
	//页面跳转
	@RequestMapping("/toDxxzspEnBasicInformateDom")
	public ModelAndView toDxxzspEnBasicInformateDom(String id,String flowrunid) throws AppException {
		ModelAndView mv = new ModelAndView("domainRegistration/apply/apply/DxxzspEnBasicInformateDom");
		//业务查询
		Map<String,Object> data = dxxzspEnBasicInformateDomService.getRow(id, flowrunid);
		mv.addObject("data", data);
//		System.out.println("**************************************");
//		System.out.println(mv);
//		System.out.println("**************************************");
		return mv;
	}

}


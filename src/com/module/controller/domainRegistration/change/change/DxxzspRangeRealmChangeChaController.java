package com.module.controller.domainRegistration.change.change;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


import com.module.service.domainRegistration.change.change.DxxzspRangeRealmChangeChaService;
import com.util.AppException;

//1、信息服务（仅限互联网信息服务）业务
@Controller
@RequestMapping("/DxxzspRangeRealmChangeCha")
public class DxxzspRangeRealmChangeChaController {
	@Resource
	private DxxzspRangeRealmChangeChaService DxxzspRangeRealmChangeChaService;
	
	//页面跳转
	@RequestMapping("/toDxxzspRangeRealmChangeCha")
	public ModelAndView toDxxzspAddressRealmChange(String id,String flowrunid) throws AppException {
		ModelAndView mv = new ModelAndView("domainRegistration/change/change/DxxzspRangeRealmChangeCha");
		//业务查询
		Map<String,Object> data = DxxzspRangeRealmChangeChaService.getRow(id, flowrunid);
		mv.addObject("data", data);
//		System.out.println("**************************************");
//		System.out.println(mv);
//		System.out.println("**************************************");
		return mv;
	}

}


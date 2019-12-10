package com.module.controller.domainRegistration.change.change;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


import com.module.service.domainRegistration.change.change.DxxzspLegalPersonRealmChangeService;
import com.util.AppException;

//1、信息服务（仅限互联网信息服务）业务
@Controller
@RequestMapping("/DxxzspLegalPersonRealmChange")
public class DxxzspLegalPersonRealmChangeController {
	@Resource
	private DxxzspLegalPersonRealmChangeService dxxzspLegalPersonRealmChangeService;
	
	//页面跳转
	@RequestMapping("/toDxxzspLegalPersonRealmChange")
	public ModelAndView toDxxzspLegalPersonRealmChange(String id,String flowrunid) throws AppException {
		ModelAndView mv = new ModelAndView("domainRegistration/change/change/DxxzspLegalPersonRealmChange");
		//业务查询
		Map<String,Object> data = dxxzspLegalPersonRealmChangeService.getRow(id, flowrunid);
		mv.addObject("data", data);
		return mv;
	}

}


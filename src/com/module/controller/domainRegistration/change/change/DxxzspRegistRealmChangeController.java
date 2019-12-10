package com.module.controller.domainRegistration.change.change;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.module.service.domainRegistration.change.change.DxxzspRegistRealmChangeService;
import com.util.AppException;

@Controller
@RequestMapping("/DxxzspRegistRealmChange")
public class DxxzspRegistRealmChangeController {
	@Resource
	private DxxzspRegistRealmChangeService dxxzspRegistRealmChangeService;
	
	//页面跳转
	@RequestMapping("/toDxxzspRegistRealmChange")
	public ModelAndView toDxxzspRegistRealmChange(String id,String flowrunid) throws AppException {
		ModelAndView mv = new ModelAndView("domainRegistration/change/change/DxxzspRegistRealmChange");
		//业务查询
		Map<String,Object> data = dxxzspRegistRealmChangeService.getRow(id, flowrunid);
		mv.addObject("data", data);
//		System.out.println("**************************************");
//		System.out.println(mv);
//		System.out.println("**************************************");
		return mv;
	}
}

package com.module.controller.domainRegistration.change.change;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.module.service.domainRegistration.change.change.DxxzspCompanyRealmChangeService;
import com.util.AppException;

@Controller
@RequestMapping("/DxxzspCompanyRealmChange")
public class DxxzspCompanyRealmChangeController {
	@Resource
	private DxxzspCompanyRealmChangeService DxxzspCompanyRealmChangeService;
	
	//页面跳转
	@RequestMapping("/toDxxzspCompanyRealmChange")
	public ModelAndView toDxxzspCompanyRealmChange(String id,String flowrunid) throws AppException {
		ModelAndView mv = new ModelAndView("domainRegistration/change/change/DxxzspCompanyRealmChange");
		//业务查询
		Map<String,Object> data = DxxzspCompanyRealmChangeService.getRow(id, flowrunid);
		mv.addObject("data", data);
//		System.out.println("**************************************");
//		System.out.println(mv);
//		System.out.println("**************************************");
		return mv;
	}
}

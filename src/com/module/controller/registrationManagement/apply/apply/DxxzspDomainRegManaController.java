package com.module.controller.registrationManagement.apply.apply;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.module.service.registrationManagement.apply.apply.DxxzspDomainRegManaService;
import com.util.AppException;

//1、域名注册管理相关制度
@Controller
@RequestMapping("/DxxzspDomainRegMana")
public class DxxzspDomainRegManaController {
	@Resource
	private DxxzspDomainRegManaService dxxzspDomainRegManaService;
	
	//页面跳转
	@RequestMapping("/toDxxzspDomainRegMana")
	public ModelAndView toDxxzspDomainRegMana(String id,String flowrunid) throws AppException {
		ModelAndView mv = new ModelAndView("registrationManagement/apply/apply/DxxzspDomainRegMana");
		//业务查询
		Map<String,Object> data = dxxzspDomainRegManaService.getRow(id, flowrunid);
		mv.addObject("data", data);
//		System.out.println("**************************************");
//		System.out.println(mv);
//		System.out.println("**************************************");
		return mv;
	}
}

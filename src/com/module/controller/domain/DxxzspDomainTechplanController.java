package com.module.controller.domain;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.module.service.domain.IDxxzspDomainTechplanService;
import com.util.AppException;

//5、技术实施方案表
@Controller
@RequestMapping("/DxxzspDomainTechplan")
public class DxxzspDomainTechplanController {
	
	@Resource
	private IDxxzspDomainTechplanService iDxxzspDomainTechplanService;
	
	//页面跳转
	@RequestMapping("/toDxxzspDomainTechplan")
	public ModelAndView toDxxzspDomainTechplan(String id,String flowrunid) throws AppException {
		ModelAndView mv = new ModelAndView("domain/DxxzspDomainTechplan");
		
		//业务查询
		Map<String,Object> data = iDxxzspDomainTechplanService.getRow(id, flowrunid);
		mv.addObject("data", data);
		return mv;
	}
		
}

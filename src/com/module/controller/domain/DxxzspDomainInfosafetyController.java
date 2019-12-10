package com.module.controller.domain;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.module.service.domain.IDxxzspDomainInfosafetyService;
import com.util.AppException;

//6、信息安全保障措施
@Controller
@RequestMapping("/DxxzspDomainInfosafety")
public class DxxzspDomainInfosafetyController {
	
	@Resource
	private IDxxzspDomainInfosafetyService iDxxzspDomainInfosafetyService;
	
	//页面跳转
	@RequestMapping("/toDxxzspDomainInfosafety")
	public ModelAndView toDxxzspDomainInfosafety(String id,String flowrunid) throws AppException {
		ModelAndView mv = new ModelAndView("domain/DxxzspDomainInfosafety");
		
		//业务查询
		Map<String,Object> data = iDxxzspDomainInfosafetyService.getRow(id, flowrunid);
		mv.addObject("data", data);
		return mv;
	}
		
}

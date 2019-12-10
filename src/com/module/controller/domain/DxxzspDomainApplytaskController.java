package com.module.controller.domain;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.module.service.domain.IDxxzspDomainApplytaskService;
import com.util.AppException;

//1、申请表单
@Controller
@RequestMapping("/DxxzspDomainApplytask")
public class DxxzspDomainApplytaskController {
	
	@Resource
	private IDxxzspDomainApplytaskService iDxxzspDomainApplytaskService;
	
	//页面跳转
	@RequestMapping("/toDxxzspDomainApplytask")
	public ModelAndView toDxxzspDomainApplytask(String id,String flowrunid) throws AppException {
		ModelAndView mv = new ModelAndView("domain/DxxzspDomainApplytask");
		//业务查询
		Map<String,Object> data = iDxxzspDomainApplytaskService.getRow(id, flowrunid);
		mv.addObject("data", data);
		return mv;
	}
		
}

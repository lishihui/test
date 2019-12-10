package com.module.controller.domain;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.module.service.domain.IDxxzspDomainBaseService;
import com.util.AppException;

//2、顶级域基本情况表
@Controller
@RequestMapping("/DxxzspDomainBase")
public class DxxzspDomainBaseController {
	
	@Resource
	private IDxxzspDomainBaseService iDxxzspDomainBaseService;
	
	//页面跳转
	@RequestMapping("/toDxxzspDomainBase")
	public ModelAndView toDxxzspDomainBase(String id,String flowrunid) throws AppException{
		ModelAndView mv = new ModelAndView("domain/DxxzspDomainBase");
		
		//业务查询
		Map<String,Object> data = iDxxzspDomainBaseService.getRow(id, flowrunid);
		mv.addObject("data", data);
		return mv;
	}
		
}

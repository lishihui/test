package com.module.controller.domainRegistration.apply.apply;


import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.module.service.domainRegistration.apply.apply.DxxzpRegistAgeManaSuperSysDomService;
import com.util.AppException;

//1、域名注册代理机构管理和监督制度
@Controller
@RequestMapping("/DxxzpRegistAgeManaSuperSysDom")
public class DxxzpRegistAgeManaSuperSysDomController {
	@Resource
	private DxxzpRegistAgeManaSuperSysDomService DxxzpRegistAgeManaSuperSysDomService;
	
	//页面跳转
	@RequestMapping("/toDxxzpRegistAgeManaSuperSysDom")
	public ModelAndView toDxxzpRegistAgeManaSuperSysDom(String id,String flowrunid) throws AppException {
		ModelAndView mv = new ModelAndView("domainRegistration/apply/apply/DxxzpRegistAgeManaSuperSysDom");
		//业务查询
		Map<String,Object> data = DxxzpRegistAgeManaSuperSysDomService.getRow(id, flowrunid);
		mv.addObject("data", data);
		System.out.println("**************************************");
		System.out.println(data);
		System.out.println("**************************************");
		return mv;
	}

}



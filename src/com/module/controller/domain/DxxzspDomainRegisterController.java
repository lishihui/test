package com.module.controller.domain;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.module.service.domain.IDxxzspDomainRegisterService;
import com.util.AppException;

//3、域名注册管理机构申请表  
@Controller
@RequestMapping("/DxxzspDomainRegister")
public class DxxzspDomainRegisterController {
	
	@Resource
	private IDxxzspDomainRegisterService iDxxzspDomainRegisterService;
	
	//页面跳转
	@RequestMapping("/toDxxzspDomainRegister")
	public ModelAndView toDxxzspDomainRegister(String id,String flowrunid) throws AppException {
		ModelAndView mv = new ModelAndView("domain/DxxzspDomainRegister");
		
		//业务查询
		Map<String,Object> data = iDxxzspDomainRegisterService.getRow(id, flowrunid);
		mv.addObject("data", data);
		return mv;
	}
		
}

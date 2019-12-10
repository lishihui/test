package com.module.controller.domain;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.module.service.domain.IDxxzspDomainManagementService;
import com.util.AppException;

//8、域名注册管理相关制度
@Controller
@RequestMapping("/DxxzspDomainManagement")
public class DxxzspDomainManagementController {
	
	@Resource
	private IDxxzspDomainManagementService iDxxzspDomainManagementService;
	
	//页面跳转
	@RequestMapping("/toDxxzspDomainManagement")
	public ModelAndView toDxxzspDomainManagement(String id,String flowrunid) throws AppException {
		ModelAndView mv = new ModelAndView("domain/DxxzspDomainManagement");
		
		//业务查询
		Map<String,Object> data = iDxxzspDomainManagementService.getRow(id, flowrunid);
		mv.addObject("data", data);
		return mv;
	}
		
}

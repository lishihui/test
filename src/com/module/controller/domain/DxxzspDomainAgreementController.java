package com.module.controller.domain;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.module.service.domain.IDxxzspDomainAgreementService;
import com.util.AppException;

//9、顶级域注册管理系统相关协议列表
@Controller
@RequestMapping("/DxxzspDomainAgreement")
public class DxxzspDomainAgreementController {
	
	@Resource
	private IDxxzspDomainAgreementService iDxxzspDomainAgreementService;
	
	//页面跳转
	@RequestMapping("/toDxxzspDomainAgreement")
	public ModelAndView toDxxzspDomainAgreement(String id,String flowrunid) throws AppException {
		ModelAndView mv = new ModelAndView("domain/DxxzspDomainAgreement");
		//业务查询
		Map<String,Object> data = iDxxzspDomainAgreementService.getRow(id, flowrunid);
		mv.addObject("data", data);
		return mv;
	}
		
}

package com.module.controller.domainRegistration.apply.apply;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.module.service.domainRegistration.apply.apply.DxxzspRulesforRegistrationDomService;
import com.util.AppException;

//1、域名注册实施细则
@Controller
@RequestMapping("/DxxzspRulesforRegistrationDom")
public class DxxzspRulesforRegistrationDomController {
	@Resource
	private DxxzspRulesforRegistrationDomService dxxzspRulesforRegistrationDomService;
	
	//页面跳转
	@RequestMapping("/toDxxzspRulesforRegistrationDom")
	public ModelAndView toDxxzspRulesforRegistrationDom(String id,String flowrunid) throws AppException {
		ModelAndView mv = new ModelAndView("domainRegistration/apply/apply/DxxzspRulesforRegistrationDom");
		//业务查询
		Map<String,Object> data = dxxzspRulesforRegistrationDomService.getRow(id, flowrunid);
		mv.addObject("data", data);
		/*System.out.println("**************************************");
		System.out.println(mv);
		System.out.println("**************************************");*/
		return mv;
	}
}

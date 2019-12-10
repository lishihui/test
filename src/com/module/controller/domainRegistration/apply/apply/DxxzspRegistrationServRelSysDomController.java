package com.module.controller.domainRegistration.apply.apply;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.module.service.domainRegistration.apply.apply.DxxzspRegistrationServRelSysDomService;
import com.util.AppException;

//1、域名注册服务相关系统情况
@Controller
@RequestMapping("/DxxzspRegistrationServRelSysDom")
public class DxxzspRegistrationServRelSysDomController {
	@Resource
	private DxxzspRegistrationServRelSysDomService dxxzspRegistrationServRelSysDomService;
	
	//页面跳转
	@RequestMapping("/toDxxzspRegistrationServRelSysDom")
	public ModelAndView toDxxzspRegistrationServRelSysDom(String id,String flowrunid) throws AppException {
		ModelAndView mv = new ModelAndView("domainRegistration/apply/apply/DxxzspRegistrationServRelSysDom");
		//业务查询
		Map<String,Object> data = dxxzspRegistrationServRelSysDomService.getRow(id, flowrunid);
		mv.addObject("data", data);
		/*System.out.println("**************************************");
		System.out.println(mv);
		System.out.println("**************************************");*/
		return mv;
	}
}

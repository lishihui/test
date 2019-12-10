package com.module.controller.domainRegistration.change.change;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.module.service.domainRegistration.change.change.DxxzspTerminationRealmChangeChaService;
import com.util.AppException;

//1、域名注册服务机构服务范围调整变更申请
@Controller
@RequestMapping("/DxxzspTerminationRealmChangeCha")
public class DxxzspTerminationRealmChangeChaController {
	@Resource
	private DxxzspTerminationRealmChangeChaService DxxzspTerminationRealmChangeChaService;
	
	//页面跳转
	@RequestMapping("/toDxxzspTerminationRealmChangeCha")
	public ModelAndView toDxxzspTerminationRealmChangeCha(String id,String flowrunid) throws AppException {
		ModelAndView mv = new ModelAndView("domainRegistration/change/change/DxxzspTerminationRealmChangeCha");
		//业务查询
		Map<String,Object> data = DxxzspTerminationRealmChangeChaService.getRow(id, flowrunid);
		mv.addObject("data", data);
		System.out.println("**************************************");
		System.out.println(data);
		System.out.println("**************************************");
		return mv;
	}

}


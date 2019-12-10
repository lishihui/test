package com.module.controller.domainRegistration.change.change;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.module.service.domainRegistration.change.change.DxxzspTerminationRealmChangeChaFouService;
import com.util.AppException;

//1、域名注册服务机构服务范围调整变更申请
@Controller
@RequestMapping("/DxxzspTerminationRealmChangeChaFou")
public class DxxzspTerminationRealmChangeChaFouController {
	@Resource
	private DxxzspTerminationRealmChangeChaFouService DxxzspTerminationRealmChangeChaFouService;
	
	//页面跳转
	@RequestMapping("/toDxxzspTerminationRealmChangeChaFou")
	public ModelAndView toDxxzspTerminationRealmChangeCha(String id,String flowrunid) throws AppException {
		ModelAndView mv = new ModelAndView("domainRegistration/change/change/DxxzspTerminationRealmChangeChaFou");
		//业务查询
		Map<String,Object> data = DxxzspTerminationRealmChangeChaFouService.getRow(id, flowrunid);
		mv.addObject("data", data);
		System.out.println("**************************************");
		System.out.println(data);
		System.out.println("**************************************");
		return mv;
	}

}


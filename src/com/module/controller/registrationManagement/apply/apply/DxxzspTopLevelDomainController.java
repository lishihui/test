package com.module.controller.registrationManagement.apply.apply;


import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


import com.module.service.registrationManagement.apply.apply.DxxzspTopLevelDomainService;
import com.util.AppException;

//1、固定网国内数据传送业务
@Controller
@RequestMapping("/DxxzspTopLevelDomain")
public class DxxzspTopLevelDomainController {
	@Resource
	private DxxzspTopLevelDomainService DxxzspTopLevelDomainService;
	
	//页面跳转
	@RequestMapping("/toDxxzspTopLevelDomain")
	public ModelAndView toDxxzspTopLevelDomain(String id,String flowrunid) throws AppException {
		ModelAndView mv = new ModelAndView("registrationManagement/apply/apply/DxxzspTopLevelDomain");
		//业务查询
		Map<String,Object> data = DxxzspTopLevelDomainService.getRow(id, flowrunid);
		mv.addObject("data", data);
//		System.out.println("**************************************");
//		System.out.println(mv);
//		System.out.println("**************************************");
		return mv;
	}

}


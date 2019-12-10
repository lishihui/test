package com.module.controller.internetDomainRootServices.apply.apply;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.module.service.internetDomainRootServices.apply.apply.DxxzspOperationOrganizationIntService;
import com.util.AppException;

//1、运营机构概况表格
@Controller
@RequestMapping("/DxxzspOperationOrganizationInt")
public class DxxzspOperationOrganizationIntController {
	@Resource
	private DxxzspOperationOrganizationIntService DxxzspOperationOrganizationIntService;
	
	//页面跳转
	@RequestMapping("/toDxxzspOperationOrganizationInt")
	public ModelAndView toDxxzspContentDistributionNetworkService(String id,String flowrunid) throws AppException {
		ModelAndView mv = new ModelAndView("internetDomainRootServices/apply/apply/DxxzspOperationOrganizationInt");
		//业务查询
		Map<String,Object> data = DxxzspOperationOrganizationIntService.getRow(id, flowrunid);
		mv.addObject("data", data);
		System.out.println("**************************************");
		System.out.println(data);
		System.out.println("**************************************");
		return mv;
	}

}



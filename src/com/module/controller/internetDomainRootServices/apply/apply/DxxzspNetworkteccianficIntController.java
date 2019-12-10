package com.module.controller.internetDomainRootServices.apply.apply;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.module.service.internetDomainRootServices.apply.apply.DxxzspNetworkteccianficIntService;
import com.util.AppException;

//1、网络托管技术人员相关资质
@Controller
@RequestMapping("/DxxzspNetworkteccianficInt")
public class DxxzspNetworkteccianficIntController {
	@Resource
	private DxxzspNetworkteccianficIntService DxxzspNetworkteccianficIntService;
	
	//页面跳转
	@RequestMapping("/toDxxzspNetworkteccianficInt")
	public ModelAndView toDxxzspNetworkteccianfic(String id,String flowrunid) throws AppException {
		ModelAndView mv = new ModelAndView("internetDomainRootServices/apply/apply/DxxzspNetworkteccianficInt");
		//业务查询
		Map<String,Object> data = DxxzspNetworkteccianficIntService.getRow(id, flowrunid);
		mv.addObject("data", data);
		System.out.println("**************************************");
		System.out.println(data);
		System.out.println("**************************************");
		return mv;
	}

}



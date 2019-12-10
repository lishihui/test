package com.module.controller.registrationManagement.change.change;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.module.service.registrationManagement.change.change.DxxzspRegistrationAddressChangeChaService;
import com.util.AppException;

//1、域名注册管理相关制度
@Controller
@RequestMapping("/DxxzspRegistrationAddressChangeCha")
public class DxxzspRegistrationAddressChangeChaController {
	@Resource
	private DxxzspRegistrationAddressChangeChaService dxxzspRegistrationAddressChangeChaService;
	
	//页面跳转
	@RequestMapping("/toDxxzspRegistrationAddressChangeCha")
	public ModelAndView toDxxzspRegistrationAddressChangeCha(String id,String flowrunid) throws AppException {
		ModelAndView mv = new ModelAndView("registrationManagement/change/change/DxxzspRegistrationAddressChangeCha");
		//业务查询
		Map<String,Object> data = dxxzspRegistrationAddressChangeChaService.getRow(id, flowrunid);
		mv.addObject("data", data);
		return mv;
	}
}



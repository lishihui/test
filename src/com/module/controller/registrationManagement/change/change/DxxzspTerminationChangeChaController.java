package com.module.controller.registrationManagement.change.change;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.module.service.registrationManagement.change.change.DxxzspTerminationChangeChaService;
import com.util.AppException;

//1、域名注册管理相关制度
@Controller
@RequestMapping("/DxxzspTerminationChangeCha")
public class DxxzspTerminationChangeChaController {
	@Resource
	private DxxzspTerminationChangeChaService dxxzspTerminationChangeChaService;
	
	//页面跳转
	@RequestMapping("/toDxxzspTerminationChangeCha")
	public ModelAndView toDxxzspTerminationChangeCha(String id,String flowrunid) throws AppException {
		ModelAndView mv = new ModelAndView("registrationManagement/change/change/DxxzspTerminationChangeCha");
		//业务查询
		Map<String,Object> data = dxxzspTerminationChangeChaService.getRow(id, flowrunid);
		mv.addObject("data", data);
		return mv;
	}
}

package com.module.controller.registrationManagement.change.change;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.module.service.registrationManagement.change.change.DxxzspBackgroundChangesChaService;
import com.util.AppException;

//1、公司技术后台变更
@Controller
@RequestMapping("/DxxzspBackgroundChangesCha")
public class DxxzspBackgroundChangesChaController {
	@Resource
	private DxxzspBackgroundChangesChaService dxxzspBackgroundChangesChaService;
	
	//页面跳转
	@RequestMapping("/toDxxzspBackgroundChangesCha")
	public ModelAndView toDxxzspBackgroundChangesCha(String id,String flowrunid) throws AppException {
		ModelAndView mv = new ModelAndView("registrationManagement/change/change/DxxzspBackgroundChangesCha");
		//业务查询
		Map<String,Object> data =dxxzspBackgroundChangesChaService.getRow(id, flowrunid);
		mv.addObject("data", data);
		/*System.out.println("**************************************");
		System.out.println(mv);
		System.out.println("**************************************");*/
		return mv;
	}
}

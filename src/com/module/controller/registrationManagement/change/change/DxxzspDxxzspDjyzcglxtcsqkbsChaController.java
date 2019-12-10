package com.module.controller.registrationManagement.change.change;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.module.service.registrationManagement.change.change.DxxzspDxxzspDjyzcglxtcsqkbsChaService;
import com.util.AppException;

//1、公司技术后台变更--顶级域注册管理系统场所情况表
@Controller
@RequestMapping("/DxxzspDxxzspDjyzcglxtcsqkbsCha")
public class DxxzspDxxzspDjyzcglxtcsqkbsChaController {
	@Resource
	private DxxzspDxxzspDjyzcglxtcsqkbsChaService dxxzspDxxzspDjyzcglxtcsqkbsChaService;
	
	//页面跳转
	@RequestMapping("/toDxxzspDxxzspDjyzcglxtcsqkbsCha")
	public ModelAndView toDxxzspDxxzspDjyzcglxtcsqkbsCha(String id,String flowrunid) throws AppException {
		ModelAndView mv = new ModelAndView("registrationManagement/change/change/DxxzspDxxzspDjyzcglxtcsqkbsCha");
		//业务查询
		Map<String,Object> data =dxxzspDxxzspDjyzcglxtcsqkbsChaService.getRow(id, flowrunid);
		mv.addObject("data", data);
		/*System.out.println("**************************************");
		System.out.println(mv);
		System.out.println("**************************************");*/
		return mv;
	}
}

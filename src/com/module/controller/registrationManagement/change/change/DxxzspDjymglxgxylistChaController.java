package com.module.controller.registrationManagement.change.change;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.module.service.registrationManagement.change.change.DxxzspDjymglxgxylistChaService;
import com.util.AppException;

//1、公司技术后台变更--顶级域注册管理系统相关协议
@Controller
@RequestMapping("/DxxzspDjymglxgxylistCha")
public class DxxzspDjymglxgxylistChaController {
	@Resource
	private DxxzspDjymglxgxylistChaService dxxzspDjymglxgxylistChaService;
	
	//页面跳转
	@RequestMapping("/toDxxzspDjymglxgxylistCha")
	public ModelAndView toDxxzspDjymglxgxylistCha(String id,String flowrunid) throws AppException {
		ModelAndView mv = new ModelAndView("registrationManagement/change/change/DxxzspDjymglxgxylistCha");
		//业务查询
		Map<String,Object> data =dxxzspDjymglxgxylistChaService.getRow(id, flowrunid);
		mv.addObject("data", data);
		/*System.out.println("**************************************");
		System.out.println(mv);
		System.out.println("**************************************");*/
		return mv;
	}
}

package com.module.controller.registrationManagement.change.change;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.module.service.registrationManagement.change.change.DxxzspDxxzspTechplanChangedChaService;
import com.util.AppException;

//1、公司技术后台变更--技术实施方案表
@Controller
@RequestMapping("/DxxzspDxxzspTechplanChangedCha")
public class DxxzspDxxzspTechplanChangedChaController {
	@Resource
	private DxxzspDxxzspTechplanChangedChaService dxxzspDxxzspTechplanChangedChaService;
	
	//页面跳转
	@RequestMapping("/toDxxzspDxxzspTechplanChangedCha")
	public ModelAndView toDxxzspDxxzspTechplanChangedCha(String id,String flowrunid) throws AppException {
		ModelAndView mv = new ModelAndView("registrationManagement/change/change/DxxzspDxxzspTechplanChangedCha");
		//业务查询
		Map<String,Object> data =dxxzspDxxzspTechplanChangedChaService.getRow(id, flowrunid);
		mv.addObject("data", data);
		/*System.out.println("**************************************");
		System.out.println(mv);
		System.out.println("**************************************");*/
		return mv;
	}
}

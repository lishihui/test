package com.module.controller.registrationManagement.apply.apply;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;



import com.module.service.registrationManagement.apply.apply.DxxzspTop_levelDomRegService;
import com.util.AppException;

//1、顶级域注册管理系统相关协议
@Controller
@RequestMapping("/DxxzspTop_levelDomReg")
public class DxxzspTop_levelDomRegController {
	@Resource
	private DxxzspTop_levelDomRegService DxxzspTop_levelDomRegService;
	
	//页面跳转
	@RequestMapping("/toDxxzspTop_levelDomReg")
	public ModelAndView toDxxzspSmallApertureEarthCommunication(String id,String flowrunid) throws AppException {
		ModelAndView mv = new ModelAndView("registrationManagement/apply/apply/DxxzspTop_levelDomReg");
		//业务查询
		Map<String,Object> data = DxxzspTop_levelDomRegService.getRow(id, flowrunid);
		mv.addObject("data", data);
		System.out.println("**************************************");
		System.out.println(mv);
		System.out.println("**************************************");
		return mv;
	}

}


package com.module.controller.ftaTradeApplication.apply.apply;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.module.service.ftaTradeApplication.apply.apply.DxxzspInforServInterFreeFtaService;
import com.util.AppException;

@Controller
@RequestMapping("/DxxzspInforServInterFreeFta")
public class DxxzspInforServInterFreeFtaController {
	@Resource
	private DxxzspInforServInterFreeFtaService dxxzspInforServInterFreeFtaService;
	
	//页面跳转
	@RequestMapping("/toDxxzspInforServInterFreeFta")
	public ModelAndView toDxxzspInforServInterFreeFta(String id,String flowrunid) throws AppException {
		ModelAndView mv = new ModelAndView("ftaTradeApplication/apply/apply/DxxzspInforServInterFreeFta");
		//业务查询
		Map<String,Object> data = dxxzspInforServInterFreeFtaService.getRow(id, flowrunid);
		mv.addObject("data", data);
//		System.out.println("**************************************");
//		System.out.println(mv);
//		System.out.println("**************************************");
		return mv;
	}
}

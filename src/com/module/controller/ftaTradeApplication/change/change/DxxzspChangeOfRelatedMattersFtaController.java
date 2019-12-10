package com.module.controller.ftaTradeApplication.change.change;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.module.service.ftaTradeApplication.change.change.DxxzspChangeOfRelatedMattersFtaService;
import com.util.AppException;

@Controller
@RequestMapping("/DxxzspChangeOfRelatedMattersFta")
public class DxxzspChangeOfRelatedMattersFtaController {
	@Resource
	private DxxzspChangeOfRelatedMattersFtaService DxxzspChangeOfRelatedMattersFtaService;
	
	//页面跳转
	@RequestMapping("/toDxxzspChangeOfRelatedMattersFta")
	public ModelAndView toDxxzspChangeOfRelatedMattersFta(String id,String flowrunid) throws AppException {
		ModelAndView mv = new ModelAndView("ftaTradeApplication/change/change/DxxzspChangeOfRelatedMattersFta");
		//业务查询
		Map<String,Object> data = DxxzspChangeOfRelatedMattersFtaService.getRow(id, flowrunid);
		mv.addObject("data", data);
//		System.out.println("**************************************");
//		System.out.println(mv);
//		System.out.println("**************************************");
		return mv;
	}
}

package com.module.controller.ftaTradeApplication.change.change;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.module.service.ftaTradeApplication.change.change.DxxzspReplenishmentOfLostFtaService;
import com.util.AppException;

@Controller
@RequestMapping("/DxxzspReplenishmentOfLostFta")
public class DxxzspReplenishmentOfLostFtaController {
	@Resource
	private DxxzspReplenishmentOfLostFtaService dxxzspReplenishmentOfLostFtaService;
	
	//页面跳转
	@RequestMapping("/toDxxzspReplenishmentOfLostFta")
	public ModelAndView toDxxzspReplenishmentOfLostFta(String id,String flowrunid) throws AppException {
		ModelAndView mv = new ModelAndView("ftaTradeApplication/change/change/DxxzspReplenishmentOfLostFta");
		//业务查询
		Map<String,Object> data = dxxzspReplenishmentOfLostFtaService.getRow(id, flowrunid);
		mv.addObject("data", data);
//		System.out.println("**************************************");
//		System.out.println(mv);
//		System.out.println("**************************************");
		return mv;
	}
}

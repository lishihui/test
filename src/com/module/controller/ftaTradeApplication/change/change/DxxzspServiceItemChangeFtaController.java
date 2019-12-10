package com.module.controller.ftaTradeApplication.change.change;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;



import com.module.service.ftaTradeApplication.change.change.DxxzspServiceItemChangeFtaService;
import com.util.AppException;

//1、服务项目变更
@Controller
@RequestMapping("/DxxzspServiceItemChangeFta")
public class DxxzspServiceItemChangeFtaController {
	@Resource
	private DxxzspServiceItemChangeFtaService DxxzspServiceItemChangeFtaService;
	
	//页面跳转
	@RequestMapping("/toDxxzspServiceItemChangeFta")
	public ModelAndView toDxxzspServiceItemChangeFta(String id,String flowrunid) throws AppException {
		ModelAndView mv = new ModelAndView("ftaTradeApplication/change/change/DxxzspServiceItemChangeFta");
		//业务查询
		Map<String,Object> data = DxxzspServiceItemChangeFtaService.getRow(id, flowrunid);
		mv.addObject("data", data);
		System.out.println("**************************************");
		System.out.println(mv);
		System.out.println("**************************************");
		return mv;
	}

}


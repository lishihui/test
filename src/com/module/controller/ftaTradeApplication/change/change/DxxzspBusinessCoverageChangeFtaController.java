package com.module.controller.ftaTradeApplication.change.change;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.module.service.ftaTradeApplication.change.change.DxxzspBusinessCoverageChangeFtaService;
import com.util.AppException;


//1、业务覆盖范围变更
@Controller
@RequestMapping("/DxxzspBusinessCoverageChangeFta")
public class DxxzspBusinessCoverageChangeFtaController {
	@Resource
	private DxxzspBusinessCoverageChangeFtaService dxxzspBusinessCoverageChangeFtaService;
	
	//页面跳转
	@RequestMapping("/toDxxzspBusinessCoverageChangeFta")
	public ModelAndView toDxxzspBusinessCoverageChangeFta(String id,String flowrunid) throws AppException {
		ModelAndView mv = new ModelAndView("ftaTradeApplication/change/change/DxxzspBusinessCoverageChangeFta");
		//业务查询
		Map<String,Object> data = dxxzspBusinessCoverageChangeFtaService.getRow(id, flowrunid);
		mv.addObject("data", data);
		/*System.out.println("**************************************");
		System.out.println(mv);
		System.out.println("**************************************");*/
		return mv;
	}
}

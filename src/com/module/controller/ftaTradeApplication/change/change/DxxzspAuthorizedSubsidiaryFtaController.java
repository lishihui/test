package com.module.controller.ftaTradeApplication.change.change;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.module.service.ftaTradeApplication.change.change.DxxzspAuthorizedSubsidiaryFtaService;
import com.util.AppException;


//1、授权子公司
@Controller
@RequestMapping("/DxxzspAuthorizedSubsidiaryFta")
public class DxxzspAuthorizedSubsidiaryFtaController {
	@Resource
	private DxxzspAuthorizedSubsidiaryFtaService dxxzspAuthorizedSubsidiaryFtaService;
	
	//页面跳转
	@RequestMapping("/toDxxzspAuthorizedSubsidiaryFta")
	public ModelAndView toDxxzspAuthorizedSubsidiaryFta(String id,String flowrunid) throws AppException {
		ModelAndView mv = new ModelAndView("ftaTradeApplication/change/change/DxxzspAuthorizedSubsidiaryFta");
		//业务查询
		Map<String,Object> data = dxxzspAuthorizedSubsidiaryFtaService.getRow(id, flowrunid);
		mv.addObject("data", data);
		/*System.out.println("**************************************");
		System.out.println(mv);
		System.out.println("**************************************");*/
		return mv;
	}
}

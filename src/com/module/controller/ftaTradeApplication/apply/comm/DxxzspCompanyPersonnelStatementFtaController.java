package com.module.controller.ftaTradeApplication.apply.comm;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.module.service.ftaTradeApplication.apply.comm.DxxzspCompanyPersonnelStatementFtaService;
import com.util.AppException;

@Controller
@RequestMapping("/DxxzspCompanyPersonnelStatementFta")
public class DxxzspCompanyPersonnelStatementFtaController {
	@Resource
	private DxxzspCompanyPersonnelStatementFtaService DxxzspCompanyPersonnelStatementFtaService;
	
	//页面跳转
	@RequestMapping("/toDxxzspCompanyPersonnelStatementFta")
	public ModelAndView toDxxzspValueAddTelecomLicense(String id,String flowrunid) throws AppException {
		ModelAndView mv = new ModelAndView("ftaTradeApplication/apply/comm/DxxzspCompanyPersonnelStatementFta");
		//业务查询
		Map<String,Object> data = DxxzspCompanyPersonnelStatementFtaService.getRow(id, flowrunid);
		mv.addObject("data", data);
//		System.out.println("**************************************");
//		System.out.println(mv);
//		System.out.println("**************************************");
		return mv;
	}
}

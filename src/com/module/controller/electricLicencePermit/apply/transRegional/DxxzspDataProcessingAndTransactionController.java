package com.module.controller.electricLicencePermit.apply.transRegional;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.module.service.electricLicencePermit.apply.transRegional.DxxzspDataProcessingAndTransactionService;
import com.util.AppException;

//1、国内甚小口径终端地球站通信业务
@Controller
@RequestMapping("/DxxzspDataProcessingAndTransaction")
public class DxxzspDataProcessingAndTransactionController {
	@Resource
	private DxxzspDataProcessingAndTransactionService dxxzspDataProcessingAndTransactionService;
	
	//页面跳转
	@RequestMapping("/toDxxzspDataProcessingAndTransaction")
	public ModelAndView toDxxzspDataProcessingAndTransaction(String id,String flowrunid) throws AppException {
		ModelAndView mv = new ModelAndView("electricLicencePermit/apply/transRegional/DxxzspDataProcessingAndTransaction");
		//业务查询
		Map<String,Object> data = dxxzspDataProcessingAndTransactionService.getRow(id, flowrunid);
		mv.addObject("data", data);
//		System.out.println("**************************************");
//		System.out.println(mv);
//		System.out.println("**************************************");
		return mv;
	}
}

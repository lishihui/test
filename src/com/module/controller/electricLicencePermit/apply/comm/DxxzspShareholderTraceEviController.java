package com.module.controller.electricLicencePermit.apply.comm;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.module.service.electricLicencePermit.apply.comm.DxxzspShareholderTraceEviService;
import com.util.AppException;
//股东追溯及其相关证明材料(shareholderTraceEvi)
@Controller
@RequestMapping("/DxxzspShareholderTraceEvi")
public class DxxzspShareholderTraceEviController {
	@Resource
	private DxxzspShareholderTraceEviService dxxzspShareholderTraceEviService;
	
	//页面跳转
	@RequestMapping("/toDxxzspShareholderTraceEvi")
	public ModelAndView toDxxzspShareholderTraceEvi(String id,String flowrunid) throws AppException {
		ModelAndView mv = new ModelAndView("electricLicencePermit/apply/comm/DxxzspShareholderTraceEvi");
		//业务查询
		Map<String,Object> data = dxxzspShareholderTraceEviService.getRow(id, flowrunid);
		mv.addObject("data", data);
		return mv;
	}
}

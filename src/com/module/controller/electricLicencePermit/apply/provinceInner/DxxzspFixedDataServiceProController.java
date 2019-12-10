package com.module.controller.electricLicencePermit.apply.provinceInner;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


import com.module.service.electricLicencePermit.apply.provinceInner.DxxzspFixedDataServiceProService;
import com.util.AppException;

//固定网国内数据传送业务（fixedDataService）
@Controller
@RequestMapping("/DxxzspFixedDataServicePro")
public class DxxzspFixedDataServiceProController {
	@Resource
	private DxxzspFixedDataServiceProService DxxzspFixedDataServiceProService;
	
	//页面跳转
	@RequestMapping("/toDxxzspFixedDataServicePro")
	public ModelAndView toDxxzspFixedDataServicePro(String id,String flowrunid) throws AppException {
		ModelAndView mv = new ModelAndView("electricLicencePermit/apply/provinceInner/DxxzspFixedDataServicePro");
		//业务查询
		Map<String,Object> data = DxxzspFixedDataServiceProService.getRow(id, flowrunid);
		mv.addObject("data", data);
		return mv;
	}

}


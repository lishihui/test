package com.module.controller.electricLicencePermit.apply.provinceInner;


import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


import com.module.service.electricLicencePermit.apply.provinceInner.DxxzspCommercialConCommResProService;
import com.util.AppException;

//与基础运营商签订的移动通信转售业务商业合同(commercialConCommRes)
@Controller
@RequestMapping("/DxxzspCommercialConCommResPro")
public class DxxzspCommercialConCommResProController {
	@Resource
	private DxxzspCommercialConCommResProService DxxzspCommercialConCommResProService;
	
	//页面跳转
	@RequestMapping("/toDxxzspCommercialConCommResPro")
	public ModelAndView toDxxzspCommercialConCommResPro(String id,String flowrunid) throws AppException {
		ModelAndView mv = new ModelAndView("electricLicencePermit/apply/provinceInner/DxxzspCommercialConCommResPro");
		//业务查询
		Map<String,Object> data = DxxzspCommercialConCommResProService.getRow(id, flowrunid);
		mv.addObject("data", data);
		return mv;
	}

}


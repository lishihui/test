package com.module.controller.electricLicencePermit.apply.provinceInner;


import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


import com.module.service.electricLicencePermit.apply.provinceInner.DxxzspInforServExcInterProService;
import com.util.AppException;

//信息服务（不含互联网信息服务）业务(inforServExcInter)
@Controller
@RequestMapping("/DxxzspInforServExcInterPro")
public class DxxzspInforServExcInterProController {
	@Resource
	private DxxzspInforServExcInterProService DxxzspInforServExcInterProService;
	
	//页面跳转
	@RequestMapping("/toDxxzspInforServExcInterPro")
	public ModelAndView toDxxzspSmallApertureEarthCommunication(String id,String flowrunid) throws AppException {
		ModelAndView mv = new ModelAndView("electricLicencePermit/apply/provinceInner/DxxzspInforServExcInterPro");
		//业务查询
		Map<String,Object> data = DxxzspInforServExcInterProService.getRow(id, flowrunid);
		mv.addObject("data", data);
		return mv;
	}

}


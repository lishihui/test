package com.module.controller.electricLicencePermit.change.provinceInnerChange;


import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;




import com.module.service.electricLicencePermit.change.provinceInnerChange.DxxzspServiceItemChangeChaProService;
import com.util.AppException;

//服务项目变更(serviceItemChange)
@Controller
@RequestMapping("/DxxzspServiceItemChangeChaPro")
public class DxxzspServiceItemChangeChaProController {
	@Resource
	private DxxzspServiceItemChangeChaProService DxxzspServiceItemChangeChaProService;
	
	//页面跳转
	@RequestMapping("/toDxxzspServiceItemChangeChaPro")
	public ModelAndView toDxxzspServiceItemChangeChaPro(String id,String flowrunid) throws AppException {
		ModelAndView mv = new ModelAndView("electricLicencePermit/change/provinceInnerChange/DxxzspServiceItemChangeChaPro");
		//业务查询
		Map<String,Object> data = DxxzspServiceItemChangeChaProService.getRow(id, flowrunid);
		mv.addObject("data", data);
		return mv;
	}

}


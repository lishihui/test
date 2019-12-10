package com.module.controller.electricLicencePermit.apply.comm;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


import com.module.service.electricLicencePermit.apply.comm.DxxzspLetterOfOperatingTelecomProService;
import com.util.AppException;
//依法经营电信业务承诺书(letterOfOperatingTelecom)
@Controller
@RequestMapping("/DxxzspLetterOfOperatingTelecomPro")
public class DxxzspLetterOfOperatingTelecomProController {
	@Resource
	private DxxzspLetterOfOperatingTelecomProService DxxzspLetterOfOperatingTelecomProService;
	
	//页面跳转
	@RequestMapping("/toDxxzspLetterOfOperatingTelecomPro")
	public ModelAndView toDxxzspLetterOfOperatingTelecomPro(String id,String flowrunid) throws AppException {
		ModelAndView mv = new ModelAndView("electricLicencePermit/apply/comm/DxxzspLetterOfOperatingTelecomPro");
		//业务查询
		Map<String,Object> data = DxxzspLetterOfOperatingTelecomProService.getRow(id, flowrunid);
		mv.addObject("data", data);
		return mv;
	}

}


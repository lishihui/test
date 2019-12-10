package com.module.controller.electricLicencePermit.apply.transRegional;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.module.service.electricLicencePermit.apply.transRegional.DxxzspDomainNameResolutionService;
import com.util.AppException;

@Controller
@RequestMapping("/DxxzspDomainNameResolution")
public class DxxzspDomainNameResolutionController {
	@Resource
	private DxxzspDomainNameResolutionService dxxzspDomainNameResolutionService;
	
	//页面跳转
	@RequestMapping("/toDxxzspDomainNameResolution")
	public ModelAndView toDxxzspDomainNameResolution(String id,String flowrunid) throws AppException {
		ModelAndView mv = new ModelAndView("electricLicencePermit/apply/transRegional/DxxzspDomainNameResolution");
		//业务查询
		Map<String,Object> data = dxxzspDomainNameResolutionService.getRow(id, flowrunid);
		mv.addObject("data", data);
//		System.out.println("**************************************");
//		System.out.println(mv);
//		System.out.println("**************************************");
		return mv;
	}
}

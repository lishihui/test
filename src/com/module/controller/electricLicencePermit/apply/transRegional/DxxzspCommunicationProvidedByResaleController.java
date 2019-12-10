package com.module.controller.electricLicencePermit.apply.transRegional;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.module.service.electricLicencePermit.apply.transRegional.DxxzspCommunicationProvidedByResaleService;
import com.util.AppException;

@Controller
@RequestMapping("/DxxzspCommunicationProvidedByResale")
public class DxxzspCommunicationProvidedByResaleController {
	@Resource
	private DxxzspCommunicationProvidedByResaleService dxxzspCommunicationProvidedByResaleService;
	
	//页面跳转
	@RequestMapping("/toDxxzspCommunicationProvidedByResale")
	public ModelAndView toDxxzspCommunicationProvidedByResale(String id,String flowrunid) throws AppException {
		ModelAndView mv = new ModelAndView("electricLicencePermit/apply/transRegional/DxxzspCommunicationProvidedByResale");
		//业务查询
		Map<String,Object> data = dxxzspCommunicationProvidedByResaleService.getRow(id, flowrunid);
		mv.addObject("data", data);
//		System.out.println("**************************************");
//		System.out.println(mv);
//		System.out.println("**************************************");
		return mv;
	}
}

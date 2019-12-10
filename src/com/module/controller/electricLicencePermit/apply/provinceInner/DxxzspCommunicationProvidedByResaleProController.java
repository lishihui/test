package com.module.controller.electricLicencePermit.apply.provinceInner;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.module.service.electricLicencePermit.apply.provinceInner.DxxzspCommunicationProvidedByResaleProService;
import com.util.AppException;
//通过转售方式提供的蜂窝移动通信业务(communicationProvRes)
@Controller
@RequestMapping("/DxxzspCommunicationProvidedByResalePro")
public class DxxzspCommunicationProvidedByResaleProController {
	@Resource
	private DxxzspCommunicationProvidedByResaleProService dxxzspCommunicationProvidedByResaleProService;
	
	//页面跳转
	@RequestMapping("/toDxxzspCommunicationProvidedByResalePro")
	public ModelAndView toDxxzspCommunicationProvidedByResale(String id,String flowrunid) throws AppException {
		ModelAndView mv = new ModelAndView("electricLicencePermit/apply/provinceInner/DxxzspCommunicationProvResPro");
		//业务查询
		Map<String,Object> data = dxxzspCommunicationProvidedByResaleProService.getRow(id, flowrunid);
		mv.addObject("data", data);
		return mv;
	}
}

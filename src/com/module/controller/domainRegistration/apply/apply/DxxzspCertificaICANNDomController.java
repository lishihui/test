package com.module.controller.domainRegistration.apply.apply;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.module.service.domainRegistration.apply.apply.DxxzspCertificaICANNDomService;
import com.util.AppException;

@Controller
@RequestMapping("/DxxzspCertificaICANNDom")
public class DxxzspCertificaICANNDomController {
	@Resource
	private DxxzspCertificaICANNDomService dxxzspCertificaICANNDomService;
	
	//页面跳转
	@RequestMapping("/toDxxzspValueAddTelecomLicense")
	public ModelAndView toDxxzspValueAddTelecomLicense(String id,String flowrunid) throws AppException {
		ModelAndView mv = new ModelAndView("domainRegistration/apply/apply/DxxzspCertificaICANNDom");
		//业务查询
		Map<String,Object> data = dxxzspCertificaICANNDomService.getRow(id, flowrunid);
		mv.addObject("data", data);
//		System.out.println("**************************************");
//		System.out.println(mv);
//		System.out.println("**************************************");
		return mv;
	}
}

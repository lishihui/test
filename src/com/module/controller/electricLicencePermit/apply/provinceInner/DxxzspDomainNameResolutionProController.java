package com.module.controller.electricLicencePermit.apply.provinceInner;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.module.service.electricLicencePermit.apply.provinceInner.DxxzspDomainNameResolutionProService;
import com.util.AppException;
//互联网域名解析服务业务(domainNameResolution)
@Controller
@RequestMapping("/DxxzspDomainNameResolutionPro")
public class DxxzspDomainNameResolutionProController {
	@Resource
	private DxxzspDomainNameResolutionProService dxxzspDomainNameResolutionProService;
	
	//页面跳转
	@RequestMapping("/toDxxzspDomainNameResolutionPro")
	public ModelAndView toDxxzspDomainNameResolution(String id,String flowrunid) throws AppException {
		ModelAndView mv = new ModelAndView("electricLicencePermit/apply/provinceInner/DxxzspDomainNameResolutionPro");
		//业务查询
		Map<String,Object> data = dxxzspDomainNameResolutionProService.getRow(id, flowrunid);
		mv.addObject("data", data);
		return mv;
	}
}

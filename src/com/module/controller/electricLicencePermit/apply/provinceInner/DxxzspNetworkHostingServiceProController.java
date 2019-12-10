package com.module.controller.electricLicencePermit.apply.provinceInner;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.module.service.electricLicencePermit.apply.provinceInner.DxxzspNetworkHostingServiceProService;
import com.util.AppException;

//网络托管业务(networkHostingService)
@Controller
@RequestMapping("/DxxzspNetworkHostingServicePro")
public class DxxzspNetworkHostingServiceProController {
	@Resource
	private DxxzspNetworkHostingServiceProService dxxzspNetworkHostingServiceProService;
	
	//页面跳转
	@RequestMapping("/toDxxzspNetworkHostingServicePro")
	public ModelAndView toDxxzspNetworkHostingServicePro(String id,String flowrunid) throws AppException {
		ModelAndView mv = new ModelAndView("electricLicencePermit/apply/provinceInner/DxxzspNetworkHostingServicePro");
		//业务查询
		Map<String,Object> data = dxxzspNetworkHostingServiceProService.getRow(id, flowrunid);
		mv.addObject("data", data);
			return mv;
	}
}

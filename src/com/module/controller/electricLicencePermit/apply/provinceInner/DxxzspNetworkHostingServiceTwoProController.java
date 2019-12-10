package com.module.controller.electricLicencePermit.apply.provinceInner;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.module.service.electricLicencePermit.apply.provinceInner.DxxzspNetworkHostingServiceTwoProService;
import com.util.AppException;

////网络托管业务(networkHostingServiceTwo)
@Controller
@RequestMapping("/DxxzspNetworkHostingServiceTwoPro")
public class DxxzspNetworkHostingServiceTwoProController {
	@Resource
	private DxxzspNetworkHostingServiceTwoProService dxxzspNetworkHostingServiceTwoProService;
	
	//页面跳转
	@RequestMapping("/toDxxzspNetworkHostingServiceTwoPro")
	public ModelAndView toDxxzspNetworkHostingServiceTwoPro(String id,String flowrunid) throws AppException {
		ModelAndView mv = new ModelAndView("electricLicencePermit/apply/provinceInner/DxxzspNetworkHostingServiceTwoPro");
		//业务查询
		Map<String,Object> data = dxxzspNetworkHostingServiceTwoProService.getRow(id, flowrunid);
		mv.addObject("data", data);
		return mv;
	}
}

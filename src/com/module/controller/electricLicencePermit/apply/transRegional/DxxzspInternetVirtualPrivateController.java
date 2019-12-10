package com.module.controller.electricLicencePermit.apply.transRegional;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.module.service.electricLicencePermit.apply.transRegional.DxxzspInternetVirtualPrivateService;
import com.util.AppException;

//1、国内互联网虚拟专用网业务
@Controller
@RequestMapping("/DxxzspInternetVirtualPrivateServ")
public class DxxzspInternetVirtualPrivateController {
	@Resource
	private DxxzspInternetVirtualPrivateService DxxzspInternetVirtualPrivateService;

	// 页面跳转
	@RequestMapping("/toDxxzspInternetVirtualPrivateServ")
	public ModelAndView toDxxzspInternetVirtualPrivateServ(String id,
			String flowrunid) throws AppException {
		ModelAndView mv = new ModelAndView(
				"electricLicencePermit/apply/transRegional/DxxzspInternetVirtualPrivate");
		// 业务查询
		Map<String, Object> data = DxxzspInternetVirtualPrivateService.getRow(
				id, flowrunid);
		mv.addObject("data", data);
//		System.out.println("**************************************");
//		System.out.println(mv);
//		System.out.println("**************************************");
		return mv;
	}

}

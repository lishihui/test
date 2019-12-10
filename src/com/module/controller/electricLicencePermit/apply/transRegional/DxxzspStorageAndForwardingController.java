package com.module.controller.electricLicencePermit.apply.transRegional;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;



import com.module.service.electricLicencePermit.apply.transRegional.DxxzspStorageAndForwardingService;
import com.util.AppException;

//1、存储转发类业务
@Controller
@RequestMapping("/DxxzspStorageAndForwarding")
public class DxxzspStorageAndForwardingController {
	@Resource
	private DxxzspStorageAndForwardingService DxxzspStorageAndForwardingService;
	
	//页面跳转
	@RequestMapping("/toDxxzspstorageAndForwarding")
	public ModelAndView toDxxzspstorageAndForwarding(String id,String flowrunid) throws AppException {
		ModelAndView mv = new ModelAndView("electricLicencePermit/apply/transRegional/DxxzspStorageAndForwarding");
		//业务查询
		Map<String,Object> data = DxxzspStorageAndForwardingService.getRow(id, flowrunid);
		mv.addObject("data", data);
//		System.out.println("**************************************");
//		System.out.println(mv);
//		System.out.println("**************************************");
		return mv;
	}

}

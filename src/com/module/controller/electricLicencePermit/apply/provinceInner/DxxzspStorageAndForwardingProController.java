package com.module.controller.electricLicencePermit.apply.provinceInner;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.module.service.electricLicencePermit.apply.provinceInner.DxxzspStorageAndForwardingProService;
import com.util.AppException;

//存储转发类业务(storageAndForwarding)
@Controller
@RequestMapping("/DxxzspStorageAndForwardingPro")
public class DxxzspStorageAndForwardingProController {
	@Resource
	private DxxzspStorageAndForwardingProService dxxzspStorageAndForwardingProService;
	
	//页面跳转
	@RequestMapping("/toDxxzspStorageAndForwardingPro")
	public ModelAndView toDxxzspStorageAndForwardingPro(String id,String flowrunid) throws AppException {
		ModelAndView mv = new ModelAndView("electricLicencePermit/apply/provinceInner/DxxzspStorageAndForwardingPro");
		//业务查询
		Map<String,Object> data = dxxzspStorageAndForwardingProService.getRow(id, flowrunid);
		mv.addObject("data", data);
		return mv;
	}
}

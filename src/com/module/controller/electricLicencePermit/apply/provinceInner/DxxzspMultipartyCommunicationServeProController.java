package com.module.controller.electricLicencePermit.apply.provinceInner;


import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


import com.module.service.electricLicencePermit.apply.provinceInner.DxxzspMultipartyCommunicationServeProService;
import com.util.AppException;

//国内多方通信服务业务(multipartyCommServe)
@Controller
@RequestMapping("/DxxzspMultipartyCommunicationServePro")
public class DxxzspMultipartyCommunicationServeProController {
	@Resource
	private DxxzspMultipartyCommunicationServeProService DxxzspMultipartyCommunicationServeProService;
	
	//页面跳转
	@RequestMapping("/toDxxzspMultipartyCommunicationServePro")
	public ModelAndView toDxxzspMultipartyCommunicationServePro(String id,String flowrunid) throws AppException {
		ModelAndView mv = new ModelAndView("electricLicencePermit/apply/provinceInner/DxxzspMultipartyCommunicationServePro");
		//业务查询
		Map<String,Object> data = DxxzspMultipartyCommunicationServeProService.getRow(id, flowrunid);
		mv.addObject("data", data);
		return mv;
	}

}


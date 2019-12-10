package com.module.controller.internetDomainRootServices.apply.apply;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;




import com.module.service.internetDomainRootServices.apply.apply.DxxzspTelecommManaReqIntService;
import com.util.AppException;

//1、电信管理机构要求提供的其他材料
@Controller
@RequestMapping("/DxxzspTelecommManaReqInt")
public class DxxzspTelecommManaReqIntController {
	@Resource
	private DxxzspTelecommManaReqIntService DxxzspTelecommManaReqIntService;
	
	//页面跳转
	@RequestMapping("/toDxxzspTelecommManaReqInt")
	public ModelAndView toDxxzspContentDistributionNetworkService(String id,String flowrunid) throws AppException {
		ModelAndView mv = new ModelAndView("internetDomainRootServices/apply/apply/DxxzspTelecommManaReqInt");
		//业务查询
		Map<String,Object> data = DxxzspTelecommManaReqIntService.getRow(id, flowrunid);
		mv.addObject("data", data);
		System.out.println("**************************************");
		System.out.println(data);
		System.out.println("**************************************");
		return mv;
	}

}



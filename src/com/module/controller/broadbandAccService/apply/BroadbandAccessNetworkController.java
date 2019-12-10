package com.module.controller.broadbandAccService.apply;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.module.service.broadbandAccService.apply.BroadbandAccessNetworkService;
import com.util.AppException;

//依法经营宽带接入网业务承诺书
@Controller
@RequestMapping("/broadbandAccessNetwork")
public class BroadbandAccessNetworkController {
	
	@Resource
	private BroadbandAccessNetworkService broadbandAccessNetworkService;
 	
	//页面跳转
	@RequestMapping("/broadbandAccessNetwork")
	public ModelAndView provideServiceMeasures(String id,String flowrunid) throws AppException{
		ModelAndView mv = new ModelAndView("broadbandAccService/apply/broadbandAccessNetwork");
		//业务查询
		Map<String,Object> data = broadbandAccessNetworkService.getRow(id, flowrunid);
		
		mv.addObject("data", data);
		return mv;
	}
		
}

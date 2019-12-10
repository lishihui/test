package com.module.controller.domain;

import java.util.Map;
import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.module.service.domain.IDxxzspDomainNetworksafetyService;
import com.util.AppException;

//7、网络安全保障措施
@Controller
@RequestMapping("/DxxzspDomainNetworksafety")
public class DxxzspDomainNetworksafetyController {
	
	@Resource
	private IDxxzspDomainNetworksafetyService iDxxzspDomainNetworksafetyService;
	
	//页面跳转
	@RequestMapping("/toDxxzspDomainNetworksafety")
	public ModelAndView toDxxzspDomainNetworksafety(String id,String flowrunid) throws AppException {
		ModelAndView mv = new ModelAndView("domain/DxxzspDomainNetworksafety");
		
		//业务查询
		Map<String,Object> data = iDxxzspDomainNetworksafetyService.getRow(id, flowrunid);
		mv.addObject("data", data);
		return mv;
	}
		
}

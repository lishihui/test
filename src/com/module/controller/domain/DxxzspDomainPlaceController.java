package com.module.controller.domain;

import com.module.service.domain.IDxxzspDomainPlaceService;
import com.util.AppException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.Map;

//10、顶级域注册管理系统场所情况表
@Controller
@RequestMapping("/DxxzspDomainPlace")
public class DxxzspDomainPlaceController {

	@Resource
	private IDxxzspDomainPlaceService dxxzspDomainPlaceService;
	
	//页面跳转
	@RequestMapping("/toDxxzspDomainPlace")
	public ModelAndView toDxxzspDomainPlace(String id,String flowrunid) throws AppException {
		ModelAndView mv = new ModelAndView("domain/DxxzspDomainPlace");
		//业务查询
		Map<String,Object> data = dxxzspDomainPlaceService.getRow(id, flowrunid);
		mv.addObject("data", data);
		return mv;
	}
		
}

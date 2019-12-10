package com.module.controller.domain;

import com.module.service.domain.IDxxzspDomainOthersService;
import com.util.AppException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.Map;

//12、电信管理机构要求提供的其他材料
@Controller
@RequestMapping("/DxxzspDomainOthers")
public class DxxzspDomainOthersController {

	@Resource
	private IDxxzspDomainOthersService dxxzspDomainOthersService;
	
	//页面跳转
	@RequestMapping("/toDxxzspDomainOthers")
	public ModelAndView toDxxzspDomainOthers(String id,String flowrunid) throws AppException {
		ModelAndView mv = new ModelAndView("domain/DxxzspDomainOthers");
		//业务查询
		Map<String,Object> data = dxxzspDomainOthersService.getRow(id, flowrunid);
		mv.addObject("data", data);
		return mv;
	}
		
}

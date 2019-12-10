package com.module.controller.threeWebElectric.change.comm;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


import com.module.service.threeWebElectric.change.comm.DxxzspContactService;
import com.util.AppException;

//联系方式
@Controller
@RequestMapping("/DxxzspContact")
public class DxxzspContactController {
	@Resource
	private DxxzspContactService DxxzspContactService;
	
	//页面跳转
	@RequestMapping("/toDxxzspContact")
	public ModelAndView toDxxzspContact(String id,String flowrunid) throws AppException {
		ModelAndView mv = new ModelAndView("threeWebElectric/change/comm/DxxzspContact");
		//业务查询
		Map<String,Object> data = DxxzspContactService.getRow(id, flowrunid);
		mv.addObject("data", data);
		return mv;
	}

}


package com.module.controller.threeWebElectric.change.change;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


import com.module.service.threeWebElectric.change.change.DxxzspChangeShareholdersService;
import com.util.AppException;

//股东股权变更
@Controller
@RequestMapping("/DxxzspChangeShareholders")
public class DxxzspChangeShareholdersController {
	@Resource
	private DxxzspChangeShareholdersService dxxzspChangeShareholdersService;
	
	//页面跳转
	@RequestMapping("/toDxxzspChangeShareholders")
	public ModelAndView toDxxzspChangeShareholders(String id,String flowrunid) throws AppException {
		ModelAndView mv = new ModelAndView("threeWebElectric/change/change/DxxzspChangeShareholders");
		//业务查询
		Map<String,Object> data = dxxzspChangeShareholdersService.getRow(id, flowrunid);
		mv.addObject("data", data);
		return mv;
	}

}


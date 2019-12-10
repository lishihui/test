package com.module.controller.threeWebElectric.change.change;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.module.service.threeWebElectric.change.change.DxxzspRenewalService;
import com.util.AppException;
//续期
@Controller
@RequestMapping("/DxxzspRenewal")
public class DxxzspRenewalController {
	@Resource
	private DxxzspRenewalService dxxzspRenewalService;
	
	//页面跳转
	@RequestMapping("/toDxxzspRenewal")
	public ModelAndView toDxxzspRenewal(String id,String flowrunid) throws AppException {
		ModelAndView mv = new ModelAndView("threeWebElectric/change/change/DxxzspRenewal");
		//业务查询
		Map<String,Object> data = dxxzspRenewalService.getRow(id, flowrunid);
		mv.addObject("data", data);
		return mv;
	}
}

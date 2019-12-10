package com.module.controller.threeWebElectric.change.comm;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


import com.module.service.threeWebElectric.change.comm.DxxzspApplyCommService;
import com.util.AppException;

//申请公共表单
@Controller
@RequestMapping("/DxxzspApplyComm")
public class DxxzspApplyComm {
	@Resource
	private DxxzspApplyCommService dxxzspApplyCommService;
	
	//页面跳转
	@RequestMapping("/toDxxzspApplyComm")
	public ModelAndView toDxxzspApplyComm(String id,String flowrunid) throws AppException {
		ModelAndView mv = new ModelAndView("threeWebElectric/change/comm/DxxzspApplyComm");
		//业务查询
		Map<String,Object> data = dxxzspApplyCommService.getRow(id, flowrunid);
		mv.addObject("data", data);
		return mv;
	}

}

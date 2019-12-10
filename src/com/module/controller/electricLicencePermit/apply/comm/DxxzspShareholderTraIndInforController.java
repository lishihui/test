package com.module.controller.electricLicencePermit.apply.comm;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.module.service.electricLicencePermit.apply.comm.DxxzspShareholderTraIndInforService;
import com.util.AppException;

//1、股东追溯及其相关证明材料--间接股东追溯--股东信息表
@Controller
@RequestMapping("/DxxzspShareholderTraIndInfor")
public class DxxzspShareholderTraIndInforController {
	@Resource
	private DxxzspShareholderTraIndInforService dxxzspShareholderTraIndInforService;
	
	//页面跳转
	@RequestMapping("/toDxxzspShareholderTraIndInfor")
	public ModelAndView toDxxzspShareholderTraIndInfor(String id,String flowrunid) throws AppException {
		ModelAndView mv = new ModelAndView("electricLicencePermit/apply/comm/DxxzspShareholderTraIndInfor");
		//业务查询
		Map<String,Object> data = dxxzspShareholderTraIndInforService.getRow(id, flowrunid);
		mv.addObject("data", data);
		return mv;
	}
}

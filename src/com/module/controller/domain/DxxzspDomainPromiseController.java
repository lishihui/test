package com.module.controller.domain;

import com.module.service.domain.IDxxzspDomainPromiseService;
import com.util.AppException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.Map;

//11、依法经营和诚信经营承诺书
@Controller
@RequestMapping("/DxxzspDomainPromise")
public class DxxzspDomainPromiseController {

	@Resource
	private IDxxzspDomainPromiseService dxxzspDomainPromiseService;
	
	//页面跳转
	@RequestMapping("/toDxxzspDomainPromise")
	public ModelAndView toDxxzspDomainPromise(String id,String flowrunid) throws AppException {
		ModelAndView mv = new ModelAndView("domain/DxxzspDomainPromise");
		//业务查询
		Map<String,Object> data = dxxzspDomainPromiseService.getRow(id, flowrunid);
		mv.addObject("data", data);
		return mv;
	}
		
}

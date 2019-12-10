package com.module.controller.electricLicencePermit.apply.provinceInner;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.module.service.electricLicencePermit.apply.provinceInner.DxxzspDataProcessingAndTransactionProService;
import com.util.AppException;

//在线数据处理与交易处理业务(dataProcessTransaction)
@Controller
@RequestMapping("/DxxzspDataProcessingAndTransactionPro")
public class DxxzspDataProcessingAndTransactionProController {
	@Resource
	private DxxzspDataProcessingAndTransactionProService dxxzspDataProcessingAndTransactionProService;
	
	//页面跳转
	@RequestMapping("/toDxxzspDataProcessingAndTransactionPro")
	public ModelAndView toDxxzspDataProcessingAndTransactionPro(String id,String flowrunid) throws AppException {
		ModelAndView mv = new ModelAndView("electricLicencePermit/apply/provinceInner/DxxzspDataProcessTransactionPro");
		//业务查询
		Map<String,Object> data = dxxzspDataProcessingAndTransactionProService.getRow(id, flowrunid);
		mv.addObject("data", data);
		return mv;
	}
}

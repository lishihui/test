package com.module.controller.domainRegistration.change.comm;


import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.module.domain.base.Page;
import com.module.domain.domain.DxxzspYewujiluUser;
import com.module.domain.query.XukeSearchQueryBean;
import com.module.service.domainRegistration.change.comm.DxxzspAuditTaskCommonService;
import com.module.service.domainRegistration.change.comm.DxxzspLegalIntegrityDomComService;
import com.util.AppException;

//1、固定网国内数据传送业务
@Controller
@RequestMapping("/DxxzspAuditTaskCommonShengnei")
public class DxxzspAuditTaskCommonShengneiController {
	@Resource
	private DxxzspAuditTaskCommonService dxxzspAuditTaskCommonService;
	
	//页面跳转
	@RequestMapping("/toDxxzspAuditTaskCommonShengnei")
	public ModelAndView toDxxzspAuditTaskCommonShengnei(HttpServletRequest request, String pageNo,String pageSize) throws Exception {
		ModelAndView mv = new ModelAndView("domainRegistration/change/comm/DxxzspAuditTaskCommonShengnei");
		
		XukeSearchQueryBean obj_record = dxxzspAuditTaskCommonService.getXukeSearchQueryBean(request);
	    
		Page pageBean = new Page();
		int currentPage = 1;
		int currentPageSize = 10;
		if(pageNo == null){
			currentPage = 1;
		}else{
			currentPage = Integer.parseInt(pageNo);
		}//当前页
		if(pageSize == null){
			currentPageSize = 10;
		}else{
			currentPageSize = Integer.parseInt(pageSize);
		}//页面大小
		
		
		Map<String,Object> data = dxxzspAuditTaskCommonService.getList(obj_record, "shengnei", currentPage, currentPageSize);
		//查询记录总数
		
		int count_size = dxxzspAuditTaskCommonService.getRowCount(obj_record, "shengnei");
		

		pageBean.setPageNo(currentPage);
        pageBean.setRows(currentPageSize);
		pageBean.setTotalRecord(Long.parseLong(count_size+""));
		
		data.put("obj_record", obj_record);
		data.put("pageBean", pageBean);
		mv.addObject("data", data);

		return mv;
	}

}


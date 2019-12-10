package com.module.controller.demo;

import java.util.Map;

import horizon.json.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import java.io.PrintWriter;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.module.service.demo.ILicenseInfoService;
import com.util.filter.SysContent;

@Controller
@RequestMapping("/LicenseInfo")
public class LicenseInfoController {
	@Resource
	private ILicenseInfoService iLicenseInfoService;

	//页面跳转 审批样例 传入查询主键
	@RequestMapping("/toLicenseInfo")
	@ResponseBody
	public void toLicenseInfo(String num) throws Exception{
		 
		 System.out.println("****************************进入toLicenseInfo");
		 HttpServletResponse response = SysContent.getResponse();
		
		 Map map = iLicenseInfoService.queryLiLicenseInfo(num);
		 JSONObject json = JSONObject.fromObject(map);
		 try {
		        //设置页面不缓存
		        response.setContentType("application/json");
		        response.setHeader("Pragma", "No-cache");
		        response.setHeader("Cache-Control", "no-cache");
		        response.setCharacterEncoding("UTF-8");
		        PrintWriter out= null;
		        out = response.getWriter();
		        out.print(json.toString().replaceAll("null", "\"\""));
		        out.flush();
		        out.close();
		    } catch (Exception e) {
		        e.printStackTrace();
		    }
		 
	}
	
	//页面跳转 审批样例 传入查询主键
	@RequestMapping("/toChangeLicenseInfo")
	@ResponseBody
	public void toChangeLicenseInfo(String num) throws Exception{
		 System.out.println("****************************进入toChangeLicenseInfo");
		 HttpServletResponse response = SysContent.getResponse();
		
		 String List = iLicenseInfoService.changLicenseinfo(num);
		 
		 try {
		        //设置页面不缓存
		        response.setContentType("application/json");
		        response.setHeader("Pragma", "No-cache");
		        response.setHeader("Cache-Control", "no-cache");
		        response.setCharacterEncoding("UTF-8");
		        PrintWriter out= null;
		        out = response.getWriter();
		        out.print(List);
		        out.flush();
		        out.close();
		    } catch (Exception e) {
		        e.printStackTrace();
		    }
		 
	}
	
	//ServerAppinfo
	@RequestMapping("/toServerAppinfo")
	@ResponseBody
	public void toServerAppinfo(String num) throws Exception{
		 
		System.out.println("****************************进入toServerAppinfo");
		HttpServletResponse response = SysContent.getResponse();
		
		 String map = iLicenseInfoService.getA12AndA08ServerAppinfo(num);
		 try {
		        //设置页面不缓存
		        response.setContentType("application/json");
		        response.setHeader("Pragma", "No-cache");
		        response.setHeader("Cache-Control", "no-cache");
		        response.setCharacterEncoding("UTF-8");
		        PrintWriter out= null;
		        out = response.getWriter();
		        out.print(map.replaceAll("null", "\"\""));
		        out.flush();
		        out.close();
		    } catch (Exception e) {
		        e.printStackTrace();
		    }
		 
	}
	
	
	@RequestMapping("/toZgsinfo")
	@ResponseBody
	public void toZgsinfo(String num) throws Exception{
		 
		System.out.println("****************************进入toZgsinfo");
		HttpServletResponse response = SysContent.getResponse();
		
		 String map = iLicenseInfoService.getZgsinfo(num);
		 try {
		        //设置页面不缓存
		        response.setContentType("application/json");
		        response.setHeader("Pragma", "No-cache");
		        response.setHeader("Cache-Control", "no-cache");
		        response.setCharacterEncoding("UTF-8");
		        PrintWriter out= null;
		        out = response.getWriter();
		        out.print(map.replaceAll("null", "\"\""));
		        out.flush();
		        out.close();
		    } catch (Exception e) {
		        e.printStackTrace();
		    }
		 
	}
	
	
}

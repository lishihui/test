package com.schedul;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.module.domain.homePage.DxxzspHomePageBMYWDT;
import com.module.service.homePage.IDxxzspHomePageService;
import com.module.service.param.DxxzspTokenConfService;
import com.util.FinalClassUtil;
import com.util.HttpUtil;
import com.util.ToolUtil;
/**
 * 流程实例（调度方法）
 * @author zkl
 *
 */
@Component
public class InstanceSchedul {
	
	 String getInstanceListUrl = "http://192.168.6.13:9086/runtime/instance/v1/myCompleted";
	 //String Authorization = "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbiIsImV4cCI6MTU3NTA1NTQ2NiwiaWF0IjoxNTc0ODM5NDY2fQ.V26J0rjfsxq41_e7_rN_c96l4I5ZSx_NWKZfGgsW-8WBg4btjmzEbzWSIFgNaSMI7yEOQqAIotLLq53IrScYFg";
	 String Authorization = "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbiIsImV4cCI6MTU3NDY3NzQ2MCwiaWF0IjoxNTc0NTkxMDYwfQ.ePe0UIetAfyqYUWOe6v-p53VgqUIIpblNk1hNZwoKsTef1WJsEkn4_ln2Jz0TZKqx42A-qxW63rzpatBR-XeQA";
	@Autowired
	IDxxzspHomePageService idxxzspHomePageService;
	@Autowired
	DxxzspTokenConfService dxxzspTokenConfService;
	
	//@Scheduled(cron = "0 */30 * * * ?  ") // 间隔30分钟执行一次
	//@Scheduled(cron = "0/30 * * * * ?  ") // 间隔30秒执行一次
	public void getSJBJList() {
		System.out.println("************ 定时任务 - 更新部门业务动态 - start *************");
		// 获取token		
		String token = tokenStr(1);
		
		Map<String, Map<String, Object>> map = new HashMap<>();
		Map<String, Object> queryMap = new HashMap<>();
		queryMap.put("page", 0);
		queryMap.put("pageSize", 0);
		queryMap.put("showTotal", true);
		map.put("pageBean", queryMap);
		
		String url = getInstanceListUrl;
		Map<String,String> headerMap = new HashMap<>();
		Map<String, String> contentMap = new HashMap<>();
		
		headerMap.put("Authorization", token);
		headerMap.put("Content-Type", "application/json");
		// 使用httpclient请求接口并传入参数
		String res = HttpUtil.postMap(url, headerMap, JSON.toJSONString(map));
		System.out.println("res："+res);
		System.out.println("token:"+token);
		JSONObject jsonStr = JSON.parseObject(res);
		String status = jsonStr.getString("status");
		if(status != null) {
			if(jsonStr.getString("status").equals("401")) { // 如果token过期 递归重新生成后继续执行
				System.out.println("》token失效，重新生成，直接结束本次刷新任务");
				tokenStr(2);
				return; // 直接结束本次刷新任务
			}
		}
		JSONArray jsonObj = JSON.parseArray(jsonStr.get("rows").toString());
		System.out.println("》查询到总完结数据："+jsonObj.size());
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			 int num = 0;
			 //2、循环遍历这个数组
			 for(int i=0;i<jsonObj.size();i++){
				 //3、把里面的对象转化为JSONObject
				  JSONObject job = jsonObj.getJSONObject(i);
				  // 4、把里面想要的参数一个个用.属性名的方式获取到
				  Date date1;
				  date1 = format.parse(job.get("endTime").toString());
				  int result = date1.compareTo(new Date());
				  if(result > -1) {
					  num++;
				  }
			  }
			 System.out.println("筛选出今日完结任务数量："+num);
			 //num = 5;
			 int shoujian = idxxzspHomePageService.getShouJianNum(); // 查询今日收件数量
			 //shoujian =5;
			 if(num > 0 || shoujian > 0) {
				 //保存或更新数据(查询当日数据)
				 DxxzspHomePageBMYWDT obj = idxxzspHomePageService.queryByDate();
				 System.out.println("obj:"+obj);
				 if(obj != null) { // 如果已有今日数据（更新）
					 int bj = 0,sj = 0;
					 int objBJ = obj.getBanjie();
					 int objSJ = obj.getShoujian();
					 if(objBJ < num || objSJ < shoujian) { // 如果收件/办结增多了(执行更新操作)
						 obj.setBanjie(num); // 更新办结数量
						 obj.setShoujian(shoujian); // 更新收件数量
						 bj = num - objBJ;
						 sj = shoujian - objSJ;
						 System.out.println("》 执行更新操作");
					 	 this.monthAndYearUpdOrAdd(bj,sj); // 更新或者添加当月和当年信息
						 // 更新当日信息
						 System.out.println("》 更新当日信息");
						 idxxzspHomePageService.updBMYWDTInfo(obj);
					 }
				 }else { // 如果没有今日数据（添加）
					 System.out.println("》 执行保存操作");
					 DxxzspHomePageBMYWDT dhpb = new DxxzspHomePageBMYWDT();
					 // 获取当天是周几
					 Date today = new Date();
					 Calendar c = Calendar.getInstance();
					 c.setTime(today);
					 int weekday = c.get(Calendar.DAY_OF_WEEK);
					 dhpb.setType("日"); // 数据类型
					 dhpb.setBanjie(num); // 办结数量
					 dhpb.setShoujian(shoujian); // 收件数量
					 dhpb.setCreateTime(new Date());
					 dhpb.setWeek(weekday); // 1.周日 2.周一 3.周二 4.周三 5.周四 6.周五 7.周六
					 idxxzspHomePageService.addBMYWDTInfo(dhpb);
					 this.monthAndYearUpdOrAdd(num,shoujian); // 更新或者添加当月和当年信息
				 }
			 }else {
				 System.out.println("》今日没有办结数据! 不进行任何操作");
			 }
		} catch (ParseException e) {
			System.out.println("操作当日办结数据信息异常："+e.getMessage());
		}
		System.out.println("************ 定时任务 - 更新部门业务动态 - end *************");
	}	
	
	
	/**
	 * 添加或更新当月和当年数据
	 * @param bj 需要增长的办结数量
	 * @param sj 需要增长的收件数量
	 */
	private void monthAndYearUpdOrAdd(Integer bj,Integer sj) {
		
		// 查询当月数据
		 DxxzspHomePageBMYWDT month= idxxzspHomePageService.queryByMonth();
		 if(month == null) { // 如果有当月数据
			 DxxzspHomePageBMYWDT dhpb = new DxxzspHomePageBMYWDT();
			 dhpb.setType("月"); // 数据类型
			 dhpb.setBanjie(bj); // 办结数量
			 dhpb.setShoujian(sj); // 收件数量
			 dhpb.setCreateTime(new Date());
			 dhpb.setWeek(0); // 默认为0
			 idxxzspHomePageService.addBMYWDTInfo(dhpb);
		 }else {
			 int monBJ = month.getBanjie()+bj;
			 int monSJ = month.getShoujian()+sj;
			 month.setBanjie(monBJ);
			 month.setShoujian(monSJ);
			 System.out.println("》 更新当月信息： sj = "+monSJ+" / bj = "+monBJ);
			 idxxzspHomePageService.updBMYWDTInfo(month);
		 }
		 
		 // 查询当年数据
		 DxxzspHomePageBMYWDT year= idxxzspHomePageService.queryByYear();
		 if(month == null) { // 如果有当月数据
			 DxxzspHomePageBMYWDT dhpb = new DxxzspHomePageBMYWDT();
			 dhpb.setType("年"); // 数据类型
			 dhpb.setBanjie(bj); // 办结数量
			 dhpb.setShoujian(sj); // 收件数量
			 dhpb.setCreateTime(new Date());
			 dhpb.setWeek(0); // 默认为0
			 idxxzspHomePageService.addBMYWDTInfo(dhpb);
		 }else {
			 int yeaBJ = year.getBanjie()+bj;
			 int yeaSJ = year.getShoujian()+sj;
			 year.setBanjie(yeaBJ);
			 year.setShoujian(yeaSJ);
			 System.out.println("》 更新当年信息： sj = "+yeaSJ+" / bj = "+yeaBJ);
			 idxxzspHomePageService.updBMYWDTInfo(year);
		 }
		
	}
	
	/**
	 * 获取token
	 * @param flag 标识： 1.获取 2.更新
	 * @return
	 */
	public String tokenStr(int flag) {
		String userName = "admin";
		String token = null;
		switch (flag) {
		case 1: // 查询
			token = dxxzspTokenConfService.getToken(userName); //用户名（目前写死）
			if(token == null) {
				token = ToolUtil.getARToken(userName, FinalClassUtil.EXPIRATION);
				dxxzspTokenConfService.addToken(userName, token);
			}
			break;
		case 2: // 更新
			token = ToolUtil.getARToken(userName, FinalClassUtil.EXPIRATION);
			dxxzspTokenConfService.updToken(userName, token);
			break;
		}
		return token.trim();
	}
	
}

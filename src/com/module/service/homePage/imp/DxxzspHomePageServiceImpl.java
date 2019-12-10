package com.module.service.homePage.imp;

import java.util.Calendar;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.module.dao.homePage.DxxzspHomePageMapper;
import com.module.domain.homePage.DxxzspHomePageBMYWDT;
import com.module.domain.homePage.DxxzspHomePageDBTJ;
import com.module.service.homePage.IDxxzspHomePageService;
import com.module.domain.homePage.DxxzspHomePageSQPHB;
import com.module.domain.homePage.DxxzspHomePageTJB;

/**
 * 首页待办统计栏目
 * 
 * @author awl 2019.11.22
 *
 */
@Service("DxxzspHomePageService")
public class DxxzspHomePageServiceImpl implements IDxxzspHomePageService {

	@Resource
	private DxxzspHomePageMapper dxxzspHomePageMapper;

	// 查询首页待办统计数据
	public List<DxxzspHomePageDBTJ> selectDBTJAll() {
		// 查询首页待办统计数据SQL
		List<DxxzspHomePageDBTJ> dbtjList = dxxzspHomePageMapper.selectDBTJAll();
		return dbtjList;
	}

	// 查询首页申请业务排行榜数据
	public List<DxxzspHomePageSQPHB> selectSQPHB() {
		// 查询首页申请业务排行榜数据SQL
		List<DxxzspHomePageSQPHB> sqphbList = dxxzspHomePageMapper.selectSQPHB();
		return sqphbList;
	}

	// 查询首页统计表数据
	public List<DxxzspHomePageTJB> selectTJBAll() {
		// 查询首页统计表数据SQL
		List<DxxzspHomePageTJB> tjbList = dxxzspHomePageMapper.selectTJBAll();
		return tjbList;
	}

	// 查询首页部门业务动态数据
	@Override
	public JSONObject selectBMYWDT() {
		JSONObject json = new JSONObject();
		//获取当前年，月，日
		Calendar calendar = Calendar.getInstance();
		int cyear = calendar.get(Calendar.YEAR);
		int cmonth = calendar.get(Calendar.MONTH)+1;
		int cday = calendar.get(Calendar.DAY_OF_MONTH);
		// 查询首页部门业务动态今日
		DxxzspHomePageBMYWDT bmywdt = new DxxzspHomePageBMYWDT();
		bmywdt.setType("日");
		bmywdt.setYear(cyear+"");
		bmywdt.setMonth(cmonth+"");
		bmywdt.setDay(cday+"");
		DxxzspHomePageBMYWDT day = dxxzspHomePageMapper.selectDAY(bmywdt);
		JSONObject dayjson = new JSONObject();
		dayjson.put("shoujian", day!=null?day.getSj():0);
		dayjson.put("banjie", day!=null?day.getBj():0);
		json.put("day", dayjson);
		// 查询首页部门业务动态当前月
		bmywdt = new DxxzspHomePageBMYWDT();
		bmywdt.setType("月");
		bmywdt.setYear(cyear+"");
		bmywdt.setMonth(cmonth+"");
		DxxzspHomePageBMYWDT month = dxxzspHomePageMapper.selectMONTH(bmywdt);
		JSONObject monthjson = new JSONObject();
		monthjson.put("shoujian", month!=null?month.getSj():0);
		monthjson.put("banjie", month!=null?month.getBj():0);
		json.put("month", monthjson);
		// 查询首页部门业务动态累计（当前年）
		bmywdt = new DxxzspHomePageBMYWDT();
		bmywdt.setType("年");
		bmywdt.setYear(cyear+"");
		DxxzspHomePageBMYWDT year = dxxzspHomePageMapper.selectYEAR(bmywdt);
		JSONObject yearjson = new JSONObject();
		yearjson.put("shoujian", year!=null?year.getSj():0);
		yearjson.put("banjie", year!=null?year.getBj():0);
		json.put("year", yearjson);

		return json;
	}

	// 测试
	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:spring-mybatis.xml");
		IDxxzspHomePageService test = (IDxxzspHomePageService) ac.getBean("DxxzspHomePageService");
		JSONObject tjson = test.selectBMYWDT();
		JSONObject json = new JSONObject();
		json.put("rows", tjson);
		json.put("count", tjson.size());
		System.out.println(json);
	}

	// 保存一条部门业务动态信息
	@Override
	public int addBMYWDTInfo(DxxzspHomePageBMYWDT bmywdt) {
		int res = dxxzspHomePageMapper.addBMYWDTInfo(bmywdt);
		return res;
	}

	// 查询当天已办结数据
	@Override
	public DxxzspHomePageBMYWDT queryByDate() {
		return dxxzspHomePageMapper.queryByDate();
	}

	// 更新一条以天为单位的信息
	@Override
	public int updBMYWDTInfo(DxxzspHomePageBMYWDT bmywdt) {
		return dxxzspHomePageMapper.updBMYWDTInfo(bmywdt);
	}

	// 查询当月已办结数据
	@Override
	public DxxzspHomePageBMYWDT queryByMonth() {
		return dxxzspHomePageMapper.queryByMonth();
	}

	// 查询当年已办结数据
	@Override
	public DxxzspHomePageBMYWDT queryByYear() {
		return dxxzspHomePageMapper.queryByYear();
	}

	// 查询今日收件数量
	@Override
	public int getShouJianNum() {
		return dxxzspHomePageMapper.getShouJianNum();
	}
}

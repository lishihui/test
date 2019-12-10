package com.module.service.homePage;

import java.util.List;

import com.alibaba.fastjson.JSONObject;
import com.module.domain.homePage.DxxzspHomePageBMYWDT;
import com.module.domain.homePage.DxxzspHomePageDBTJ;
import com.module.domain.homePage.DxxzspHomePageSQPHB;
import com.module.domain.homePage.DxxzspHomePageTJB;

/**
 * 首页待办统计栏目
 * 
 * @author awl 2019.11.22
 *
 */
public interface IDxxzspHomePageService {

	// 查询首页待办统计数据
	public List<DxxzspHomePageDBTJ> selectDBTJAll();

	// 查询首页申请业务排行榜数据
	public List<DxxzspHomePageSQPHB> selectSQPHB();

	// 查询首页统计表数据
	public List<DxxzspHomePageTJB> selectTJBAll();

	// 查询首页部门业务动态数据
	public JSONObject selectBMYWDT();
	
	// 保存一条部门业务动态信息
	public int addBMYWDTInfo(DxxzspHomePageBMYWDT bmywdt);
	
	// 查询当天已办结数据
	public DxxzspHomePageBMYWDT queryByDate();
	
	// 查询当月已办结数据
	public DxxzspHomePageBMYWDT queryByMonth();
	
	// 查询当年已办结数据
	public DxxzspHomePageBMYWDT queryByYear();
	
	// 更新一条的信息
	public int updBMYWDTInfo(DxxzspHomePageBMYWDT bmywdt);
	
	// 查询今日收件数量
	public int getShouJianNum();
	
	
	
	
	
	
}

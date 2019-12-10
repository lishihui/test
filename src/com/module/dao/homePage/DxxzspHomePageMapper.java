package com.module.dao.homePage;

import java.util.List;

import com.module.domain.homePage.DxxzspHomePageBMYWDT;
import com.module.domain.homePage.DxxzspHomePageDBTJ;
import com.module.domain.homePage.DxxzspHomePageSQPHB;
import com.module.domain.homePage.DxxzspHomePageTJB;

public interface DxxzspHomePageMapper {
	// 首页待办统计list
	List<DxxzspHomePageDBTJ> selectDBTJAll();

	// 首页申请业务排行榜list，按申请数量降序，显示前八条
	List<DxxzspHomePageSQPHB> selectSQPHB();

	// 首页申请业务排行榜list，按申请数量降序，显示前八条
	List<DxxzspHomePageTJB> selectTJBAll();

	// 首页部门业务动态今日
	DxxzspHomePageBMYWDT selectDAY(DxxzspHomePageBMYWDT bmywdt);
	// 首页部门业务动态当月
	DxxzspHomePageBMYWDT selectMONTH(DxxzspHomePageBMYWDT bmywdt);
	// 首页部门业务动态累计（当年）
	DxxzspHomePageBMYWDT selectYEAR(DxxzspHomePageBMYWDT bmywdt);
	// 保存一条部门业务动态信息
	int addBMYWDTInfo(DxxzspHomePageBMYWDT bmywdt);
	// 查询当天已办结数据
	public DxxzspHomePageBMYWDT queryByDate();
	// 查询当月已办结数据
	public DxxzspHomePageBMYWDT queryByMonth();
	// 查询当年已办结数据
	public DxxzspHomePageBMYWDT queryByYear();
	// 更新一条以天为单位的信息
	public int updBMYWDTInfo(DxxzspHomePageBMYWDT bmywdt);
	// 查询今日收件数量
	public int getShouJianNum();
}
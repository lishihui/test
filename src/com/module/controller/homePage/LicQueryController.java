package com.module.controller.homePage;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.module.domain.homePage.ComLicense;
import com.module.domain.homePage.EUDataGrid;
import com.module.domain.homePage.EntBaseInfo;
import com.module.domain.homePage.GDInfo;
import com.module.domain.homePage.LicBus;
import com.module.domain.homePage.LicFormModel;
import com.module.domain.homePage.LicenseBaseInfo;
import com.module.domain.homePage.NBTJQKInfo;
import com.module.domain.homePage.SQZGSInfo;
import com.module.domain.homePage.WZXXBInfo;
import com.module.domain.homePage.XYInfo;
import com.module.service.homePage.LicQueryService;

/**
 * @author awl
 *
 */
@Controller
@RequestMapping("/licquery")
public class LicQueryController {

	Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	LicQueryService licQueryService;

	// 许可证查询列表
	@RequestMapping("/getLicGridData")
	@ResponseBody
	public EUDataGrid queryLicGridData(EUDataGrid model, LicFormModel licQueryModel) {
		return licQueryService.queryLicGridData(model, licQueryModel);
	}

	// 许可证详情
	@RequestMapping("/showLicDetail")
	public String showLicDetail(Model model, LicFormModel licInfo) {
		ComLicense licDetail = licQueryService.queryLicDetail(licInfo);
		int pageNo = 1;

		// 业务范围
		List<LicBus> busList = new ArrayList<LicBus>();
		if (licDetail != null) {
			// 业务种类 服务范围
			busList = licQueryService.queryLicBusList(licInfo.getLicid());
			if (busList != null) {
				double size = busList.size();
				if (size > 4) {
					pageNo += Math.ceil((size - 4) / 8);
				}
			}
		}
		model.addAttribute("licDetail", licDetail);
		model.addAttribute("pageNo", pageNo);
		model.addAttribute("busList", busList);

		return "homePage/DxxzspHomePageXKZCXDetail";
	}

	@RequestMapping("/showLicInfos")
	public String showLicInfos(Model model, LicFormModel licInfo) {
		// 许可证基本信息
		LicenseBaseInfo lbi = licQueryService.queryLicenseBaseInfo(licInfo);
		int licPageNo = 1;
		EntBaseInfo ebi = new EntBaseInfo();
		List<LicBus> busList = new ArrayList<LicBus>();
		List<SQZGSInfo> sqzgslist = new ArrayList<SQZGSInfo>();
		List<NBTJQKInfo> nblist = new ArrayList<NBTJQKInfo>();
		List<WZXXBInfo> wzxxblist = new ArrayList<WZXXBInfo>();
		List<EntBaseInfo> qyzjlist = new ArrayList<EntBaseInfo>();
		List<GDInfo> gdlist = new ArrayList<GDInfo>();
		List<XYInfo> bllist = new ArrayList<XYInfo>();
		List<XYInfo> sxlist = new ArrayList<XYInfo>();
		if (lbi != null && lbi.getEntid() != null) {
			// 公司基本信息
			ebi = licQueryService.queryEntBaseInfo(lbi.getEntid());
			// 业务种类 服务范围
			busList = licQueryService.queryLicBusList(licInfo.getLicid());
			// 授权子公司情况
			sqzgslist = licQueryService.querySQZGSInfoList(licInfo.getLicid());
			// 年报提交情况
			nblist = licQueryService.queryNBTJQKInfoList(lbi.getEntid());
			// 网站信息表
			wzxxblist = licQueryService.queryWZXXBInfoList(licInfo.getLicid());
			// 企业证件列表
			qyzjlist = licQueryService.queryQYZJList(lbi.getEntid());
			// 股东信息
			gdlist = licQueryService.queryGDInfoList(lbi.getEntid());
			// 不良名单
			bllist = licQueryService.queryBLInfoList(lbi.getEntid());
			// 失信名单
			sxlist = licQueryService.querySXInfoList(lbi.getEntid());
		}
		model.addAttribute("licBaseInfo", lbi);
		model.addAttribute("busList", busList);
		licPageNo = licPageNo + busList.size() / 8 + 1;
		model.addAttribute("licPageNo", licPageNo);
		model.addAttribute("entBaseInfo", ebi);
		model.addAttribute("sqzgslist", sqzgslist);
		int sqzgsPageNo = sqzgslist.size() / 8 + 1;
		model.addAttribute("sqzgsPageNo", sqzgsPageNo);
		model.addAttribute("nblist", nblist);
		int nbPageNo = nblist.size() / 8 + 1;
		model.addAttribute("nbPageNo", nbPageNo);
		model.addAttribute("wzxxblist", wzxxblist);
		int wzxxbPageNo = wzxxblist.size() / 8 + 1;
		model.addAttribute("wzxxbPageNo", wzxxbPageNo);
		model.addAttribute("qyzjlist", qyzjlist);
		int qyzjPageNo = qyzjlist.size() / 8 + 1;
		model.addAttribute("qyzjPageNo", qyzjPageNo);
		model.addAttribute("gdlist", gdlist);
		int gdPageNo = gdlist.size() / 8 + 1;
		model.addAttribute("gdPageNo", gdPageNo);
		model.addAttribute("bllist", bllist);
		int blPageNo = bllist.size() / 8 + 1;
		model.addAttribute("blPageNo", blPageNo);
		model.addAttribute("sxlist", sxlist);
		int sxPageNo = sxlist.size() / 8 + 1;
		model.addAttribute("sxPageNo", sxPageNo);

		return "homePage/DxxzspHomePageXKZInfo";
	}
}

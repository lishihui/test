package com.module.controller.homePage;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;
import com.module.domain.homePage.DxxzspHomePageDBTJ;
import com.module.domain.homePage.DxxzspHomePageSQPHB;
import com.module.domain.homePage.DxxzspHomePageTJB;
import com.module.domain.homePage.LicFormModel;
import com.module.service.homePage.IDxxzspHomePageService;
import com.module.service.homePage.LicQueryService;

/**
 * 首页栏目
 * 
 * @author awl 2019.11.22
 *
 */
@Controller
@RequestMapping("/HomePage")
public class DxxzspHomePageController {

	@Resource
	private IDxxzspHomePageService iDxxzspHomePageService;
	@Resource
	LicQueryService licQueryService;

	// 待办统计
	@RequestMapping("/toDBTJ")
	public @ResponseBody JSONObject toDxxzspHomePageDBTJ() {
		List<DxxzspHomePageDBTJ> list = iDxxzspHomePageService.selectDBTJAll();
		JSONObject json = new JSONObject();
		json.put("rows", list);
		return json;
	}

	// 申请业务排行榜
	@RequestMapping("/toSQPHB")
	public @ResponseBody JSONObject toDxxzspHomePageSQPHB() {
		List<DxxzspHomePageSQPHB> list = iDxxzspHomePageService.selectSQPHB();
		JSONObject json = new JSONObject();
		json.put("rows", list);
		return json;
	}

	// 统计表
	@RequestMapping("/toTJB")
	public @ResponseBody JSONObject toDxxzspHomePageTJB() {
		List<DxxzspHomePageTJB> list = iDxxzspHomePageService.selectTJBAll();
		JSONObject json = new JSONObject();
		json.put("rows", list);
		return json;
	}

	// 部门业务动态
	@RequestMapping("/toBMYWDT")
	public @ResponseBody JSONObject toDxxzspHomePageBMYWDT() {
		JSONObject json = iDxxzspHomePageService.selectBMYWDT();
		return json;
	}

	/*@RequestMapping("/toXKZCX")
	public String toDxxzspHomePageXKZCX(Model model, @RequestParam("bh") String bh, @RequestParam("qymc") String qymc, @RequestParam("fddb") String fddb, @RequestParam("lzr") String lzr){
		String str = "";
		LicFormModel licQueryModel = new LicFormModel();
		licQueryModel.setNum(bh);
		licQueryModel.setGsmc(qymc);
		licQueryModel.setFrdb(fddb);
		licQueryModel.setCorporatename(lzr);
		int num = licQueryService.queryLicCompCount(licQueryModel);
		if(num>0) {
			model.addAttribute("bh",bh);
			model.addAttribute("gsmc",qymc);
			model.addAttribute("fddb",fddb);
			model.addAttribute("lzr",lzr);
			str = "homePage/DxxzspHomePageXKZCXList";
		}else {
			JSONObject json = new JSONObject();
			json.put("mes", "暂无相关可查证件");
			str = json.toJSONString();
		}
		
		return str;
	}*/
	// 许可证查询
	@RequestMapping("/toXKZCX")
	public ModelAndView toDxxzspHomePageXKZCX(@RequestParam("bh") String bh, @RequestParam("qymc") String qymc, @RequestParam("fddb") String fddb, @RequestParam("lzr") String lzr){
		ModelAndView mv = new ModelAndView("homePage/DxxzspHomePageXKZCXList");
		mv.addObject("bh",bh);
		mv.addObject("qymc",qymc);
		mv.addObject("fddb",fddb);
		mv.addObject("lzr",lzr);
		return mv;
	}
	

}

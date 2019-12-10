package com.module.controller.fuzhushenpisheji;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.module.service.fuzhushenpisheji.AuxiliaryApprovalDesignService;

/**
 * @author awl 辅助审批设计
 *
 */
@Controller
@RequestMapping("/AuxiliaryApprovalDesign")
public class AuxiliaryApprovalDesignController {

	Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	AuxiliaryApprovalDesignService aadService;

	@RequestMapping("/toQYZXXX")
	public @ResponseBody JSONObject toQYZXXX(@RequestParam("entid") String entid) throws IOException {
		JSONObject json = new JSONObject();
		String regcode = aadService.getRegcodeByEntid(entid);
		System.out.println(regcode);
		// 企业最新消息
		// JSONObject qyzxxx = aadService.getQiYeZuiXinXiaoXi(regcode);
		JSONArray arr = new JSONArray();
		for (int i = 0; i < 1; i++) {
			JSONObject qy = new JSONObject();
			qy.put("gsmc", "公司名称");
			qy.put("tyshxydm", "统一社会信用代码");
			qy.put("fddbr", "法定代表人");
			qy.put("sfzh", "身份证号");
			qy.put("yyzzdqri", "2019-12-07");
			qy.put("qyxz", "企业性质");
			qy.put("zczj", "注册资金");
			qy.put("qyxy", "企业信用");
			arr.add(qy);
		}
		json.put("qyzxxx", arr);

		return json;
	}

	@RequestMapping("/toCZQK")
	public @ResponseBody JSONObject toCZQK(@RequestParam("entid") String entid) throws IOException {
		JSONObject json = new JSONObject();
		JSONArray arr = new JSONArray();
		for (int i = 0; i < 23; i++) {
			JSONObject czqk = new JSONObject();
			czqk.put("xkzmc", "许可证名称/批文名称");
			czqk.put("bh", "证号");
			czqk.put("fzjg", "发证机关");
			czqk.put("yxq", "2023-12-07");
			arr.add(czqk);
		}
		json.put("czqk", arr);

		return json;
	}

	@RequestMapping("/toZZBLYW")
	public @ResponseBody JSONObject toZZBLYW(@RequestParam("entid") String entid) throws IOException {
		JSONObject json = new JSONObject();
		JSONArray arr = new JSONArray();
		for (int i = 0; i < 23; i++) {
			JSONObject zzblyw = new JSONObject();
			zzblyw.put("sqywmc", "申请任务名称");
			zzblyw.put("sctjsj", "2019-12-07");
			zzblyw.put("spzt", "审批状态");
			zzblyw.put("thcs", "退回次数");
			arr.add(zzblyw);
		}
		json.put("zzblyw", arr);

		return json;
	}

}

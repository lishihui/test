package com.module.service.fuzhushenpisheji;

import java.io.IOException;

import com.alibaba.fastjson.JSONObject;

/**
 * 辅助审批设计
 * 
 * @author awl 2019.12.07
 *
 */
public interface AuxiliaryApprovalDesignService {
	// 获取统一社会信用代码
	public String getRegcodeByEntid(String entid);

	// 调用中台组件获取信息
	public JSONObject getQiYeZuiXinXiaoXi(String regcode) throws IOException;
}

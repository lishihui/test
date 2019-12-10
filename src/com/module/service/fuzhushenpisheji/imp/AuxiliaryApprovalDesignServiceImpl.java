package com.module.service.fuzhushenpisheji.imp;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.module.dao.fuzhushenpisheji.AuxiliaryApprovalDesignMapper;
import com.module.service.fuzhushenpisheji.AuxiliaryApprovalDesignService;
import com.util.HttpUtil;

/**
 * 辅助审批设计
 * 
 * @author awl 2019.12.07
 *
 */
@Service
public class AuxiliaryApprovalDesignServiceImpl implements AuxiliaryApprovalDesignService {
	
	@Resource
	private AuxiliaryApprovalDesignMapper aadMapper;
	
	@Override
	public String getRegcodeByEntid(String entid) {
		return aadMapper.getRegcodeByEntid(entid);
	}

	@Override
	public JSONObject getQiYeZuiXinXiaoXi(String regcode) throws IOException {
		//内网  192.168.100.179
		//WiFi 192.168.0.102
		String urlStr = "http://192.168.100.179:8080/dxxzsp/enterprise/queryByRegCode";
		Map<String, String> parameterMap = new HashMap<String, String>();
		parameterMap.put("regcode", regcode);
		String qyzxxx = HttpUtil.post(urlStr, parameterMap);
		JSONObject json = JSONObject.parseObject(qyzxxx);
		System.out.println(json);
		return json;
	}
	public static void main(String[] args) {
		AuxiliaryApprovalDesignServiceImpl a = new AuxiliaryApprovalDesignServiceImpl();
		try {
			a.getQiYeZuiXinXiaoXi("qazwsxedcazwsxedcr");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

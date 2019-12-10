package com.module.controller.domain;

import com.alibaba.fastjson.JSON;
import com.module.annotation.SystemControllerLog;
import com.module.domain.domain.DxxzspDomainPermitdns;
import com.module.service.domain.IDxxzspDomainPermitdnsService;
import com.util.AppException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@RequestMapping("/domainPermitdns")
@RestController
public class DxxzspDomainPermitdnsController {
	private static final Logger logger = LoggerFactory.getLogger(IDxxzspDomainPermitdnsService. class);
	
	@Resource
	private IDxxzspDomainPermitdnsService domainPermitdnsService;

	@SystemControllerLog(description="保存数据")
	@RequestMapping(value = "/save")
	public Map<String,Object> save(@RequestBody String jsonStr) throws AppException {
		logger.info("/domainPermitdns/save parameter: {}", jsonStr);
		Map<String,Object> map = new HashMap<String,Object>();
		DxxzspDomainPermitdns domainPermitdns = JSON.parseObject(jsonStr, DxxzspDomainPermitdns.class);
		domainPermitdnsService.save(domainPermitdns);
		map.put("flag", "1");
		map.put("msg", "保存成功");
		return map;
	}

    // 流程实例审批完成,获取流程实例变量，保存数据
	@SystemControllerLog(description="流程实例审批完成")
	@RequestMapping(value = "/finish")
	public Map<String,Object> finish(String flowrunid) throws AppException {
		logger.info("/domainPermitdns/finish parameter: {}", flowrunid);
		Map<String,Object> map = new HashMap<String,Object>();
		DxxzspDomainPermitdns domainPermitdns = new DxxzspDomainPermitdns();
		domainPermitdns.setFlowrunid(flowrunid);
		domainPermitdnsService.save(domainPermitdns);
		map.put("flag", "1");
		map.put("msg", "保存成功");
		return map;
	}



}

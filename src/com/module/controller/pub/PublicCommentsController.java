package com.module.controller.pub;

import com.alibaba.fastjson.JSON;
import com.module.annotation.SystemControllerLog;
import com.module.domain.pub.DxxzspPublicComments;
import com.module.service.pub.IPublicCommentsService;
import com.util.AppException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("/publicComments")
@RestController
public class PublicCommentsController {
	private static final Logger logger = LoggerFactory.getLogger(PublicCommentsController. class);
	
	@Resource
	private IPublicCommentsService publicCommentsService;
/**
 * 保存历史意见表单方法，保存按钮触发
 * @param jsonStr
 * @return
 * @throws AppException
 */
	@SystemControllerLog(description="保存数据")
	@RequestMapping(value = "/save")
	public Map<String,Object> save(@RequestBody String jsonStr) throws AppException {
		Map<String,Object> map = new HashMap<String,Object>();
        DxxzspPublicComments publicComments = JSON.parseObject(jsonStr, DxxzspPublicComments.class);
		publicCommentsService.save(publicComments);
		map.put("flag", "1");
		map.put("msg", "保存成功");
		return map;
	}

	@SystemControllerLog(description="列表数据")
	@RequestMapping("/list")
	public Map<String,Object> list(String workid, String formid) throws AppException {
		logger.info("/list parameter: {}, {}", workid, formid);
		Map<String,Object> map = new HashMap<String,Object>();
		List<DxxzspPublicComments> list = publicCommentsService.list(workid, formid);
		map.put("rows", list); 
    	map.put("total",list.size());
    	return map;
	}
}

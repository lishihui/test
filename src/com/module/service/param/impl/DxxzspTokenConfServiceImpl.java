package com.module.service.param.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.module.dao.param.DxxzspTokenConfMapper;
import com.module.service.param.DxxzspTokenConfService;

/**
 * token操作类
 * @author zkl
 *
 */
@Service("DxxzspTokenConfService")
public class DxxzspTokenConfServiceImpl implements DxxzspTokenConfService {

	@Resource
	private DxxzspTokenConfMapper mapper;

	/**
	 * 获取token
	 * @param userName 用户名称
	 * @return
	 */
	@Override
	public String getToken(String userName) {
		return mapper.getToken(userName);
	}

	/**
	 * 更新token
	 * @param userName 用户名称
	 * @param token 新的token
	 * @return
	 */
	@Override
	public int updToken(String userName, String token) {
		return mapper.updToken(userName, token);
	}

	/**
	 * 添加token
	 * @param userName 用户名称
	 * @param token 新的token
	 * @return
	 */
	@Override
	public int addToken(String userName, String token) {
		return mapper.addToken(userName, token);
	}

	
}

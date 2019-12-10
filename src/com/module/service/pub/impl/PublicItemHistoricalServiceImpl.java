package com.module.service.pub.impl;

import java.util.Date;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.module.dao.pub.PublicItemHistoricalMapper;
import com.module.domain.pub.PublicItemHistorical;
import com.module.service.pub.PublicItemHistoricalService;

@Service
public class PublicItemHistoricalServiceImpl implements PublicItemHistoricalService{
	@Resource
	private  PublicItemHistoricalMapper publicItemMapper;
	@Override
	public void save(PublicItemHistorical publicItem) {
			Date now = new Date();
		 	publicItem.setId(UUID.randomUUID().toString());
		 	publicItem.setLastsubmittimes(now);
	        publicItemMapper.insertSelective(publicItem);
	}
	
}
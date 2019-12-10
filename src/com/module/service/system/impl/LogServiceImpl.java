package com.module.service.system.impl;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.module.dao.system.SysLogMapper;
import com.module.domain.system.SysLog;
import com.module.service.system.ILogService;

//日志记录 
@Service("logService")
public class LogServiceImpl  implements ILogService{
	
	@Resource
	private SysLogMapper sysLogMapper;
	
	@Override
	public int createLog(SysLog log) {
		//return this.logDao.insertSelective(log);
		sysLogMapper.insertSelective(log);
		System.out.println("模拟日志入库"+log);
		return 1;
	}
	
	@Override
	public int updateLog(SysLog log) {
		//return this.logDao.updateByPrimaryKeySelective(log);
		sysLogMapper.updateByPrimaryKeySelective(log);
		System.out.println("模拟日志更新"+log);
		return 1;
	}

}

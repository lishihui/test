package com.module.service.system;

import com.module.domain.system.SysLog;

public interface ILogService {
	//增删改
	public int createLog(SysLog log);
	public int updateLog(SysLog log);
}

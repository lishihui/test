package com.module.dao.demo;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.module.domain.base.WetrilCnkiLicenseInfo;

public interface WetrilCnkiLicenseMapper {

	List<WetrilCnkiLicenseInfo> downLicence(@Param("entbaseNameList") List<String> entbaseNameList);

	List<Map> downLicenceBg(@Param("entbaseNameList") List<String> workidBG2);
	
}

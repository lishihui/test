package com.module.dao.fuzhushenpisheji;

import org.apache.ibatis.annotations.Param;

public interface AuxiliaryApprovalDesignMapper {
	// 获取统一社会信用代码
	String getRegcodeByEntid(@Param("entid") String entid);
}
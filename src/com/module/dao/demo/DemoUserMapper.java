package com.module.dao.demo;

import java.util.List;
import java.util.Map;

import com.module.domain.demo.DemoUser;

public interface DemoUserMapper {
    int deleteByPrimaryKey(String uuid);

    int insert(DemoUser record);

    int insertSelective(DemoUser record);

    DemoUser selectByPrimaryKey(String uuid);

    int updateByPrimaryKeySelective(DemoUser record);

    int updateByPrimaryKey(DemoUser record);

	
}
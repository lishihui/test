package com.module.dao.pub;

import com.module.domain.pub.DxxzspPublicComments;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DxxzspPublicCommentsMapper {
    int deleteByPrimaryKey(String id);

    int insert(DxxzspPublicComments record);

    int insertSelective(DxxzspPublicComments record);

    DxxzspPublicComments selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(DxxzspPublicComments record);

    int updateByPrimaryKey(DxxzspPublicComments record);

    DxxzspPublicComments selectByComplexKey(@Param("workid") String workid, @Param("formid") String formid, @Param("nodeid") String nodeid);

    List<DxxzspPublicComments> listByComplexKey(@Param("workid") String workid, @Param("formid") String formid);
}
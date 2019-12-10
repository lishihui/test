package com.module.service.pub.impl;

import com.module.dao.pub.DxxzspPublicCommentsMapper;
import com.module.domain.pub.DxxzspPublicComments;
import com.module.service.pub.IPublicCommentsService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class PublicCommentsServiceImpl implements IPublicCommentsService {

    @Resource
    private DxxzspPublicCommentsMapper publicCommentsMapper;

    @Override
    public int save(DxxzspPublicComments publicComments) {
        Date now = new Date();
        publicComments.setId(UUID.randomUUID().toString());
        publicComments.setCreator(publicComments.getUserid());
        publicComments.setModificator(publicComments.getUserid());
        publicComments.setCreateTime(now);
        publicComments.setModifieTime(now);
        publicComments.setType("DN");
        DxxzspPublicComments oldRecord =  publicCommentsMapper.selectByComplexKey(publicComments.getWorkid(), publicComments.getFormid(), publicComments.getNodeid());
        if (oldRecord == null) {
            publicCommentsMapper.insertSelective(publicComments);
        } else {
            oldRecord.setModifieTime(now);
            oldRecord.setModificator(publicComments.getModificator());
            oldRecord.setYijian(publicComments.getYijian());
            oldRecord.setYijianvalue(publicComments.getYijianvalue());
            oldRecord.setRemark(publicComments.getRemark());
            publicCommentsMapper.updateByPrimaryKeySelective(oldRecord);
        }
        return 1;
    }

    @Override
    public List<DxxzspPublicComments> list(String workid, String formid) {
        return publicCommentsMapper.listByComplexKey(workid, formid);
    }
}

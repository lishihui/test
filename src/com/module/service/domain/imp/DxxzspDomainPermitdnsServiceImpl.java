package com.module.service.domain.imp;

import com.module.dao.domain.DxxzspDomainApplytaskMapper;
import com.module.dao.domain.DxxzspDomainPermitdnsMapper;
import com.module.domain.domain.DxxzspDomainApplytask;
import com.module.domain.domain.DxxzspDomainPermitdns;
import com.module.service.domain.IDxxzspDomainPermitdnsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.UUID;

@Service
public class DxxzspDomainPermitdnsServiceImpl implements IDxxzspDomainPermitdnsService {

    @Resource
    private DxxzspDomainPermitdnsMapper dxxzspDomainPermitdnsMapper;

    @Resource
    private DxxzspDomainApplytaskMapper dxxzspDomainApplytaskMapper;

    @Override
    public int save(DxxzspDomainPermitdns domainPermitdns) {
        // 根据流程ID获取企业ID
        DxxzspDomainApplytask domainApplytask = dxxzspDomainApplytaskMapper.selectByFlowrunid(domainPermitdns.getFlowrunid());
        if (domainApplytask != null) {
            domainPermitdns.setEntid(domainApplytask.getId());
            // 根据企业ID获取其它企业信息
        }
        // 根据流程ID获取流程变量
        domainPermitdns.setId(UUID.randomUUID().toString());
        dxxzspDomainPermitdnsMapper.insertSelective(domainPermitdns);
        return 1;
    }
}

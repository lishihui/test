package com.module.service.domain.imp;

import com.module.dao.domain.DxxzspDomainPromiseMapper;
import com.module.domain.domain.DxxzspDomainPromise;
import com.module.service.domain.IDxxzspDomainPromiseService;
import com.util.AppException;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Map;

@Service
public class DxxzspDomainPromiseServiceImpl implements IDxxzspDomainPromiseService {

    @Resource
    private DxxzspDomainPromiseMapper dxxzspDomainPromiseMapper;

    @SuppressWarnings("unchecked")
	@Override
    public Map<String, Object> getRow(String id, String flowrunid) throws AppException {
        DxxzspDomainPromise dxxzspDomainPromise = dxxzspDomainPromiseMapper.selectByPrimaryKey(id);
        try {
            return BeanUtils.describe(dxxzspDomainPromise);
        } catch (Exception e) {
            return null;
        }
    }
}
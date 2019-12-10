package com.module.service.domain.imp;

import com.module.dao.domain.DxxzspDomainOthersMapper;
import com.module.domain.domain.DxxzspDomainOthers;
import com.module.service.domain.IDxxzspDomainOthersService;
import com.util.AppException;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.Map;

@Service("DxxzspDomainOthersServiceImpl")
public class DxxzspDomainOthersServiceImpl implements IDxxzspDomainOthersService {

    @Resource
    private DxxzspDomainOthersMapper dxxzspDomainOthersMapper;

    @SuppressWarnings("unchecked")
	@Override
    public Map<String,Object> getRow(String id, String flowrunid) throws AppException {
        DxxzspDomainOthers dxxzspDomainOthers = dxxzspDomainOthersMapper.selectByPrimaryKey(id);
        try {
            return BeanUtils.describe(dxxzspDomainOthers);
        } catch (Exception e) {
            return null;
        }
//        Map<String,Object> ret = new HashMap<String,Object>();
//        List<DxxzspDomainOthers> list_others = dxxzspDomainOthersMapper.list(id);
//        ret.put("others", list_others);
//        return ret;
    }
}

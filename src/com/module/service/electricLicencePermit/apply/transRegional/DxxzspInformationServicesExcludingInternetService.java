package com.module.service.electricLicencePermit.apply.transRegional;

import java.util.Map;

import com.util.AppException;

//1����Ϣ���񣨲�����������Ϣ����ҵ��
public interface DxxzspInformationServicesExcludingInternetService {
	//��������ѯҵ�����
    public Map<String,Object> getRow(String id,String flowrunid) throws AppException;
}

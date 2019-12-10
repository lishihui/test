package com.module.service.homePage;

import java.util.List;

import com.module.domain.homePage.ComLicense;
import com.module.domain.homePage.EUDataGrid;
import com.module.domain.homePage.EntBaseInfo;
import com.module.domain.homePage.GDInfo;
import com.module.domain.homePage.LicBus;
import com.module.domain.homePage.LicFormModel;
import com.module.domain.homePage.LicenseBaseInfo;
import com.module.domain.homePage.NBTJQKInfo;
import com.module.domain.homePage.SQZGSInfo;
import com.module.domain.homePage.WZXXBInfo;
import com.module.domain.homePage.XYInfo;

/**
 * 
 * @author awl 许可证管理接口类 2019.11.24
 */
public interface LicQueryService {

	/**
	 * 查询许可证grid表数据
	 * 
	 * @param dataGrid
	 * @return
	 */
	public EUDataGrid queryLicGridData(EUDataGrid dataGrid, LicFormModel licQueryModel);

	/**
	 * 查询许可证详情
	 * 
	 * @param licInfo
	 * @return
	 */
	public ComLicense queryLicDetail(LicFormModel licInfo);

	/**
	 * 查询许可证跨区域增值电信业务记录
	 * 
	 * @param licid
	 * @return
	 */
	public List<LicBus> queryLicBusList(String licid);

	/**
	 * 查询许可证基本信息
	 * 
	 * @param licInfo
	 * @return
	 */
	public LicenseBaseInfo queryLicenseBaseInfo(LicFormModel licInfo);

	/**
	 * 查询公司基本信息
	 * 
	 * @param entId
	 * @return
	 */
	public EntBaseInfo queryEntBaseInfo(String entId);

	/**
	 * 查询授权子公司情况
	 * 
	 * @param licInfo
	 * @return
	 */
	public List<SQZGSInfo> querySQZGSInfoList(String licid);

	/**
	 * 查询年报提交情况
	 * 
	 * @param entid
	 * @return
	 */
	public List<NBTJQKInfo> queryNBTJQKInfoList(String entid);

	/**
	 * 查询网站信息表
	 * 
	 * @param licInfo
	 * @return
	 */
	public List<WZXXBInfo> queryWZXXBInfoList(String licid);

	/**
	 * 查询网站信息表
	 * 
	 * @param licInfo
	 * @return
	 */
	public List<EntBaseInfo> queryQYZJList(String entid);

	/**
	 * 查询股东信息
	 * 
	 * @param entid
	 * @return
	 */
	public List<GDInfo> queryGDInfoList(String entid);

	/**
	 * 查询不良名单
	 * 
	 * @param entid
	 * @return
	 */
	public List<XYInfo> queryBLInfoList(String entid);

	/**
	 * 查询失信名单
	 * 
	 * @param entid
	 * @return
	 */
	public List<XYInfo> querySXInfoList(String entid);
}

package com.module.dao.homePage;

import java.util.List;
import java.util.Set;

import org.apache.ibatis.annotations.Param;

import com.module.domain.homePage.ComLicense;
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
 * @author awl
 *
 */
public interface LicQueryMapper {

	// 许可证查询列表
	// 获取企业id
	public Set<String> getEntId(LicFormModel licQueryModel);

	// 获取结果总记录数
	public int queryLicCompCount(@Param("flag") String flag, @Param("entids") Set<String> entids);

	// 获取结果list
	public List<ComLicense> queryLicCompList(@Param("startlimit") int startlimit, @Param("endlimit") int endlimit,
			@Param("flag") String flag, @Param("entids") Set<String> entids);

	// 许可证查询结束
	// 查看许可证详情
	// 详情
	public ComLicense queryLicDetailByLicId(@Param("licid") String licid);

	// 业务种类 覆盖范围
	public List<LicBus> queryLicBusList(@Param("licid") String licid);

	// 查看许可证详情结束
	// 许可证基本信息
	public LicenseBaseInfo queryLicenseByLicId(@Param("licid") String licid);

	// 公司基本信息
	public EntBaseInfo queryEntByEntId(@Param("entid") String entid);

	// 授权子公司信息
	public List<SQZGSInfo> querySQZGSByLicId(@Param("licid") String licid);

	// 年报提交情况
	public List<NBTJQKInfo> queryNBTJQKByEntId(@Param("entid") String entid);

	// 网站信息表
	public List<WZXXBInfo> queryWZXXBByLicId(@Param("licid") String licid);

	// 企业证件列表
	public List<EntBaseInfo> queryQYZJByEntId(@Param("entid") String entid);

	// 股东信息
	public List<GDInfo> queryGDByEntId(@Param("entid") String entid);

	// 不良名单
	public List<XYInfo> queryBLByEntId(@Param("entid") String entid);

	// 失信名单
	public List<XYInfo> querySXByEntId(@Param("entid") String entid);

}

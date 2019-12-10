package com.module.service.homePage.imp;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.module.dao.homePage.LicQueryMapper;
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
import com.module.service.homePage.LicQueryService;

/**
 * @author awl
 *
 */
@Service
public class LicQueryServiceImpl implements LicQueryService {

	@Autowired
	LicQueryMapper licQueryMapper;

	@Override
	public EUDataGrid queryLicGridData(EUDataGrid dataGrid, LicFormModel licQueryModel) {
		int start = (dataGrid.getPage() - 1) * dataGrid.getRows();
		Set<String> entids = licQueryMapper.getEntId(licQueryModel);
		List<ComLicense> list = new ArrayList<ComLicense>();
		int total = 0;
		if (entids.size() > 0) {
			list = licQueryMapper.queryLicCompList(start, dataGrid.getRows(), licQueryModel.getFlag(), entids);
			if (list != null && list.size() > 0) {
				total = licQueryMapper.queryLicCompCount(licQueryModel.getFlag(), entids);
			}
		}
		dataGrid.setTotal(total);
		dataGrid.setList(list);
		return dataGrid;
	}

	@Override
	public ComLicense queryLicDetail(LicFormModel licInfo) {
		ComLicense licDetail = null;
		if (licInfo != null && null != licInfo.getLicid()) {
			licDetail = licQueryMapper.queryLicDetailByLicId(licInfo.getLicid());
			if (null == licDetail) {
				return null;
			}
		}
		return licDetail;
	}

	@Override
	public List<LicBus> queryLicBusList(String licid) {
		List<LicBus> list = licQueryMapper.queryLicBusList(licid);
		/*
		 * for (int i = 0; i < 20; i++) { LicBus lb = new LicBus();
		 * lb.setYewuname("yw"+i); lb.setYwfw("fw"+i); list.add(lb); }
		 */
		return list;
	}

	@Override
	public LicenseBaseInfo queryLicenseBaseInfo(LicFormModel licInfo) {
		LicenseBaseInfo lbi = null;
		if (licInfo != null && null != licInfo.getLicid()) {
			lbi = licQueryMapper.queryLicenseByLicId(licInfo.getLicid());
			if (null == lbi) {
				return null;
			}
		}
		return lbi;
	}

	@Override
	public EntBaseInfo queryEntBaseInfo(String entId) {
		EntBaseInfo ebi = null;
		if (entId != null) {
			ebi = licQueryMapper.queryEntByEntId(entId);
			if (null == ebi) {
				return null;
			}
		}
		return ebi;
	}

	@Override
	public List<SQZGSInfo> querySQZGSInfoList(String licid) {
		return licQueryMapper.querySQZGSByLicId(licid);
		/*
		 * List<SQZGSInfo> sqzgslist = new ArrayList<SQZGSInfo>(); for (int i = 0; i <
		 * 23; i++) { SQZGSInfo si = new SQZGSInfo(); si.setSubsidiary("子公司" + i);
		 * si.setYewuname(
		 * "业务ssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssss"
		 * + "ssssssssssssssssssssssssssssssssssssssssssss" +
		 * "sssssssssssssssssssssssssssssssss" + "sssssssssssssssssssssssssssssssssssss"
		 * + i); sqzgslist.add(si); } return sqzgslist;
		 */
	}

	@Override
	public List<NBTJQKInfo> queryNBTJQKInfoList(String entid) {
		return licQueryMapper.queryNBTJQKByEntId(entid);
		/*
		 * List<NBTJQKInfo> nblist = new ArrayList<NBTJQKInfo>(); for (int i = 0; i <
		 * 23; i++) { NBTJQKInfo nb = new NBTJQKInfo(); nb.setRptyear("20" + i);
		 * nb.setRptstatus(i%2==0?"0":"1"); nblist.add(nb); } return nblist;
		 */
	}

	@Override
	public List<WZXXBInfo> queryWZXXBInfoList(String licid) {
		return licQueryMapper.queryWZXXBByLicId(licid);
		/*
		 * List<WZXXBInfo> wzxxblist = new ArrayList<WZXXBInfo>(); for (int i = 0; i <
		 * 23; i++) { WZXXBInfo wz = new WZXXBInfo(); wz.setMc("网站"+i);
		 * wz.setYm("域名"+i); wz.setFzd("放置地"+i); wz.setSddw("单位"+i); wzxxblist.add(wz);
		 * } return wzxxblist;
		 */
	}

	@Override
	public List<EntBaseInfo> queryQYZJList(String entid) {
		return licQueryMapper.queryQYZJByEntId(entid);
		/*
		 * List<WZXXBInfo> wzxxblist = new ArrayList<WZXXBInfo>(); for (int i = 0; i <
		 * 23; i++) { WZXXBInfo wz = new WZXXBInfo(); wz.setMc("网站"+i);
		 * wz.setYm("域名"+i); wz.setFzd("放置地"+i); wz.setSddw("单位"+i); wzxxblist.add(wz);
		 * } return wzxxblist;
		 */
	}

	@Override
	public List<GDInfo> queryGDInfoList(String entid) {
		return licQueryMapper.queryGDByEntId(entid);
		/*
		 * List<GDInfo> gdlist = new ArrayList<GDInfo>(); for (int i = 0; i < 23; i++) {
		 * GDInfo gd = new GDInfo(); gd.setName("股东" + i); gd.setIdcard("证件" + i);
		 * gd.setCapitalpercent("比例" + i); gdlist.add(gd); } return gdlist;
		 */
	}

	@Override
	public List<XYInfo> queryBLInfoList(String entid) {
		return licQueryMapper.queryBLByEntId(entid);
		/*
		 * List<XYInfo> bllist = new ArrayList<XYInfo>(); for (int i = 0; i < 23; i++) {
		 * XYInfo bl = new XYInfo(); bl.setEnroldate(new java.sql.Date(2019, 12, i));
		 * bl.setEnrolreason("违法业务类别" + i); bl.setRemark("违规情形描述" + i);
		 * bl.setRemovedate(new java.sql.Date(2019, 12, 1)); bllist.add(bl); } return
		 * bllist;
		 */
	}

	@Override
	public List<XYInfo> querySXInfoList(String entid) {
		return licQueryMapper.querySXByEntId(entid);
		/*
		 * List<XYInfo> sxlist = new ArrayList<XYInfo>(); for (int i = 0; i < 23; i++) {
		 * XYInfo sx = new XYInfo(); sx.setEnroldate(new java.sql.Date(2019, 12, i));
		 * sx.setEnrolreason("违法业务类别" + i); sx.setRemark("违规情形描述" + i);
		 * sx.setRemovedate(new java.sql.Date(2019, 12, 1)); sxlist.add(sx); } return
		 * sxlist;
		 */
	}
}

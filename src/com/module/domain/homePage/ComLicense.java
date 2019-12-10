package com.module.domain.homePage;


import org.springframework.format.annotation.DateTimeFormat;


/**
*@author awl
*
*/
public class ComLicense {
	private int lid;//主键
	private String licpkid;//许可证信息表主键
	private String num;//许可证编号
	private String flag;//状态0临时证1正常的证-1已注销-2已吊销
	private String entid;//企业ID
	private String provinceid;//省号
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private String regdate;//许可证获得日期
	private String validity;//许可证有效期
	private String lasteditdate;//最后变更日期
	private String licid;//许可证唯一标识
	private String version;//版本号
	private String versiondate;//版本时间
	private String versionmissionid;//由哪个任务产生的版本
	private String versionflag;//版本状态 0审核中的版本1审核完成或不需审核的版本-1删除的版本
	private String isissuer;//是否已经签发 0尚未签发1已经签发
	private String licensefile;//许可证文件 格式如:1:1234.html;2:2345.html
	private String licensingpersonname;//领证人姓名
	private String licensingpersoncode;//领证人证件号
	private String islicensing;//是否已领证0未领证1已领证
	private String isnotice;//是否已通知企业来领取0未通知1已通知
	private String noticedate;//通知时间
	private String licensingdate;//领证时间
	private String datacomplete;//材料是否齐备0未齐备1齐备
	private String note;//备注
	private String licensingmobile;//领证人联系方式(手机号)
	private String licensorusername;//发证人用户名
	private String specialrule;//特别规定事项
	private String needfile;//是否需要扫描件上传0不需1需要
	private String fileid;//扫描件ID
	private String spe_isbigarea;//是否大区
	private String spe_isbbs;//有无bbs
	private String spe_pointcity;//节点城市
	private String spe_centercity;//中心节点城市
	private String spe_netmodel;//主网模式(0:集中式;1分布式;2:集中分布式)
	private String spe_address;//注册地
	private String spe_isicp;//有无icp
	private String spe_north;//华北区
	private String spe_eastnorth;//东北区
	private String spe_east;//华东区
	private String spe_centersouth;//中南区
	private String spe_westsouth;//西南区
	private String spe_chargecity;//中心节点城市责任城市
	private String spe_westnorth;//西北区
	private String isprint;//许可证是否打印 0 未打印 1是打印
	private String smallmanager;//小管局0非小管局1小管局
	private String ispreapproval;//是否前置审批0非1是
	private String versionusers;//版本用户
	private String isholder;//0为非股东变更，1为股东变更
	private String cancelreason;//注销原因
	private String canceldate;//注销日期
	private String messageto;//是否发送了短消息 大于等于1表示已发送
	private String spe_websvrtype;//是否有网站接入0有1无
	private String firstlicensingdate;//首次发证时间
	private String id;//主键唯一id，LICPKID
	private String title;//标题
	private String created;//创建时间
	private String modified;//修改时间
	private String creator;//创建人
	private String modificator;//修改人
	private String recycle;//回收站标识
	private String gsmc;//公司名称
	private String frdb;//法定代表人
	private String cert_scanner;//身份证正反面扫描件
	private String appointment_time;//预约领证时间
	private String reserve_number;//当日预约次数
	private String order_num;//序号
	private String appoint_status;//预约状态
	private String appoint_modify;//预约时间修改次数
	private String inform_role;//通知角色
	
	private String yewu;//业务名称、类别字符串
	private String ywfw;//业务范围
	private String bussinessid;
	private String yewuname;//业务名称
	private String yewulbbh;
	private String yewutype;//业务类型
	private String yewucode;
	private String insertdate;//办理日期
	
	private String provincename;//省名称
	
	private String regcode;//公司统一社会信用代码
	private String corporatename;//法人名称
	private String corporatecode;//法人身份证号
	
	private String regorgan;//注册机关
	private String regaddress;//注册地址
	
	
	public String getRegaddress() {
		return regaddress;
	}
	public void setRegaddress(String regaddress) {
		this.regaddress = regaddress;
	}
	public String getRegorgan() {
		return regorgan;
	}
	public void setRegorgan(String regorgan) {
		this.regorgan = regorgan;
	}
	public String getLicpkid() {
		return licpkid;
	}
	public void setLicpkid(String licpkid) {
		this.licpkid = licpkid;
	}
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}
	public String getEntid() {
		return entid;
	}
	public void setEntid(String entid) {
		this.entid = entid;
	}
	public String getProvinceid() {
		return provinceid;
	}
	public void setProvinceid(String provinceid) {
		this.provinceid = provinceid;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	public String getValidity() {
		return validity;
	}
	public void setValidity(String validity) {
		this.validity = validity;
	}
	public String getLasteditdate() {
		return lasteditdate;
	}
	public void setLasteditdate(String lasteditdate) {
		this.lasteditdate = lasteditdate;
	}
	public String getLicid() {
		return licid;
	}
	public void setLicid(String licid) {
		this.licid = licid;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public String getVersiondate() {
		return versiondate;
	}
	public void setVersiondate(String versiondate) {
		this.versiondate = versiondate;
	}
	public String getVersionmissionid() {
		return versionmissionid;
	}
	public void setVersionmissionid(String versionmissionid) {
		this.versionmissionid = versionmissionid;
	}
	public String getVersionflag() {
		return versionflag;
	}
	public void setVersionflag(String versionflag) {
		this.versionflag = versionflag;
	}
	public String getIsissuer() {
		return isissuer;
	}
	public void setIsissuer(String isissuer) {
		this.isissuer = isissuer;
	}
	public String getLicensefile() {
		return licensefile;
	}
	public void setLicensefile(String licensefile) {
		this.licensefile = licensefile;
	}
	public String getLicensingpersonname() {
		return licensingpersonname;
	}
	public void setLicensingpersonname(String licensingpersonname) {
		this.licensingpersonname = licensingpersonname;
	}
	public String getLicensingpersoncode() {
		return licensingpersoncode;
	}
	public void setLicensingpersoncode(String licensingpersoncode) {
		this.licensingpersoncode = licensingpersoncode;
	}
	public String getIslicensing() {
		return islicensing;
	}
	public void setIslicensing(String islicensing) {
		this.islicensing = islicensing;
	}
	public String getIsnotice() {
		return isnotice;
	}
	public void setIsnotice(String isnotice) {
		this.isnotice = isnotice;
	}
	public String getNoticedate() {
		return noticedate;
	}
	public void setNoticedate(String noticedate) {
		this.noticedate = noticedate;
	}
	public String getLicensingdate() {
		return licensingdate;
	}
	public void setLicensingdate(String licensingdate) {
		this.licensingdate = licensingdate;
	}
	public String getDatacomplete() {
		return datacomplete;
	}
	public void setDatacomplete(String datacomplete) {
		this.datacomplete = datacomplete;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public String getLicensingmobile() {
		return licensingmobile;
	}
	public void setLicensingmobile(String licensingmobile) {
		this.licensingmobile = licensingmobile;
	}
	public String getLicensorusername() {
		return licensorusername;
	}
	public void setLicensorusername(String licensorusername) {
		this.licensorusername = licensorusername;
	}
	public String getSpecialrule() {
		return specialrule;
	}
	public void setSpecialrule(String specialrule) {
		this.specialrule = specialrule;
	}
	public String getNeedfile() {
		return needfile;
	}
	public void setNeedfile(String needfile) {
		this.needfile = needfile;
	}
	public String getFileid() {
		return fileid;
	}
	public void setFileid(String fileid) {
		this.fileid = fileid;
	}
	public String getSpe_isbigarea() {
		return spe_isbigarea;
	}
	public void setSpe_isbigarea(String spe_isbigarea) {
		this.spe_isbigarea = spe_isbigarea;
	}
	public String getSpe_isbbs() {
		return spe_isbbs;
	}
	public void setSpe_isbbs(String spe_isbbs) {
		this.spe_isbbs = spe_isbbs;
	}
	public String getSpe_pointcity() {
		return spe_pointcity;
	}
	public void setSpe_pointcity(String spe_pointcity) {
		this.spe_pointcity = spe_pointcity;
	}
	public String getSpe_centercity() {
		return spe_centercity;
	}
	public void setSpe_centercity(String spe_centercity) {
		this.spe_centercity = spe_centercity;
	}
	public String getSpe_netmodel() {
		return spe_netmodel;
	}
	public void setSpe_netmodel(String spe_netmodel) {
		this.spe_netmodel = spe_netmodel;
	}
	public String getSpe_address() {
		return spe_address;
	}
	public void setSpe_address(String spe_address) {
		this.spe_address = spe_address;
	}
	public String getSpe_isicp() {
		return spe_isicp;
	}
	public void setSpe_isicp(String spe_isicp) {
		this.spe_isicp = spe_isicp;
	}
	public String getSpe_north() {
		return spe_north;
	}
	public void setSpe_north(String spe_north) {
		this.spe_north = spe_north;
	}
	public String getSpe_eastnorth() {
		return spe_eastnorth;
	}
	public void setSpe_eastnorth(String spe_eastnorth) {
		this.spe_eastnorth = spe_eastnorth;
	}
	public String getSpe_east() {
		return spe_east;
	}
	public void setSpe_east(String spe_east) {
		this.spe_east = spe_east;
	}
	public String getSpe_centersouth() {
		return spe_centersouth;
	}
	public void setSpe_centersouth(String spe_centersouth) {
		this.spe_centersouth = spe_centersouth;
	}
	public String getSpe_westsouth() {
		return spe_westsouth;
	}
	public void setSpe_westsouth(String spe_westsouth) {
		this.spe_westsouth = spe_westsouth;
	}
	public String getSpe_chargecity() {
		return spe_chargecity;
	}
	public void setSpe_chargecity(String spe_chargecity) {
		this.spe_chargecity = spe_chargecity;
	}
	public String getSpe_westnorth() {
		return spe_westnorth;
	}
	public void setSpe_westnorth(String spe_westnorth) {
		this.spe_westnorth = spe_westnorth;
	}
	public String getIsprint() {
		return isprint;
	}
	public void setIsprint(String isprint) {
		this.isprint = isprint;
	}
	public String getSmallmanager() {
		return smallmanager;
	}
	public void setSmallmanager(String smallmanager) {
		this.smallmanager = smallmanager;
	}
	public String getIspreapproval() {
		return ispreapproval;
	}
	public void setIspreapproval(String ispreapproval) {
		this.ispreapproval = ispreapproval;
	}
	public String getVersionusers() {
		return versionusers;
	}
	public void setVersionusers(String versionusers) {
		this.versionusers = versionusers;
	}
	public String getIsholder() {
		return isholder;
	}
	public void setIsholder(String isholder) {
		this.isholder = isholder;
	}
	public String getCancelreason() {
		return cancelreason;
	}
	public void setCancelreason(String cancelreason) {
		this.cancelreason = cancelreason;
	}
	public String getCanceldate() {
		return canceldate;
	}
	public void setCanceldate(String canceldate) {
		this.canceldate = canceldate;
	}
	public String getMessageto() {
		return messageto;
	}
	public void setMessageto(String messageto) {
		this.messageto = messageto;
	}
	public String getSpe_websvrtype() {
		return spe_websvrtype;
	}
	public void setSpe_websvrtype(String spe_websvrtype) {
		this.spe_websvrtype = spe_websvrtype;
	}
	public String getFirstlicensingdate() {
		return firstlicensingdate;
	}
	public void setFirstlicensingdate(String firstlicensingdate) {
		this.firstlicensingdate = firstlicensingdate;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCreated() {
		return created;
	}
	public void setCreated(String created) {
		this.created = created;
	}
	public String getModified() {
		return modified;
	}
	public void setModified(String modified) {
		this.modified = modified;
	}
	public String getCreator() {
		return creator;
	}
	public void setCreator(String creator) {
		this.creator = creator;
	}
	public String getModificator() {
		return modificator;
	}
	public void setModificator(String modificator) {
		this.modificator = modificator;
	}
	public String getRecycle() {
		return recycle;
	}
	public void setRecycle(String recycle) {
		this.recycle = recycle;
	}
	public String getGsmc() {
		return gsmc;
	}
	public void setGsmc(String gsmc) {
		this.gsmc = gsmc;
	}
	public String getFrdb() {
		return frdb;
	}
	public void setFrdb(String frdb) {
		this.frdb = frdb;
	}
	public String getCert_scanner() {
		return cert_scanner;
	}
	public void setCert_scanner(String cert_scanner) {
		this.cert_scanner = cert_scanner;
	}
	public String getAppointment_time() {
		return appointment_time;
	}
	public void setAppointment_time(String appointment_time) {
		this.appointment_time = appointment_time;
	}
	public String getReserve_number() {
		return reserve_number;
	}
	public void setReserve_number(String reserve_number) {
		this.reserve_number = reserve_number;
	}
	public String getOrder_num() {
		return order_num;
	}
	public void setOrder_num(String order_num) {
		this.order_num = order_num;
	}
	public String getAppoint_status() {
		return appoint_status;
	}
	public void setAppoint_status(String appoint_status) {
		this.appoint_status = appoint_status;
	}
	public String getAppoint_modify() {
		return appoint_modify;
	}
	public void setAppoint_modify(String appoint_modify) {
		this.appoint_modify = appoint_modify;
	}
	public String getInform_role() {
		return inform_role;
	}
	public void setInform_role(String inform_role) {
		this.inform_role = inform_role;
	}
	public String getOldentid() {
		return oldentid;
	}
	public void setOldentid(String oldentid) {
		this.oldentid = oldentid;
	}
	private String oldentid;//


	public String getYwfw() {
		return ywfw;
	}
	public void setYwfw(String ywfw) {
		this.ywfw = ywfw;
	}
	public String getProvincename() {
		return provincename;
	}
	public void setProvincename(String provincename) {
		this.provincename = provincename;
	}
	public String getYewu() {
		return yewu;
	}
	public void setYewu(String yewu) {
		this.yewu = yewu;
	}
	public String getRegcode() {
		return regcode;
	}
	public void setRegcode(String regcode) {
		this.regcode = regcode;
	}
	public String getCorporatename() {
		return corporatename;
	}
	public void setCorporatename(String corporatename) {
		this.corporatename = corporatename;
	}
	public String getCorporatecode() {
		return corporatecode;
	}
	public void setCorporatecode(String corporatecode) {
		this.corporatecode = corporatecode;
	}
	public String getBussinessid() {
		return bussinessid;
	}
	public void setBussinessid(String bussinessid) {
		this.bussinessid = bussinessid;
	}
	public String getYewuname() {
		return yewuname;
	}
	public void setYewuname(String yewuname) {
		this.yewuname = yewuname;
	}
	public String getYewulbbh() {
		return yewulbbh;
	}
	public void setYewulbbh(String yewulbbh) {
		this.yewulbbh = yewulbbh;
	}
	public String getYewutype() {
		return yewutype;
	}
	public void setYewutype(String yewutype) {
		this.yewutype = yewutype;
	}
	public String getYewucode() {
		return yewucode;
	}
	public void setYewucode(String yewucode) {
		this.yewucode = yewucode;
	}
	public String getInsertdate() {
		return insertdate;
	}
	public void setInsertdate(String insertdate) {
		this.insertdate = insertdate;
	}
	public int getLid() {
		return lid;
	}
	public void setLid(int lid) {
		this.lid = lid;
	}
}

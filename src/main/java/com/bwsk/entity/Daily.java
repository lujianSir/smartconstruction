package com.bwsk.entity;

import java.math.BigDecimal;
import java.util.List;

/**
 * 日报实体
 * 
 * @author lujian
 *
 */
public class Daily {

	private int did;// ID

	private int uid;// 对应的用户ID

	private String upic;// 用户对于的图片

	private String udpic;/// 用户对应的图片

	private String username;// 上报的人员名称

	private String uposition;// 职位

	private String utelphone;// 电话

	private int weather;// 天气 1 晴 2阴 3 雨

	private String weatherName;// 天气

	private int attendancetody;// 今天出勤

	private double attendanceoneself;// 本人出勤

	private int effectivework;// 有效工作时间 1、(<2小时 ) 2、(2-4小时) 3、(4-6小时) 4、(6-8小时) 5、(>8小时)

	private String effectiveworkName;

	private int satisfactiondegree;// 满意度 1、(很不满意) 2、(不太满意) 3、(满意) 4、(比较满意) 5、(非常满意)

	private String satisfactiondegreeName;

	private String equipments;// 设备 (名称以及数量，以-分割比如：挖掘机-2，多个以；号分割：:挖掘机-2;钻头-1)

	private List listequipments;// 设备数组

	private String workcomment;// 工作内容

	private String abnorname;// 异常情况

	private String dunning;// 催款记录

	private String dunningpic;// 催款记录对应的图片 ，以；号分割

	private BigDecimal amountody;// 今日收款项

	private BigDecimal invoicetody;// 今日发票

	private String dpic;// 项目附图

	private List<String> dpics;// 项目附图

	private String dvoideo;// 项目视频

	private List dvoideos;// 项目视频

	private String dtime;// 日报提交的时间

	private int pid;// 项目ID

	private String pname;// 项目名称

	private String creattime;// 创建的时间

	private int ustatus;// 用户是否提交

	private String creatMouth;// 用户提交的月份

	private List<Thumb> thumbs;// 点赞的人

	private List<Comment> comments;// 评论的人数

	private int tstatus;// 点赞

	private String weixin;// 群聊

	private String flag;// 是否是项目的人

	public List getListequipments() {
		return listequipments;
	}

	public void setListequipments(List listequipments) {
		this.listequipments = listequipments;
	}

	public String getUdpic() {
		return udpic;
	}

	public void setUdpic(String udpic) {
		this.udpic = udpic;
	}

	public String getUpic() {
		return upic;
	}

	public void setUpic(String upic) {
		this.upic = upic;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public String getWeixin() {
		return weixin;
	}

	public void setWeixin(String weixin) {
		this.weixin = weixin;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public int getTstatus() {
		return tstatus;
	}

	public void setTstatus(int tstatus) {
		this.tstatus = tstatus;
	}

	public List<Thumb> getThumbs() {
		return thumbs;
	}

	public void setThumbs(List<Thumb> thumbs) {
		this.thumbs = thumbs;
	}

	public String getEquipments() {
		return equipments;
	}

	public void setEquipments(String equipments) {
		this.equipments = equipments;
	}

	public String getCreatMouth() {
		return creatMouth;
	}

	public void setCreatMouth(String creatMouth) {
		this.creatMouth = creatMouth;
	}

	public int getDid() {
		return did;
	}

	public void setDid(int did) {
		this.did = did;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUposition() {
		return uposition;
	}

	public void setUposition(String uposition) {
		this.uposition = uposition;
	}

	public String getUtelphone() {
		return utelphone;
	}

	public void setUtelphone(String utelphone) {
		this.utelphone = utelphone;
	}

	public int getWeather() {
		return weather;
	}

	public void setWeather(int weather) {
		this.weather = weather;
	}

	public int getAttendancetody() {
		return attendancetody;
	}

	public void setAttendancetody(int attendancetody) {
		this.attendancetody = attendancetody;
	}

	public double getAttendanceoneself() {
		return attendanceoneself;
	}

	public void setAttendanceoneself(double attendanceoneself) {
		this.attendanceoneself = attendanceoneself;
	}

	public int getEffectivework() {
		return effectivework;
	}

	public void setEffectivework(int effectivework) {
		this.effectivework = effectivework;
	}

	public int getSatisfactiondegree() {
		return satisfactiondegree;
	}

	public void setSatisfactiondegree(int satisfactiondegree) {
		this.satisfactiondegree = satisfactiondegree;
	}

//	public String getEquipments() {
//		return equipments;
//	}
//
//	public void setEquipments(String equipments) {
//		this.equipments = equipments;
//	}

	public String getWorkcomment() {
		return workcomment;
	}

	public void setWorkcomment(String workcomment) {
		this.workcomment = workcomment;
	}

	public String getAbnorname() {
		return abnorname;
	}

	public void setAbnorname(String abnorname) {
		this.abnorname = abnorname;
	}

	public String getDunning() {
		return dunning;
	}

	public void setDunning(String dunning) {
		this.dunning = dunning;
	}

	public String getDunningpic() {
		return dunningpic;
	}

	public void setDunningpic(String dunningpic) {
		this.dunningpic = dunningpic;
	}

	public BigDecimal getAmountody() {
		return amountody;
	}

	public void setAmountody(BigDecimal amountody) {
		this.amountody = amountody;
	}

	public BigDecimal getInvoicetody() {
		return invoicetody;
	}

	public void setInvoicetody(BigDecimal invoicetody) {
		this.invoicetody = invoicetody;
	}

	public String getDpic() {
		return dpic;
	}

	public void setDpic(String dpic) {
		this.dpic = dpic;
	}

	public String getDvoideo() {
		return dvoideo;
	}

	public void setDvoideo(String dvoideo) {
		this.dvoideo = dvoideo;
	}

	public String getDtime() {
		return dtime;
	}

	public void setDtime(String dtime) {
		this.dtime = dtime;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getCreattime() {
		return creattime;
	}

	public void setCreattime(String creattime) {
		this.creattime = creattime;
	}

	public String getWeatherName() {
		return weatherName;
	}

	public void setWeatherName(String weatherName) {
		this.weatherName = weatherName;
	}

	public String getEffectiveworkName() {
		return effectiveworkName;
	}

	public void setEffectiveworkName(String effectiveworkName) {
		this.effectiveworkName = effectiveworkName;
	}

	public String getSatisfactiondegreeName() {
		return satisfactiondegreeName;
	}

	public void setSatisfactiondegreeName(String satisfactiondegreeName) {
		this.satisfactiondegreeName = satisfactiondegreeName;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public int getUstatus() {
		return ustatus;
	}

	public void setUstatus(int ustatus) {
		this.ustatus = ustatus;
	}

	public List<String> getDpics() {
		return dpics;
	}

	public void setDpics(List<String> dpics) {
		this.dpics = dpics;
	}

	public List getDvoideos() {
		return dvoideos;
	}

	public void setDvoideos(List dvoideos) {
		this.dvoideos = dvoideos;
	}

}

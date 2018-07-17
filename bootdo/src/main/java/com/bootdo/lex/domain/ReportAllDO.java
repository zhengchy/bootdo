package com.bootdo.lex.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 
 * 
 * @author chunye
 * @email 1992lcg@163.com
 * @date 2018-07-02 10:48:32
 */
public class ReportAllDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Integer id;
	//report_templet主键
	private Integer rtId;

	public String getRtName() {
		return rtName;
	}

	public void setRtName(String rtName) {
		this.rtName = rtName;
	}

	private String rtName;

	public String getRtJson() {
		return rtJson;
	}

	public void setRtJson(String rtJson) {
		this.rtJson = rtJson;
	}

	private String rtJson;
	//excel文档序号
	private Integer excelId;
	//省
	private String province;
	//城市
	private String city;
	//客户名称
	private String customername;
	//大区总监
	private String supervision;
	//总监ID
	private Integer supervisionid;
	//商务经理
	private String manager;
	//经理Id
	private Integer managerid;
	//上次省站中标时间
	private String firsttime;
	//预计下次省站中标时间
	private String nexttime;
	//标期内区县遴选政策
	private String quxianzhengce;
	//下次遴选是否可增加为2个或以上规格
	private String shifouliangge;
	//遴选规则
	private String linxuanguize;
	//价格
	private String price;
	//日期
	private String reporttime;
	//备注
	private String desc;
	//占比
	private String zhanbi;
	//创建时间
	private Date createtime;
	//联系方式
	private String lianxifangshi;

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	private int state;


	public int getCountNum() {
		return countNum;
	}

	public void setCountNum(int countNum) {
		this.countNum = countNum;
	}

	private int countNum;

	/**
	 * 设置：
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * 获取：
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * 设置：report_templet主键
	 */
	public void setRtId(Integer rtId) {
		this.rtId = rtId;
	}
	/**
	 * 获取：report_templet主键
	 */
	public Integer getRtId() {
		return rtId;
	}
	/**
	 * 设置：excel文档序号
	 */
	public void setExcelId(Integer excelId) {
		this.excelId = excelId;
	}
	/**
	 * 获取：excel文档序号
	 */
	public Integer getExcelId() {
		return excelId;
	}
	/**
	 * 设置：省
	 */
	public void setProvince(String province) {
		this.province = province;
	}
	/**
	 * 获取：省
	 */
	public String getProvince() {
		return province;
	}
	/**
	 * 设置：城市
	 */
	public void setCity(String city) {
		this.city = city;
	}
	/**
	 * 获取：城市
	 */
	public String getCity() {
		return city;
	}
	/**
	 * 设置：客户名称
	 */
	public void setCustomername(String customername) {
		this.customername = customername;
	}
	/**
	 * 获取：客户名称
	 */
	public String getCustomername() {
		return customername;
	}
	/**
	 * 设置：大区总监
	 */
	public void setSupervision(String supervision) {
		this.supervision = supervision;
	}
	/**
	 * 获取：大区总监
	 */
	public String getSupervision() {
		return supervision;
	}
	/**
	 * 设置：总监ID
	 */
	public void setSupervisionid(Integer supervisionid) {
		this.supervisionid = supervisionid;
	}
	/**
	 * 获取：总监ID
	 */
	public Integer getSupervisionid() {
		return supervisionid;
	}
	/**
	 * 设置：商务经理
	 */
	public void setManager(String manager) {
		this.manager = manager;
	}
	/**
	 * 获取：商务经理
	 */
	public String getManager() {
		return manager;
	}
	/**
	 * 设置：经理Id
	 */
	public void setManagerid(Integer managerid) {
		this.managerid = managerid;
	}
	/**
	 * 获取：经理Id
	 */
	public Integer getManagerid() {
		return managerid;
	}
	/**
	 * 设置：上次省站中标时间
	 */
	public void setFirsttime(String firsttime) {
		this.firsttime = firsttime;
	}
	/**
	 * 获取：上次省站中标时间
	 */
	public String getFirsttime() {
		return firsttime;
	}
	/**
	 * 设置：预计下次省站中标时间
	 */
	public void setNexttime(String nexttime) {
		this.nexttime = nexttime;
	}
	/**
	 * 获取：预计下次省站中标时间
	 */
	public String getNexttime() {
		return nexttime;
	}
	/**
	 * 设置：标期内区县遴选政策
	 */
	public void setQuxianzhengce(String quxianzhengce) {
		this.quxianzhengce = quxianzhengce;
	}
	/**
	 * 获取：标期内区县遴选政策
	 */
	public String getQuxianzhengce() {
		return quxianzhengce;
	}
	/**
	 * 设置：下次遴选是否可增加为2个或以上规格
	 */
	public void setShifouliangge(String shifouliangge) {
		this.shifouliangge = shifouliangge;
	}
	/**
	 * 获取：下次遴选是否可增加为2个或以上规格
	 */
	public String getShifouliangge() {
		return shifouliangge;
	}
	/**
	 * 设置：遴选规则
	 */
	public void setLinxuanguize(String linxuanguize) {
		this.linxuanguize = linxuanguize;
	}
	/**
	 * 获取：遴选规则
	 */
	public String getLinxuanguize() {
		return linxuanguize;
	}
	/**
	 * 设置：价格
	 */
	public void setPrice(String price) {
		this.price = price;
	}
	/**
	 * 获取：价格
	 */
	public String getPrice() {
		return price;
	}
	/**
	 * 设置：日期
	 */
	public void setReporttime(String reporttime) {
		this.reporttime = reporttime;
	}
	/**
	 * 获取：日期
	 */
	public String getReporttime() {
		return reporttime;
	}
	/**
	 * 设置：备注
	 */
	public void setDesc(String desc) {
		this.desc = desc;
	}
	/**
	 * 获取：备注
	 */
	public String getDesc() {
		return desc;
	}
	/**
	 * 设置：占比
	 */
	public void setZhanbi(String zhanbi) {
		this.zhanbi = zhanbi;
	}
	/**
	 * 获取：占比
	 */
	public String getZhanbi() {
		return zhanbi;
	}
	/**
	 * 设置：创建时间
	 */
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
	/**
	 * 获取：创建时间
	 */
	public Date getCreatetime() {
		return createtime;
	}
	/**
	 * 设置：联系方式
	 */
	public void setLianxifangshi(String lianxifangshi) {
		this.lianxifangshi = lianxifangshi;
	}
	/**
	 * 获取：联系方式
	 */
	public String getLianxifangshi() {
		return lianxifangshi;
	}
}

package com.bootdo.lex.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 
 * 
 * @author chunye
 * @email 1992lcg@163.com
 * @date 2018-06-28 12:06:38
 */
public class ReportTempletDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Integer id;
	//
	private String name;
	//
	private String excelpath;
	//
	private String tmppath;
	//
	private String tmpjson;
	//
	private Date createtime;

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
	 * 设置：
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取：
	 */
	public String getName() {
		return name;
	}
	/**
	 * 设置：
	 */
	public void setExcelpath(String excelpath) {
		this.excelpath = excelpath;
	}
	/**
	 * 获取：
	 */
	public String getExcelpath() {
		return excelpath;
	}
	/**
	 * 设置：
	 */
	public void setTmppath(String tmppath) {
		this.tmppath = tmppath;
	}
	/**
	 * 获取：
	 */
	public String getTmppath() {
		return tmppath;
	}
	/**
	 * 设置：
	 */
	public void setTmpjson(String tmpjson) {
		this.tmpjson = tmpjson;
	}
	/**
	 * 获取：
	 */
	public String getTmpjson() {
		return tmpjson;
	}
	/**
	 * 设置：
	 */
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
	/**
	 * 获取：
	 */
	public Date getCreatetime() {
		return createtime;
	}
}

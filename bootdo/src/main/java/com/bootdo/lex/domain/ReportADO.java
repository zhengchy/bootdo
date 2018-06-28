package com.bootdo.lex.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 
 * 
 * @author chunye
 * @email 1992lcg@163.com
 * @date 2018-06-21 14:07:17
 */
public class ReportADO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Integer id;
	//
	private String a;
	//
	private String b;
	//
	private String c;
	//
	private String d;

	public String getE() {
		return e;
	}

	public void setE(String e) {
		this.e = e;
	}

	private String e;

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
	public void setA(String a) {
		this.a = a;
	}
	/**
	 * 获取：
	 */
	public String getA() {
		return a;
	}
	/**
	 * 设置：
	 */
	public void setB(String b) {
		this.b = b;
	}
	/**
	 * 获取：
	 */
	public String getB() {
		return b;
	}
	/**
	 * 设置：
	 */
	public void setC(String c) {
		this.c = c;
	}
	/**
	 * 获取：
	 */
	public String getC() {
		return c;
	}
	/**
	 * 设置：
	 */
	public void setD(String d) {
		this.d = d;
	}
	/**
	 * 获取：
	 */
	public String getD() {
		return d;
	}
}

package com.bootdo.lex.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 
 * 
 * @author chunye
 * @email 1992lcg@163.com
 * @date 2018-06-20 22:57:04
 */
public class RoleReportDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Integer id;
	//
	private Integer roleId;
	//
	private Integer reportId;
	//
	private String columns;
	//
	private Date createtime;


	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	private String roleName;

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
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
	/**
	 * 获取：
	 */
	public Integer getRoleId() {
		return roleId;
	}
	/**
	 * 设置：
	 */
	public void setReportId(Integer reportId) {
		this.reportId = reportId;
	}
	/**
	 * 获取：
	 */
	public Integer getReportId() {
		return reportId;
	}
	/**
	 * 设置：
	 */
	public void setColumns(String columns) {
		this.columns = columns;
	}
	/**
	 * 获取：
	 */
	public String getColumns() {
		return columns;
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

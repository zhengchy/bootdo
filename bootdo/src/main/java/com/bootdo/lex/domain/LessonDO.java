package com.bootdo.lex.domain;

import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;



/**
 * 
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2018-02-05 18:03:48
 */
public class LessonDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Integer id;
	//
	private String lessonname;
	//
	private Integer subjectid;
	//
	private Integer teacherid;
	//
	private Integer num;
	//
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date starttime;
	//
	private Date endtime;
	//
	private String desc;
	//
	private Date createtime;
	//
	private Date updatetime;
	//
	private Integer createuserid;
	//
	private Integer updateuserid;
	//
	private Integer state;

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
	public void setLessonname(String lessonname) {
		this.lessonname = lessonname;
	}
	/**
	 * 获取：
	 */
	public String getLessonname() {
		return lessonname;
	}
	/**
	 * 设置：
	 */
	public void setSubjectid(Integer subjectid) {
		this.subjectid = subjectid;
	}
	/**
	 * 获取：
	 */
	public Integer getSubjectid() {
		return subjectid;
	}
	/**
	 * 设置：
	 */
	public void setTeacherid(Integer teacherid) {
		this.teacherid = teacherid;
	}
	/**
	 * 获取：
	 */
	public Integer getTeacherid() {
		return teacherid;
	}
	/**
	 * 设置：
	 */
	public void setNum(Integer num) {
		this.num = num;
	}
	/**
	 * 获取：
	 */
	public Integer getNum() {
		return num;
	}
	/**
	 * 设置：
	 */
//	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public void setStarttime(Date starttime) {
		this.starttime = starttime;
	}
	/**
	 * 获取：
	 */
	public Date getStarttime() {
		return starttime;
	}
	/**
	 * 设置：
	 */
	public void setEndtime(Date endtime) {
		this.endtime = endtime;
	}
	/**
	 * 获取：
	 */
	public Date getEndtime() {
		return endtime;
	}
	/**
	 * 设置：
	 */
	public void setDesc(String desc) {
		this.desc = desc;
	}
	/**
	 * 获取：
	 */
	public String getDesc() {
		return desc;
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
	/**
	 * 设置：
	 */
	public void setUpdatetime(Date updatetime) {
		this.updatetime = updatetime;
	}
	/**
	 * 获取：
	 */
	public Date getUpdatetime() {
		return updatetime;
	}
	/**
	 * 设置：
	 */
	public void setCreateuserid(Integer createuserid) {
		this.createuserid = createuserid;
	}
	/**
	 * 获取：
	 */
	public Integer getCreateuserid() {
		return createuserid;
	}
	/**
	 * 设置：
	 */
	public void setUpdateuserid(Integer updateuserid) {
		this.updateuserid = updateuserid;
	}
	/**
	 * 获取：
	 */
	public Integer getUpdateuserid() {
		return updateuserid;
	}
	/**
	 * 设置：
	 */
	public void setState(Integer state) {
		this.state = state;
	}
	/**
	 * 获取：
	 */
	public Integer getState() {
		return state;
	}






	public String getTeacherName() {
		return teacherName;
	}

	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}

	private String teacherName;

}

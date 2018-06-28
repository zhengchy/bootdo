package com.bootdo.lex.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 
 * 
 * @author chunye
 * @email 1992lcg@163.com
 * @date 2018-02-09 16:44:11
 */
public class LessonStudentDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Long id;
	//课程ID
	private Long lessonid;
	//用户ID
	private Long userid;
	//
	private Date createtime;
	//
	private Integer state;

	/**
	 * 设置：
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 获取：
	 */
	public Long getId() {
		return id;
	}
	/**
	 * 设置：
	 */
	public void setLessonid(Long lessonid) {
		this.lessonid = lessonid;
	}
	/**
	 * 获取：
	 */
	public Long getLessonid() {
		return lessonid;
	}
	/**
	 * 设置：
	 */
	public void setUserid(Long userid) {
		this.userid = userid;
	}
	/**
	 * 获取：
	 */
	public Long getUserid() {
		return userid;
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
	public void setState(Integer state) {
		this.state = state;
	}
	/**
	 * 获取：
	 */
	public Integer getState() {
		return state;
	}

	public String getLessonName() {
		return lessonName;
	}

	public void setLessonName(String lessonName) {
		this.lessonName = lessonName;
	}

	private  String lessonName ;

}

package com.bootdo.lex.service;

import com.bootdo.lex.domain.LessonStudentDO;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author chunye
 * @email 1992lcg@163.com
 * @date 2018-02-09 16:44:11
 */
public interface LessonStudentService {
	
	LessonStudentDO get(Long id);
	
	List<LessonStudentDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(LessonStudentDO lessonStudent);
	
	int update(LessonStudentDO lessonStudent);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);
}

package com.bootdo.lex.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.bootdo.lex.dao.LessonStudentDao;
import com.bootdo.lex.domain.LessonStudentDO;
import com.bootdo.lex.service.LessonStudentService;



@Service
public class LessonStudentServiceImpl implements LessonStudentService {
	@Autowired
	private LessonStudentDao lessonStudentDao;
	
	@Override
	public LessonStudentDO get(Long id){
		return lessonStudentDao.get(id);
	}
	
	@Override
	public List<LessonStudentDO> list(Map<String, Object> map){
		return lessonStudentDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return lessonStudentDao.count(map);
	}
	
	@Override
	public int save(LessonStudentDO lessonStudent){
		return lessonStudentDao.save(lessonStudent);
	}
	
	@Override
	public int update(LessonStudentDO lessonStudent){
		return lessonStudentDao.update(lessonStudent);
	}
	
	@Override
	public int remove(Long id){
		return lessonStudentDao.remove(id);
	}
	
	@Override
	public int batchRemove(Long[] ids){
		return lessonStudentDao.batchRemove(ids);
	}
	
}

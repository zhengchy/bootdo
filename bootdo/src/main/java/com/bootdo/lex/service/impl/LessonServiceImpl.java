package com.bootdo.lex.service.impl;

import com.bootdo.lex.dao.LessonDao;
import com.bootdo.lex.domain.LessonDO;
import com.bootdo.lex.service.LessonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;





@Service
public class LessonServiceImpl implements LessonService {
	@Autowired
	private LessonDao lessonDao;
	
	@Override
	public LessonDO get(Integer id){
		return lessonDao.get(id);
	}
	
	@Override
	public List<LessonDO> list(Map<String, Object> map){
		return lessonDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return lessonDao.count(map);
	}
	
	@Override
	public int save(LessonDO lesson){
		return lessonDao.save(lesson);
	}
	
	@Override
	public int update(LessonDO lesson){
		return lessonDao.update(lesson);
	}
	
	@Override
	public int remove(Integer id){
		return lessonDao.remove(id);
	}
	
	@Override
	public int batchRemove(Integer[] ids){
		return lessonDao.batchRemove(ids);
	}
	
}

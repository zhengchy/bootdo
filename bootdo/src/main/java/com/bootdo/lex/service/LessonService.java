package com.bootdo.lex.service;



import com.bootdo.lex.domain.LessonDO;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2018-02-05 18:03:48
 */
public interface LessonService {
	
	LessonDO get(Integer id);
	
	List<LessonDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(LessonDO lesson);
	
	int update(LessonDO lesson);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);
}

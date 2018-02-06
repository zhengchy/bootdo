package com.bootdo.lex.dao;


import java.util.List;
import java.util.Map;

import com.bootdo.lex.domain.LessonDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2018-02-05 18:03:48
 */
@Mapper
public interface LessonDao {

	LessonDO get(Integer id);
	
	List<LessonDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(LessonDO lesson);
	
	int update(LessonDO lesson);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);
}

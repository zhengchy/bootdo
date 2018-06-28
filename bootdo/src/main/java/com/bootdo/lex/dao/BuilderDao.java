package com.bootdo.lex.dao;

import com.bootdo.lex.domain.BuilderDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2018-06-19 11:04:59
 */
@Mapper
public interface BuilderDao {

	BuilderDO get(Integer id);
	
	List<BuilderDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(BuilderDO builder);
	
	int update(BuilderDO builder);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);
}

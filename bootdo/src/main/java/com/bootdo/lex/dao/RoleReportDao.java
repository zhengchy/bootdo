package com.bootdo.lex.dao;

import com.bootdo.lex.domain.RoleReportDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 
 * @author chunye
 * @email 1992lcg@163.com
 * @date 2018-06-20 22:57:04
 */
@Mapper
public interface RoleReportDao {

	RoleReportDO get(Integer id);
	
	List<RoleReportDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(RoleReportDO roleReport);
	
	int update(RoleReportDO roleReport);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);
}

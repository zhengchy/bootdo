package com.bootdo.lex.dao;

import com.bootdo.lex.domain.ReportAllDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 
 * @author chunye
 * @email 1992lcg@163.com
 * @date 2018-07-01 15:03:41
 */
@Mapper
public interface ReportAllDao {

	ReportAllDO get(Integer id);
	
	List<ReportAllDO> list(Map<String, Object> map);
	List<ReportAllDO> listGroup(Map<String, Object> map);

	int count(Map<String, Object> map);
	int countGroup(Map<String, Object> map);

	int save(ReportAllDO reportAll);
	
	int update(ReportAllDO reportAll);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);
}

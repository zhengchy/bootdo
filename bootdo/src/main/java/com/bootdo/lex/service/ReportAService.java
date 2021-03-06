package com.bootdo.lex.service;

import com.bootdo.lex.domain.ReportADO;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author chunye
 * @email 1992lcg@163.com
 * @date 2018-06-21 14:07:17
 */
public interface ReportAService {
	
	ReportADO get(Integer id);
	
	List<ReportADO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(ReportADO reportA);
	
	int update(ReportADO reportA);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);
}

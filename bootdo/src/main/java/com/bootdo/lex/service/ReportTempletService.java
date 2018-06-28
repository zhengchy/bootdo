package com.bootdo.lex.service;

import com.bootdo.lex.domain.ReportTempletDO;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author chunye
 * @email 1992lcg@163.com
 * @date 2018-06-28 12:06:38
 */
public interface ReportTempletService {
	
	ReportTempletDO get(Integer id);
	
	List<ReportTempletDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(ReportTempletDO reportTemplet);
	
	int update(ReportTempletDO reportTemplet);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);
}

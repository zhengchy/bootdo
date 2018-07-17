package com.bootdo.lex.service;

import com.bootdo.lex.domain.ReportTempletDO;
import com.chamc.groups.projectmanage.plugin.excel.entity.ExcelConfig;
import com.chamc.groups.projectmanage.plugin.excel.error.Errors;

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

	int saveReport(ReportTempletDO reportTemplet,Errors errors,ExcelConfig excelConfig) throws Exception;
	
	int update(ReportTempletDO reportTemplet);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);
}

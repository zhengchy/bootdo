package com.bootdo.lex.service.impl;

import com.bootdo.common.utils.EntityUtils;
import com.bootdo.common.utils.R;
import com.bootdo.lex.dao.ReportAllDao;
import com.bootdo.lex.domain.ReportAllDO;
import com.chamc.groups.projectmanage.plugin.excel.ExcelBakData;
import com.chamc.groups.projectmanage.plugin.excel.entity.ExcelConfig;
import com.chamc.groups.projectmanage.plugin.excel.entity.imp.Column;
import com.chamc.groups.projectmanage.plugin.excel.error.Errors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.bootdo.lex.dao.ReportTempletDao;
import com.bootdo.lex.domain.ReportTempletDO;
import com.bootdo.lex.service.ReportTempletService;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


@Service
public class ReportTempletServiceImpl implements ReportTempletService {
	@Autowired
	private ReportTempletDao reportTempletDao;

	@Autowired
	private ReportAllDao reportAllDao;
	
	@Override
	public ReportTempletDO get(Integer id){
		return reportTempletDao.get(id);
	}
	
	@Override
	public List<ReportTempletDO> list(Map<String, Object> map){
		return reportTempletDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return reportTempletDao.count(map);
	}
	
	@Override
	public int save(ReportTempletDO reportTemplet){
		return reportTempletDao.save(reportTemplet);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,timeout=36000,rollbackFor=Exception.class)
	public int saveReport(ReportTempletDO reportTemplet, Errors errors,ExcelConfig excelConfig) throws Exception {
		reportTemplet.setCreatetime(new Date());
		if(reportTempletDao.save(reportTemplet)<1){
			return 0;
		}
		List<Column> columnList = excelConfig.getColumnList();
		ExcelBakData ebd =  errors.getEbd();
		LinkedHashMap<String,Map<String,Object>> map = ebd.getMap();

		for (Map.Entry<String,Map<String,Object>> entry :map.entrySet()) {
//			System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
			String row = entry.getKey();
			ReportAllDO reportAllDO = new ReportAllDO();
			reportAllDO.setRtId(reportTemplet.getId());
			for (int i = 0; i < columnList.size(); i++) {
				Column column =  columnList.get(i);
				String filedName= column.getField();
				Object value = ebd.get(row,column.getLocation());
				if(value!=null) {
					EntityUtils.setField(reportAllDO, filedName, value);
				}
			}
			reportAllDO.setCreatetime(new Date());
			if(reportAllDao.save(reportAllDO)<1){
				return 0;
			}

		}

		return 1;
	}

	@Override
	public int update(ReportTempletDO reportTemplet){
		return reportTempletDao.update(reportTemplet);
	}
	
	@Override
	public int remove(Integer id){
		return reportTempletDao.remove(id);
	}
	
	@Override
	public int batchRemove(Integer[] ids){
		return reportTempletDao.batchRemove(ids);
	}
	
}

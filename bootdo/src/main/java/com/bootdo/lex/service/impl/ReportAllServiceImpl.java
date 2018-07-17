package com.bootdo.lex.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.bootdo.lex.dao.ReportAllDao;
import com.bootdo.lex.domain.ReportAllDO;
import com.bootdo.lex.service.ReportAllService;



@Service
public class ReportAllServiceImpl implements ReportAllService {
	@Autowired
	private ReportAllDao reportAllDao;
	
	@Override
	public ReportAllDO get(Integer id){
		return reportAllDao.get(id);
	}
	
	@Override
	public List<ReportAllDO> list(Map<String, Object> map){
		return reportAllDao.list(map);
	}

	@Override
	public List<ReportAllDO> listGroup(Map<String, Object> map) {
		return reportAllDao.listGroup(map);
	}

	@Override
	public int count(Map<String, Object> map){
		return reportAllDao.count(map);
	}
	public int countGroup(Map<String, Object> map){
		return reportAllDao.countGroup(map);
	}

	@Override
	public int save(ReportAllDO reportAll){
		return reportAllDao.save(reportAll);
	}
	
	@Override
	public int update(ReportAllDO reportAll){
		return reportAllDao.update(reportAll);
	}
	
	@Override
	public int remove(Integer id){
		return reportAllDao.remove(id);
	}
	
	@Override
	public int batchRemove(Integer[] ids){
		return reportAllDao.batchRemove(ids);
	}
	
}

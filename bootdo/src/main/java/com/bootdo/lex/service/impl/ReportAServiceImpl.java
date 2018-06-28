package com.bootdo.lex.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.bootdo.lex.dao.ReportADao;
import com.bootdo.lex.domain.ReportADO;
import com.bootdo.lex.service.ReportAService;



@Service
public class ReportAServiceImpl implements ReportAService {
	@Autowired
	private ReportADao reportADao;
	
	@Override
	public ReportADO get(Integer id){
		return reportADao.get(id);
	}
	
	@Override
	public List<ReportADO> list(Map<String, Object> map){
		return reportADao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return reportADao.count(map);
	}
	
	@Override
	public int save(ReportADO reportA){
		return reportADao.save(reportA);
	}
	
	@Override
	public int update(ReportADO reportA){
		return reportADao.update(reportA);
	}
	
	@Override
	public int remove(Integer id){
		return reportADao.remove(id);
	}
	
	@Override
	public int batchRemove(Integer[] ids){
		return reportADao.batchRemove(ids);
	}
	
}

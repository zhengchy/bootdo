package com.bootdo.lex.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.bootdo.lex.dao.ReportTempletDao;
import com.bootdo.lex.domain.ReportTempletDO;
import com.bootdo.lex.service.ReportTempletService;



@Service
public class ReportTempletServiceImpl implements ReportTempletService {
	@Autowired
	private ReportTempletDao reportTempletDao;
	
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

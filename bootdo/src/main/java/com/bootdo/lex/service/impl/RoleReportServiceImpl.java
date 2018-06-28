package com.bootdo.lex.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.bootdo.lex.dao.RoleReportDao;
import com.bootdo.lex.domain.RoleReportDO;
import com.bootdo.lex.service.RoleReportService;



@Service
public class RoleReportServiceImpl implements RoleReportService {
	@Autowired
	private RoleReportDao roleReportDao;
	
	@Override
	public RoleReportDO get(Integer id){
		return roleReportDao.get(id);
	}
	
	@Override
	public List<RoleReportDO> list(Map<String, Object> map){
		return roleReportDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return roleReportDao.count(map);
	}
	
	@Override
	public int save(RoleReportDO roleReport){
		return roleReportDao.save(roleReport);
	}
	
	@Override
	public int update(RoleReportDO roleReport){
		return roleReportDao.update(roleReport);
	}
	
	@Override
	public int remove(Integer id){
		return roleReportDao.remove(id);
	}
	
	@Override
	public int batchRemove(Integer[] ids){
		return roleReportDao.batchRemove(ids);
	}
	
}

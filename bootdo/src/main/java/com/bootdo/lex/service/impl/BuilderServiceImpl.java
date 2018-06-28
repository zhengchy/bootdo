package com.bootdo.lex.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.bootdo.lex.dao.BuilderDao;
import com.bootdo.lex.domain.BuilderDO;
import com.bootdo.lex.service.BuilderService;



@Service
public class BuilderServiceImpl implements BuilderService {
	@Autowired
	private BuilderDao builderDao;
	
	@Override
	public BuilderDO get(Integer id){
		return builderDao.get(id);
	}
	
	@Override
	public List<BuilderDO> list(Map<String, Object> map){
		return builderDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return builderDao.count(map);
	}
	
	@Override
	public int save(BuilderDO builder){
		return builderDao.save(builder);
	}
	
	@Override
	public int update(BuilderDO builder){
		return builderDao.update(builder);
	}
	
	@Override
	public int remove(Integer id){
		return builderDao.remove(id);
	}
	
	@Override
	public int batchRemove(Integer[] ids){
		return builderDao.batchRemove(ids);
	}
	
}

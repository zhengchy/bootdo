package com.bootdo.lex.controller;

import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bootdo.lex.domain.BuilderDO;
import com.bootdo.lex.service.BuilderService;
import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.Query;
import com.bootdo.common.utils.R;

/**
 * 
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2018-06-19 11:04:59
 */
 
@Controller
@RequestMapping("/lex/builder")
public class BuilderController {
	@Autowired
	private BuilderService builderService;
	
	@GetMapping()
	@RequiresPermissions("lex:builder:builder")
	String Builder(){
	    return "lex/builder/builder";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("lex:builder:builder")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<BuilderDO> builderList = builderService.list(query);
		int total = builderService.count(query);
		PageUtils pageUtils = new PageUtils(builderList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("lex:builder:add")
	String add(){
	    return "lex/builder/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("lex:builder:edit")
	String edit(@PathVariable("id") Integer id,Model model){
		BuilderDO builder = builderService.get(id);
		model.addAttribute("builder", builder);
	    return "lex/builder/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("lex:builder:add")
	public R save( BuilderDO builder){
		if(builderService.save(builder)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("lex:builder:edit")
	public R update( BuilderDO builder){
		builderService.update(builder);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("lex:builder:remove")
	public R remove( Integer id){
		if(builderService.remove(id)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("lex:builder:batchRemove")
	public R remove(@RequestParam("ids[]") Integer[] ids){
		builderService.batchRemove(ids);
		return R.ok();
	}
	
}

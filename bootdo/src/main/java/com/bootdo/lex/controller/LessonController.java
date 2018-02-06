package com.bootdo.lex.controller;

import java.util.List;
import java.util.Map;

import com.bootdo.lex.domain.LessonDO;
import com.bootdo.lex.service.LessonService;
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


import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.Query;
import com.bootdo.common.utils.R;

/**
 * 
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2018-02-05 18:03:48
 */
 
@Controller
@RequestMapping("/system/lesson")
public class LessonController {
	@Autowired
	private LessonService lessonService;
	
	@GetMapping()
	@RequiresPermissions("system:lesson:lesson")
	String Lesson(){
	    return "system/lesson/lesson";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("system:lesson:lesson")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<LessonDO> lessonList = lessonService.list(query);
		int total = lessonService.count(query);
		PageUtils pageUtils = new PageUtils(lessonList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("system:lesson:add")
	String add(){
	    return "system/lesson/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("system:lesson:edit")
	String edit(@PathVariable("id") Integer id,Model model){
		LessonDO lesson = lessonService.get(id);
		model.addAttribute("lesson", lesson);
	    return "system/lesson/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("system:lesson:add")
	public R save( LessonDO lesson){
		if(lessonService.save(lesson)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("system:lesson:edit")
	public R update( LessonDO lesson){
		lessonService.update(lesson);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("system:lesson:remove")
	public R remove( Integer id){
		if(lessonService.remove(id)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("system:lesson:batchRemove")
	public R remove(@RequestParam("ids[]") Integer[] ids){
		lessonService.batchRemove(ids);
		return R.ok();
	}
	
}

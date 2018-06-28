package com.bootdo.lex.controller;

import java.util.List;
import java.util.Map;

import com.bootdo.common.controller.BaseController;
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

import com.bootdo.lex.domain.LessonStudentDO;
import com.bootdo.lex.service.LessonStudentService;
import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.Query;
import com.bootdo.common.utils.R;

/**
 * 
 * 
 * @author chunye
 * @email 1992lcg@163.com
 * @date 2018-02-09 16:44:11
 */
 
@Controller
@RequestMapping("/lex/lessonStudent")
public class LessonStudentController extends BaseController {
	@Autowired
	private LessonStudentService lessonStudentService;
	
	@GetMapping()
	@RequiresPermissions("lex:lessonStudent:lessonStudent")
	String LessonStudent(String lessonId,Model model){
		model.addAttribute("lessonId",lessonId);
		return "lex/lessonStudent/lessonStudent";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("lex:lessonStudent:lessonStudent")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<LessonStudentDO> lessonStudentList = lessonStudentService.list(query);
		int total = lessonStudentService.count(query);
		PageUtils pageUtils = new PageUtils(lessonStudentList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("lex:lessonStudent:add")
	String add(){
	    return "lex/lessonStudent/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("lex:lessonStudent:edit")
	String edit(@PathVariable("id") Long id,Model model){
		LessonStudentDO lessonStudent = lessonStudentService.get(id);
		model.addAttribute("lessonStudent", lessonStudent);
	    return "lex/lessonStudent/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("lex:lessonStudent:add")
	public R save( LessonStudentDO lessonStudent){
		if(lessonStudentService.save(lessonStudent)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("lex:lessonStudent:edit")
	public R update( LessonStudentDO lessonStudent){
		lessonStudentService.update(lessonStudent);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("lex:lessonStudent:remove")
	public R remove( Long id){
		if(lessonStudentService.remove(id)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("lex:lessonStudent:batchRemove")
	public R remove(@RequestParam("ids[]") Long[] ids){
		lessonStudentService.batchRemove(ids);
		return R.ok();
	}
	
}

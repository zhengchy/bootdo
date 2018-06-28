package com.bootdo.lex.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.bootdo.common.controller.BaseController;
import com.bootdo.lex.domain.BuilderDO;
import com.bootdo.lex.domain.LessonDO;
import com.bootdo.lex.service.BuilderService;
import com.bootdo.lex.service.LessonService;
import com.bootdo.system.service.UserService;
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

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2018-02-05 18:03:48
 */
 
@Controller
@RequestMapping("/system/lesson")
public class LessonController extends BaseController {
	@Autowired
	private LessonService lessonService;
	@Autowired
	private UserService userService;
	@Autowired
	private BuilderService builderService;
	
	@GetMapping()
	@RequiresPermissions("system:lesson:lesson")
	String Lesson(){
	    return "system/lesson/lesson";
	}


	@GetMapping("/builder")
	String builder(){
		return "form/builder";
	}

	@PostMapping("/builderSave")
	public void builderSave(String htmlCode,String codeName, HttpServletResponse response,HttpServletRequest request) throws IOException {
		String ss = htmlCode;
		BuilderDO bd = new BuilderDO();
		bd.setHtml(htmlCode);
		bd.setName(codeName);
		bd.setCreatetime(new Date());
		response.setCharacterEncoding("UTF8");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>存储结果</title>");
		out.println("</head>");
		out.println("<body>");
		if(builderService.save(bd)>0){
			out.println("处理完成");
		}else{
			out.println("存储失败");
		}
		out.println("</body>");
		out.println("</html>");

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
	String add(Model model){
	    List<Map> list = userService.getUserByRoleId(new Long(48));
		model.addAttribute("teacherList", list);
		return "system/lesson/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("system:lesson:edit")
	String edit(@PathVariable("id") Integer id,Model model){
		LessonDO lesson = lessonService.get(id);
		model.addAttribute("lesson", lesson);
		List<Map> list = userService.getUserByRoleId(new Long(48));
		model.addAttribute("teacherList", list);
	    return "system/lesson/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("system:lesson:add")
	public R save( LessonDO lesson){
		lesson.setCreatetime(nowDate());
		lesson.setCreateuserid(getUserId().intValue());
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
		lesson.setUpdatetime(nowDate());
		lesson.setUpdateuserid(getUserId().intValue());
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

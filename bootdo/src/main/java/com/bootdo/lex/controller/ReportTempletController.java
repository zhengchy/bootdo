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

import com.bootdo.lex.domain.ReportTempletDO;
import com.bootdo.lex.service.ReportTempletService;
import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.Query;
import com.bootdo.common.utils.R;

/**
 * 
 * 
 * @author chunye
 * @email 1992lcg@163.com
 * @date 2018-06-28 12:06:38
 */
 
@Controller
@RequestMapping("/lex/reportTemplet")
public class ReportTempletController {
	@Autowired
	private ReportTempletService reportTempletService;
	
	@GetMapping()
	@RequiresPermissions("lex:reportTemplet:reportTemplet")
	String ReportTemplet(){
	    return "lex/reportTemplet/reportTemplet";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("lex:reportTemplet:reportTemplet")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<ReportTempletDO> reportTempletList = reportTempletService.list(query);
		int total = reportTempletService.count(query);
		PageUtils pageUtils = new PageUtils(reportTempletList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("lex:reportTemplet:add")
	String add(){
	    return "lex/reportTemplet/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("lex:reportTemplet:edit")
	String edit(@PathVariable("id") Integer id,Model model){
		ReportTempletDO reportTemplet = reportTempletService.get(id);
		model.addAttribute("reportTemplet", reportTemplet);
	    return "lex/reportTemplet/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("lex:reportTemplet:add")
	public R save( ReportTempletDO reportTemplet){
		if(reportTempletService.save(reportTemplet)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("lex:reportTemplet:edit")
	public R update( ReportTempletDO reportTemplet){
		reportTempletService.update(reportTemplet);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("lex:reportTemplet:remove")
	public R remove( Integer id){
		if(reportTempletService.remove(id)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("lex:reportTemplet:batchRemove")
	public R remove(@RequestParam("ids[]") Integer[] ids){
		reportTempletService.batchRemove(ids);
		return R.ok();
	}
	
}

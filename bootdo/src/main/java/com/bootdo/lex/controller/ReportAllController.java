package com.bootdo.lex.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.bootdo.common.controller.BaseController;
import com.bootdo.lex.domain.ReportTempletDO;
import com.bootdo.lex.service.ReportTempletService;
import com.chamc.groups.projectmanage.plugin.excel.entity.ExcelConfig;
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

import com.bootdo.lex.domain.ReportAllDO;
import com.bootdo.lex.service.ReportAllService;
import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.Query;
import com.bootdo.common.utils.R;

/**
 * 
 * 
 * @author chunye
 * @email 1992lcg@163.com
 * @date 2018-07-01 15:03:41
 */
 
@Controller
@RequestMapping("/lex/reportAll")
public class ReportAllController extends BaseController {
	@Autowired
	private ReportAllService reportAllService;

	@Autowired
	private ReportTempletService reportTempletService;
	
	@GetMapping()
	@RequiresPermissions("lex:reportAll:reportAll")
	String ReportAll(){
	    return "lex/reportAll/reportAll";
	}


	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("lex:reportAll:reportAll")
	public PageUtils list(@RequestParam Map<String, Object> params){
		params.put("managerid",getUserId());
		//查询列表数据
        Query query = new Query(params);
		List<ReportAllDO> reportAllList = reportAllService.list(query);
		int total = reportAllService.count(query);
		PageUtils pageUtils = new PageUtils(reportAllList, total);
		return pageUtils;
	}

	
	@GetMapping("/add")
	@RequiresPermissions("lex:reportAll:add")
	String add(){
	    return "lex/reportAll/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("lex:reportAll:edit")
	String edit(@PathVariable("id") Integer id,Model model) throws IOException {
		ReportAllDO reportAll = reportAllService.get(id);
		ReportTempletDO reportTempletDO = reportTempletService.get(reportAll.getRtId());
		ExcelConfig excelConfig = ExcelConfig.initConfigJson(reportTempletDO.getTmpjson());
		model.addAttribute("columnList",excelConfig.getColumnList());
		model.addAttribute("reportAll", reportAll);
//		model.addAttribute("testName", "city");
//		model.addAttribute("province", "aaa");
//		model.addAttribute("city", "bbb");
	    return "lex/reportAll/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("lex:reportAll:add")
	public R save( ReportAllDO reportAll){
		if(reportAllService.save(reportAll)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("lex:reportAll:edit")
	public R update( ReportAllDO reportAll){
		reportAll.setState(1);
		reportAllService.update(reportAll);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("lex:reportAll:remove")
	public R remove( Integer id){
		if(reportAllService.remove(id)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("lex:reportAll:batchRemove")
	public R remove(@RequestParam("ids[]") Integer[] ids){
		reportAllService.batchRemove(ids);
		return R.ok();
	}
	
}

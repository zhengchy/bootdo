package com.bootdo.lex.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.bootdo.lex.domain.ReportDo;
import com.bootdo.system.domain.RoleDO;
import com.bootdo.system.service.RoleService;
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

import com.bootdo.lex.domain.RoleReportDO;
import com.bootdo.lex.service.RoleReportService;
import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.Query;
import com.bootdo.common.utils.R;

/**
 * 
 * 
 * @author chunye
 * @email 1992lcg@163.com
 * @date 2018-06-20 22:57:04
 */
 
@Controller
@RequestMapping("/lex/roleReport")
public class RoleReportController {
	@Autowired
	private RoleReportService roleReportService;

	@Autowired
	RoleService roleService;
	
	@GetMapping()
	@RequiresPermissions("lex:roleReport:roleReport")
	String RoleReport(){
	    return "lex/roleReport/roleReport";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("lex:roleReport:roleReport")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<RoleReportDO> roleReportList = roleReportService.list(query);
		int total = roleReportService.count(query);
		PageUtils pageUtils = new PageUtils(roleReportList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("lex:roleReport:add")
	String add(Model model){
		List<RoleDO> roles = roleService.list();
		model.addAttribute("roles", roles);
		List<ReportDo> reportList = getReportList();
		model.addAttribute("reportList", reportList);
		return "lex/roleReport/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("lex:roleReport:edit")
	String edit(@PathVariable("id") Integer id,Model model){
		RoleReportDO roleReport = roleReportService.get(id);
		model.addAttribute("roleReport", roleReport);
		List<RoleDO> roles = roleService.list();
		model.addAttribute("roles", roles);
		String columns = roleReport.getColumns();
		List<ReportDo> reportList = getReportList();
		for (int i = 0; i < reportList.size(); i++) {
			ReportDo reportDo =  reportList.get(i);
			String value = reportDo.getValue();
			if(columns.indexOf(value)!=-1){
				reportDo.setFlag(true);
			}else{
				reportDo.setFlag(false);
			}
		}
		model.addAttribute("reportList", reportList);
	    return "lex/roleReport/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("lex:roleReport:add")
	public R save( RoleReportDO roleReport){
		roleReport.setCreatetime(new Date());
		if(roleReportService.save(roleReport)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("lex:roleReport:edit")
	public R update( RoleReportDO roleReport){
		roleReportService.update(roleReport);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("lex:roleReport:remove")
	public R remove( Integer id){
		if(roleReportService.remove(id)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("lex:roleReport:batchRemove")
	public R remove(@RequestParam("ids[]") Integer[] ids){
		roleReportService.batchRemove(ids);
		return R.ok();
	}


	private List<ReportDo> getReportList(){
		List<ReportDo> list = new ArrayList<>();
		ReportDo a = new ReportDo();
		a.setValue("a");
		ReportDo b = new ReportDo();
		b.setValue("b");
		ReportDo c = new ReportDo();
		c.setValue("c");
		ReportDo d = new ReportDo();
		d.setValue("d");
		ReportDo e = new ReportDo();
		e.setValue("e");
		list.add(a);
		list.add(b);
		list.add(c);
		list.add(d);
		list.add(e);
		return  list;
	}
	
}

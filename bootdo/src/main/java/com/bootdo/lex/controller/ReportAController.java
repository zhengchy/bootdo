package com.bootdo.lex.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.bootdo.common.controller.BaseController;
import com.bootdo.lex.domain.RoleReportDO;
import com.bootdo.lex.service.RoleReportService;
import com.bootdo.system.domain.UserDO;
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

import com.bootdo.lex.domain.ReportADO;
import com.bootdo.lex.service.ReportAService;
import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.Query;
import com.bootdo.common.utils.R;

/**
 * 
 * 
 * @author chunye
 * @email 1992lcg@163.com
 * @date 2018-06-21 14:07:17
 */
 
@Controller
@RequestMapping("/lex/reportA")
public class ReportAController extends BaseController {
	@Autowired
	private ReportAService reportAService;

	@Autowired
	private RoleReportService roleReportService;
	
	@GetMapping()
	@RequiresPermissions("lex:reportA:reportA")
	String ReportA(Model model){
		UserDO user =  getUser();
		List<Long> roleIds = user.getRoleIds();
		HashMap<String,Object> columnMap = new HashMap<>();
		columnMap.put("a",false);
		columnMap.put("b",false);
		columnMap.put("c",false);
		columnMap.put("d",false);
		columnMap.put("e",false);
		for (int i = 0; i < roleIds.size(); i++) {
			Long aLong =  roleIds.get(i);
			HashMap<String,Object> map = new HashMap<>();
			map.put("roleId",aLong);
			map.put("reportId",1);
			List<RoleReportDO> list = roleReportService.list(map);
			for (int j = 0; j < list.size(); j++) {
				RoleReportDO roleReportDO =  list.get(j);
				String[] columnArray = roleReportDO.getColumns().split(",");
				for (int k = 0; k < columnArray.length; k++) {
					 String column= columnArray[k];
					columnMap.put(column,true);
				}
				
			}
		}

		model.addAttribute("columnMap",columnMap);
	    return "lex/reportA/reportA";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("lex:reportA:reportA")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<ReportADO> reportAList = reportAService.list(query);
		int total = reportAService.count(query);
		PageUtils pageUtils = new PageUtils(reportAList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("lex:reportA:add")
	String add(){
	    return "lex/reportA/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("lex:reportA:edit")
	String edit(@PathVariable("id") Integer id,Model model){
		ReportADO reportA = reportAService.get(id);
		model.addAttribute("reportA", reportA);
	    return "lex/reportA/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("lex:reportA:add")
	public R save( ReportADO reportA){
		if(reportAService.save(reportA)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("lex:reportA:edit")
	public R update( ReportADO reportA){
		reportAService.update(reportA);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("lex:reportA:remove")
	public R remove( Integer id){
		if(reportAService.remove(id)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("lex:reportA:batchRemove")
	public R remove(@RequestParam("ids[]") Integer[] ids){
		reportAService.batchRemove(ids);
		return R.ok();
	}
	
}

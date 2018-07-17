package com.bootdo.lex.controller;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

import com.bootdo.lex.service.ReportAllService;
import com.chamc.groups.projectmanage.plugin.excel.entity.ExcelConfig;
import com.chamc.groups.projectmanage.plugin.excel.error.Errors;
import com.chamc.groups.projectmanage.plugin.excel.utils.ExcelJobUtil;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
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
import org.springframework.web.multipart.MultipartFile;

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


	@Autowired
	private ReportAllService reportAllService;

	@Autowired
	private ExcelJobUtil excelJobUtil;
	
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
	public R save( ReportTempletDO reportTemplet,@RequestParam("excelFile")MultipartFile excelFile,@RequestParam("tmpFile")MultipartFile tmpFile) throws Exception{
		if(excelFile!=null && tmpFile!=null) {
//		校验数据文件后拽
			String excel = "xls,xlsx,xlsm";
			String excelName = excelFile.getOriginalFilename();
			int a = excelName.lastIndexOf(".");
			if ((a > -1) && (a < excelName.length())) {
				if (excel.indexOf(excelName.substring(a + 1)) == -1) {
					return	R.error("数据文件格式不匹配，需为xls,xlsx,xlsm");
				}
			}
			//校验模本文件后缀
			String json = "json";
			String tmpName = tmpFile.getOriginalFilename();
			int b = tmpName.lastIndexOf(".");
			if ((b > -1) && (b < tmpName.length())) {
				if (json.indexOf(tmpName.substring(b + 1)) == -1) {
					return R.error("模板文件格式不匹配，需为json");
				}
			}
		}else{
			return	R.error("模板文件与数据文件，必须上传");
		}

		XSSFWorkbook xssfWorkbook =  new XSSFWorkbook(excelFile.getInputStream());;
		ExcelConfig config = ExcelConfig.initConfig(tmpFile.getInputStream(),tmpFile.getOriginalFilename());
		String json = getFileString(tmpFile.getInputStream());
		reportTemplet.setTmpjson(json);
		Errors errors = excelJobUtil.execute(xssfWorkbook, config);

//			if(reportTempletService.save(reportTemplet)>0){
			if(reportTempletService.saveReport(reportTemplet,errors,config)>0){
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


	private String getFileString(InputStream file) throws IOException {
		ByteArrayOutputStream baos = new  ByteArrayOutputStream();
		int   i=-1;
		while((i=file.read())!=-1){
			baos.write(i);
		}
		String jsonStr = baos.toString();
		baos.close();
		file.close();
		return  jsonStr;
	}
	
}

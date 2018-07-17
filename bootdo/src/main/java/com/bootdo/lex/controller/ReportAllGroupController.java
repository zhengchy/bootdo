package com.bootdo.lex.controller;

import com.bootdo.common.controller.BaseController;
import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.Query;
import com.bootdo.lex.domain.ReportAllDO;
import com.bootdo.lex.domain.ReportTempletDO;
import com.bootdo.lex.service.ReportAllService;
import com.bootdo.lex.service.ReportTempletService;
import com.chamc.groups.projectmanage.plugin.excel.entity.ExcelConfig;
import com.chamc.groups.projectmanage.plugin.excel.entity.imp.Column;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * Created by chunye on 18/7/4.
 */
@Controller
@RequestMapping("/lex/reportAllGroup")
public class ReportAllGroupController  extends BaseController {
    @Autowired
    private ReportAllService reportAllService;

    @Autowired
    private ReportTempletService reportTempletService;


    @GetMapping()
    @RequiresPermissions("lex:reportAllGroup:reportAllGroup")
    String reportAllGroup(){
        return "lex/reportAllGroup/reportAllGroup";
    }

    @GetMapping("reportAllGroupDetail")
    String reportAllGroupDetail(String rtId, Model model) throws Exception{
        model.addAttribute("rtId",rtId);
        ReportTempletDO reportTempletDO = reportTempletService.get(Integer.parseInt(rtId));
        ExcelConfig excelConfig = ExcelConfig.initConfigJson(reportTempletDO.getTmpjson());
        List<Column> list = excelConfig.getColumnList();
        for (int i = 0; i < list.size(); i++) {
            Column column =  list.get(i);
            model.addAttribute(column.getField()+"ColumnFlg",true);

        }
        return "lex/reportAllGroup/reportAll";
    }


    @ResponseBody
    @GetMapping("/listGroup")
    public PageUtils listGroup(@RequestParam Map<String, Object> params){
        params.put("managerid",getUserId());
        //查询列表数据
        Query query = new Query(params);
        List<ReportAllDO> reportAllList = reportAllService.listGroup(query);
        int total = reportAllService.countGroup(query);
        PageUtils pageUtils = new PageUtils(reportAllList, total);
        return pageUtils;
    }


    @ResponseBody
    @GetMapping("/listGroupByColumn")
    @RequiresPermissions("lex:reportAllGroup:listGroupByColumn")
    public PageUtils listGroupByColumn(@RequestParam Map<String, Object> params) throws IOException {

        params.put("managerid",getUserId());
        //查询列表数据
        Query query = new Query(params);
        List<ReportAllDO> reportAllList = reportAllService.list(query);
        int total = reportAllService.count(query);
        PageUtils pageUtils = new PageUtils(reportAllList, total);
        return pageUtils;
    }



}

package com.cl.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.cl.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.cl.annotation.IgnoreAuth;
import com.cl.annotation.SysLog;

import com.cl.entity.BisaichengjiEntity;
import com.cl.entity.view.BisaichengjiView;

import com.cl.service.BisaichengjiService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.EncryptUtil;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 比赛成绩
 * 后端接口
 * @author 
 * @email 
 * @date 2024-03-28 11:08:49
 */
@RestController
@RequestMapping("/bisaichengji")
public class BisaichengjiController {
    @Autowired
    private BisaichengjiService bisaichengjiService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,BisaichengjiEntity bisaichengji,
                @RequestParam(required = false) Double bisaifenshustart,
                @RequestParam(required = false) Double bisaifenshuend,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("jiaoshi")) {
			bisaichengji.setJiaoshigonghao((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("xuesheng")) {
			bisaichengji.setXuehao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<BisaichengjiEntity> ew = new EntityWrapper<BisaichengjiEntity>();
                if(bisaifenshustart!=null) ew.ge("bisaifenshu", bisaifenshustart);
                if(bisaifenshuend!=null) ew.le("bisaifenshu", bisaifenshuend);

		PageUtils page = bisaichengjiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, bisaichengji), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,BisaichengjiEntity bisaichengji, 
                @RequestParam(required = false) Double bisaifenshustart,
                @RequestParam(required = false) Double bisaifenshuend,
		HttpServletRequest request){
        EntityWrapper<BisaichengjiEntity> ew = new EntityWrapper<BisaichengjiEntity>();
                if(bisaifenshustart!=null) ew.ge("bisaifenshu", bisaifenshustart);
                if(bisaifenshuend!=null) ew.le("bisaifenshu", bisaifenshuend);

		PageUtils page = bisaichengjiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, bisaichengji), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( BisaichengjiEntity bisaichengji){
       	EntityWrapper<BisaichengjiEntity> ew = new EntityWrapper<BisaichengjiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( bisaichengji, "bisaichengji")); 
        return R.ok().put("data", bisaichengjiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(BisaichengjiEntity bisaichengji){
        EntityWrapper< BisaichengjiEntity> ew = new EntityWrapper< BisaichengjiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( bisaichengji, "bisaichengji")); 
		BisaichengjiView bisaichengjiView =  bisaichengjiService.selectView(ew);
		return R.ok("查询比赛成绩成功").put("data", bisaichengjiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        BisaichengjiEntity bisaichengji = bisaichengjiService.selectById(id);
		bisaichengji = bisaichengjiService.selectView(new EntityWrapper<BisaichengjiEntity>().eq("id", id));
        return R.ok().put("data", bisaichengji);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        BisaichengjiEntity bisaichengji = bisaichengjiService.selectById(id);
		bisaichengji = bisaichengjiService.selectView(new EntityWrapper<BisaichengjiEntity>().eq("id", id));
        return R.ok().put("data", bisaichengji);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    @SysLog("新增比赛成绩")
    public R save(@RequestBody BisaichengjiEntity bisaichengji, HttpServletRequest request){
    	bisaichengji.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(bisaichengji);
        bisaichengjiService.insert(bisaichengji);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @SysLog("新增比赛成绩")
    @RequestMapping("/add")
    public R add(@RequestBody BisaichengjiEntity bisaichengji, HttpServletRequest request){
    	bisaichengji.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(bisaichengji);
        bisaichengjiService.insert(bisaichengji);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    @SysLog("修改比赛成绩")
    public R update(@RequestBody BisaichengjiEntity bisaichengji, HttpServletRequest request){
        //ValidatorUtils.validateEntity(bisaichengji);
        bisaichengjiService.updateById(bisaichengji);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @SysLog("删除比赛成绩")
    public R delete(@RequestBody Long[] ids){
        bisaichengjiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}

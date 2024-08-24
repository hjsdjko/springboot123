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

import com.cl.entity.CanjiabisaiEntity;
import com.cl.entity.view.CanjiabisaiView;

import com.cl.service.CanjiabisaiService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.EncryptUtil;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 参加比赛
 * 后端接口
 * @author 
 * @email 
 * @date 2024-03-28 11:08:50
 */
@RestController
@RequestMapping("/canjiabisai")
public class CanjiabisaiController {
    @Autowired
    private CanjiabisaiService canjiabisaiService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,CanjiabisaiEntity canjiabisai,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("jiaoshi")) {
			canjiabisai.setJiaoshigonghao((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("xuesheng")) {
			canjiabisai.setXuehao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<CanjiabisaiEntity> ew = new EntityWrapper<CanjiabisaiEntity>();

		PageUtils page = canjiabisaiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, canjiabisai), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,CanjiabisaiEntity canjiabisai, 
		HttpServletRequest request){
        EntityWrapper<CanjiabisaiEntity> ew = new EntityWrapper<CanjiabisaiEntity>();

		PageUtils page = canjiabisaiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, canjiabisai), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( CanjiabisaiEntity canjiabisai){
       	EntityWrapper<CanjiabisaiEntity> ew = new EntityWrapper<CanjiabisaiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( canjiabisai, "canjiabisai")); 
        return R.ok().put("data", canjiabisaiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(CanjiabisaiEntity canjiabisai){
        EntityWrapper< CanjiabisaiEntity> ew = new EntityWrapper< CanjiabisaiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( canjiabisai, "canjiabisai")); 
		CanjiabisaiView canjiabisaiView =  canjiabisaiService.selectView(ew);
		return R.ok("查询参加比赛成功").put("data", canjiabisaiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        CanjiabisaiEntity canjiabisai = canjiabisaiService.selectById(id);
		canjiabisai = canjiabisaiService.selectView(new EntityWrapper<CanjiabisaiEntity>().eq("id", id));
        return R.ok().put("data", canjiabisai);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        CanjiabisaiEntity canjiabisai = canjiabisaiService.selectById(id);
		canjiabisai = canjiabisaiService.selectView(new EntityWrapper<CanjiabisaiEntity>().eq("id", id));
        return R.ok().put("data", canjiabisai);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    @SysLog("新增参加比赛")
    public R save(@RequestBody CanjiabisaiEntity canjiabisai, HttpServletRequest request){
    	canjiabisai.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(canjiabisai);
        canjiabisaiService.insert(canjiabisai);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @SysLog("新增参加比赛")
    @RequestMapping("/add")
    public R add(@RequestBody CanjiabisaiEntity canjiabisai, HttpServletRequest request){
    	canjiabisai.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(canjiabisai);
        canjiabisaiService.insert(canjiabisai);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    @SysLog("修改参加比赛")
    public R update(@RequestBody CanjiabisaiEntity canjiabisai, HttpServletRequest request){
        //ValidatorUtils.validateEntity(canjiabisai);
        canjiabisaiService.updateById(canjiabisai);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @SysLog("删除参加比赛")
    public R delete(@RequestBody Long[] ids){
        canjiabisaiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}

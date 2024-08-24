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

import com.cl.entity.BisaileixingEntity;
import com.cl.entity.view.BisaileixingView;

import com.cl.service.BisaileixingService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.EncryptUtil;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 比赛类型
 * 后端接口
 * @author 
 * @email 
 * @date 2024-03-28 11:08:49
 */
@RestController
@RequestMapping("/bisaileixing")
public class BisaileixingController {
    @Autowired
    private BisaileixingService bisaileixingService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,BisaileixingEntity bisaileixing,
		HttpServletRequest request){
        EntityWrapper<BisaileixingEntity> ew = new EntityWrapper<BisaileixingEntity>();

		PageUtils page = bisaileixingService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, bisaileixing), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,BisaileixingEntity bisaileixing, 
		HttpServletRequest request){
        EntityWrapper<BisaileixingEntity> ew = new EntityWrapper<BisaileixingEntity>();

		PageUtils page = bisaileixingService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, bisaileixing), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( BisaileixingEntity bisaileixing){
       	EntityWrapper<BisaileixingEntity> ew = new EntityWrapper<BisaileixingEntity>();
      	ew.allEq(MPUtil.allEQMapPre( bisaileixing, "bisaileixing")); 
        return R.ok().put("data", bisaileixingService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(BisaileixingEntity bisaileixing){
        EntityWrapper< BisaileixingEntity> ew = new EntityWrapper< BisaileixingEntity>();
 		ew.allEq(MPUtil.allEQMapPre( bisaileixing, "bisaileixing")); 
		BisaileixingView bisaileixingView =  bisaileixingService.selectView(ew);
		return R.ok("查询比赛类型成功").put("data", bisaileixingView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        BisaileixingEntity bisaileixing = bisaileixingService.selectById(id);
		bisaileixing = bisaileixingService.selectView(new EntityWrapper<BisaileixingEntity>().eq("id", id));
        return R.ok().put("data", bisaileixing);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        BisaileixingEntity bisaileixing = bisaileixingService.selectById(id);
		bisaileixing = bisaileixingService.selectView(new EntityWrapper<BisaileixingEntity>().eq("id", id));
        return R.ok().put("data", bisaileixing);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    @SysLog("新增比赛类型")
    public R save(@RequestBody BisaileixingEntity bisaileixing, HttpServletRequest request){
    	bisaileixing.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(bisaileixing);
        bisaileixingService.insert(bisaileixing);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @SysLog("新增比赛类型")
    @RequestMapping("/add")
    public R add(@RequestBody BisaileixingEntity bisaileixing, HttpServletRequest request){
    	bisaileixing.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(bisaileixing);
        bisaileixingService.insert(bisaileixing);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    @SysLog("修改比赛类型")
    public R update(@RequestBody BisaileixingEntity bisaileixing, HttpServletRequest request){
        //ValidatorUtils.validateEntity(bisaileixing);
        bisaileixingService.updateById(bisaileixing);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @SysLog("删除比赛类型")
    public R delete(@RequestBody Long[] ids){
        bisaileixingService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}

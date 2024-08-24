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

import com.cl.entity.BisaixinxiEntity;
import com.cl.entity.view.BisaixinxiView;

import com.cl.service.BisaixinxiService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.EncryptUtil;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 比赛信息
 * 后端接口
 * @author 
 * @email 
 * @date 2024-03-28 11:08:49
 */
@RestController
@RequestMapping("/bisaixinxi")
public class BisaixinxiController {
    @Autowired
    private BisaixinxiService bisaixinxiService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,BisaixinxiEntity bisaixinxi,
                @RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") Date bisaishijianstart,
                @RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") Date bisaishijianend,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("jiaoshi")) {
			bisaixinxi.setJiaoshigonghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<BisaixinxiEntity> ew = new EntityWrapper<BisaixinxiEntity>();
                if(bisaishijianstart!=null) ew.ge("bisaishijian", bisaishijianstart);
                if(bisaishijianend!=null) ew.le("bisaishijian", bisaishijianend);

		PageUtils page = bisaixinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, bisaixinxi), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,BisaixinxiEntity bisaixinxi, 
                @RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") Date bisaishijianstart,
                @RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") Date bisaishijianend,
		HttpServletRequest request){
        EntityWrapper<BisaixinxiEntity> ew = new EntityWrapper<BisaixinxiEntity>();
                if(bisaishijianstart!=null) ew.ge("bisaishijian", bisaishijianstart);
                if(bisaishijianend!=null) ew.le("bisaishijian", bisaishijianend);

		PageUtils page = bisaixinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, bisaixinxi), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( BisaixinxiEntity bisaixinxi){
       	EntityWrapper<BisaixinxiEntity> ew = new EntityWrapper<BisaixinxiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( bisaixinxi, "bisaixinxi")); 
        return R.ok().put("data", bisaixinxiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(BisaixinxiEntity bisaixinxi){
        EntityWrapper< BisaixinxiEntity> ew = new EntityWrapper< BisaixinxiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( bisaixinxi, "bisaixinxi")); 
		BisaixinxiView bisaixinxiView =  bisaixinxiService.selectView(ew);
		return R.ok("查询比赛信息成功").put("data", bisaixinxiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        BisaixinxiEntity bisaixinxi = bisaixinxiService.selectById(id);
		bisaixinxi = bisaixinxiService.selectView(new EntityWrapper<BisaixinxiEntity>().eq("id", id));
        return R.ok().put("data", bisaixinxi);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        BisaixinxiEntity bisaixinxi = bisaixinxiService.selectById(id);
		bisaixinxi = bisaixinxiService.selectView(new EntityWrapper<BisaixinxiEntity>().eq("id", id));
        return R.ok().put("data", bisaixinxi);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    @SysLog("新增比赛信息")
    public R save(@RequestBody BisaixinxiEntity bisaixinxi, HttpServletRequest request){
    	bisaixinxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(bisaixinxi);
        bisaixinxiService.insert(bisaixinxi);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @SysLog("新增比赛信息")
    @RequestMapping("/add")
    public R add(@RequestBody BisaixinxiEntity bisaixinxi, HttpServletRequest request){
    	bisaixinxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(bisaixinxi);
        bisaixinxiService.insert(bisaixinxi);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    @SysLog("修改比赛信息")
    public R update(@RequestBody BisaixinxiEntity bisaixinxi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(bisaixinxi);
        bisaixinxiService.updateById(bisaixinxi);//全部更新
        return R.ok();
    }

    /**
     * 审核
     */
    @RequestMapping("/shBatch")
    @Transactional
    @SysLog("审核比赛信息")
    public R update(@RequestBody Long[] ids, @RequestParam String sfsh, @RequestParam String shhf){
        List<BisaixinxiEntity> list = new ArrayList<BisaixinxiEntity>();
        for(Long id : ids) {
            BisaixinxiEntity bisaixinxi = bisaixinxiService.selectById(id);
            bisaixinxi.setSfsh(sfsh);
            bisaixinxi.setShhf(shhf);
            list.add(bisaixinxi);
        }
        bisaixinxiService.updateBatchById(list);
        return R.ok();
    }


    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @SysLog("删除比赛信息")
    public R delete(@RequestBody Long[] ids){
        bisaixinxiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}

package com.cl.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.cl.utils.PageUtils;
import com.cl.utils.Query;


import com.cl.dao.BisaileixingDao;
import com.cl.entity.BisaileixingEntity;
import com.cl.service.BisaileixingService;
import com.cl.entity.view.BisaileixingView;

@Service("bisaileixingService")
public class BisaileixingServiceImpl extends ServiceImpl<BisaileixingDao, BisaileixingEntity> implements BisaileixingService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<BisaileixingEntity> page = this.selectPage(
                new Query<BisaileixingEntity>(params).getPage(),
                new EntityWrapper<BisaileixingEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<BisaileixingEntity> wrapper) {
		  Page<BisaileixingView> page =new Query<BisaileixingView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<BisaileixingView> selectListView(Wrapper<BisaileixingEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public BisaileixingView selectView(Wrapper<BisaileixingEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}

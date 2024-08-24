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


import com.cl.dao.CanjiabisaiDao;
import com.cl.entity.CanjiabisaiEntity;
import com.cl.service.CanjiabisaiService;
import com.cl.entity.view.CanjiabisaiView;

@Service("canjiabisaiService")
public class CanjiabisaiServiceImpl extends ServiceImpl<CanjiabisaiDao, CanjiabisaiEntity> implements CanjiabisaiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<CanjiabisaiEntity> page = this.selectPage(
                new Query<CanjiabisaiEntity>(params).getPage(),
                new EntityWrapper<CanjiabisaiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<CanjiabisaiEntity> wrapper) {
		  Page<CanjiabisaiView> page =new Query<CanjiabisaiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<CanjiabisaiView> selectListView(Wrapper<CanjiabisaiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public CanjiabisaiView selectView(Wrapper<CanjiabisaiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}

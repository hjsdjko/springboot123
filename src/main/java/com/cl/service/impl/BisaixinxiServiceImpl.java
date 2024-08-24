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


import com.cl.dao.BisaixinxiDao;
import com.cl.entity.BisaixinxiEntity;
import com.cl.service.BisaixinxiService;
import com.cl.entity.view.BisaixinxiView;

@Service("bisaixinxiService")
public class BisaixinxiServiceImpl extends ServiceImpl<BisaixinxiDao, BisaixinxiEntity> implements BisaixinxiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<BisaixinxiEntity> page = this.selectPage(
                new Query<BisaixinxiEntity>(params).getPage(),
                new EntityWrapper<BisaixinxiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<BisaixinxiEntity> wrapper) {
		  Page<BisaixinxiView> page =new Query<BisaixinxiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<BisaixinxiView> selectListView(Wrapper<BisaixinxiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public BisaixinxiView selectView(Wrapper<BisaixinxiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
